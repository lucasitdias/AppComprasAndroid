package com.example.appcomprasandroid.activities;

// Importar classe Bundle (armazenar e recuperar estado da Activity)
import android.os.Bundle;

// Importar classe base AppCompatActivity (estrutura principal da Activity)
import androidx.appcompat.app.AppCompatActivity;

// Importar componente ImageButton (botões com ícone)
import android.widget.ImageButton;

// Importar utilitário GravityCompat (controle de abertura de menus laterais)
import androidx.core.view.GravityCompat;

// Importar DrawerLayout (layout de menu lateral - drawer)
import androidx.drawerlayout.widget.DrawerLayout;

// Importar classe Fragment (base para todos os fragments)
import androidx.fragment.app.Fragment;

// Importar recursos da aplicação (layouts, ids, etc.)
import com.example.appcomprasandroid.R;

// Importar serviço de carrinho (gerenciamento de produtos adicionados)
import com.example.appcomprasandroid.services.CarrinhoService;

// Importar fragmento de carrinho (tela de itens selecionados)
import com.example.appcomprasandroid.ui.fragments.CarrinhoFragment;

// Importar fragmento de favoritos (produtos marcados como favoritos)
import com.example.appcomprasandroid.ui.fragments.FavoritosFragment;

// Importar fragmento de pedidos (histórico de compras)
import com.example.appcomprasandroid.ui.fragments.PedidosFragment;

// Importar fragmento de perfil (dados do usuário)
import com.example.appcomprasandroid.ui.fragments.PerfilFragment;

// Importar fragmento de produtos (listagem principal)
import com.example.appcomprasandroid.ui.fragments.ProdutosFragment;

// Importar fragmento de configurações (settings do app)
import com.example.appcomprasandroid.ui.fragments.SettingsFragment;

// Importar BottomNavigationView (menu inferior do app)
import com.google.android.material.bottomnavigation.BottomNavigationView;

// Importar classe Intent (navegação entre Activities)
import android.content.Intent;

// Importar BadgeDrawable (contador de itens no carrinho)
import com.google.android.material.badge.BadgeDrawable;

// Importar NavigationView (menu lateral - drawer)
import com.google.android.material.navigation.NavigationView;
import android.view.View;
import android.widget.TextView;
import com.example.appcomprasandroid.models.Usuario;

// Importar MaterialToolbar (barra superior do app)
import com.google.android.material.appbar.MaterialToolbar;

// Activity principal responsável pelo controle de navegação e gerenciamento de fragments
public class MainActivity extends AppCompatActivity {

    // Componente de navegação inferior do aplicativo
    private BottomNavigationView bottomNavigation;

    // Layout principal que controla o menu lateral
    private DrawerLayout drawerLayout;

    // Menu lateral com opções de navegação
    private NavigationView navigationView;

    // Barra superior do aplicativo
    private MaterialToolbar toolbar;

    // Botão para abrir o menu lateral
    private ImageButton btnMenu;

    // Botão para navegação de voltar
    private ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Definir layout principal da activity
        setContentView(R.layout.activity_main);

        // Inicializar componentes da interface
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigation = findViewById(R.id.bottom_navigation);
        btnMenu = findViewById(R.id.btnMenu);
        btnBack = findViewById(R.id.btnBack);

        // Configurar ação do botão de voltar
        btnBack.setOnClickListener(v -> {

            // Verificar se existe navegação no histórico de fragments
            if (getSupportFragmentManager().getBackStackEntryCount() > 0) {

                // Retornar ao fragment anterior
                getSupportFragmentManager().popBackStack();

            } else {

                // Executar comportamento padrão do botão voltar
                onBackPressed();
            }
        });

        // Atualizar ícone de navegação ao alterar o backstack
        getSupportFragmentManager().addOnBackStackChangedListener(this::atualizarIconeNavegacao);

        // Definir estado inicial do botão de navegação
        atualizarIconeNavegacao();

        // Configurar abertura do menu lateral (drawer)
        btnMenu.setOnClickListener(v -> {

            // Abrir menu lateral pela direita
            drawerLayout.openDrawer(GravityCompat.END);
        });

        // Configurar seleção de itens do menu lateral
        navigationView.setNavigationItemSelectedListener(item -> {

            int itemId = item.getItemId();
            Fragment selectedFragment = null;

            // Navegar para tela de produtos
            if (itemId == R.id.nav_drawer_produtos) {
                selectedFragment = new ProdutosFragment();
                bottomNavigation.setSelectedItemId(R.id.nav_produtos);

                // Navegar para tela do carrinho
            } else if (itemId == R.id.nav_drawer_carrinho) {
                selectedFragment = new CarrinhoFragment();
                bottomNavigation.setSelectedItemId(R.id.nav_carrinho);

                // Navegar para tela de perfil
            } else if (itemId == R.id.nav_drawer_perfil) {
                selectedFragment = new PerfilFragment();

                // Navegar para tela de favoritos
            } else if (itemId == R.id.nav_drawer_favoritos) {
                selectedFragment = new FavoritosFragment();
                bottomNavigation.setSelectedItemId(R.id.nav_favoritos);

                // Navegar para tela de pedidos
            } else if (itemId == R.id.nav_drawer_pedidos) {
                selectedFragment = new PedidosFragment();

                // Navegar para tela de configurações
            } else if (itemId == R.id.nav_drawer_settings) {
                selectedFragment = new SettingsFragment();

                // Realizar logout e retornar para login
            } else if (itemId == R.id.nav_drawer_logout) {
                startActivity(new Intent(this, LoginActivity.class));
                finish();
            }

            // Atualizar fragment exibido se houver seleção válida
            if (selectedFragment != null) {
                substituirFragment(selectedFragment);
            }

            // Fechar menu lateral após seleção
            drawerLayout.closeDrawer(GravityCompat.END);

            return true;
        });

        // Carregar fragment inicial ao abrir o aplicativo
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, new ProdutosFragment())
                    .commit();
        }

        // Configurar navegação inferior (BottomNavigation)
        bottomNavigation.setOnItemSelectedListener(item -> {

            Fragment selectedFragment = null;
            int itemId = item.getItemId();

            // Navegar para produtos
            if (itemId == R.id.nav_produtos) {
                selectedFragment = new ProdutosFragment();

                // Navegar para carrinho
            } else if (itemId == R.id.nav_carrinho) {
                selectedFragment = new CarrinhoFragment();

                // Navegar para favoritos
            } else if (itemId == R.id.nav_favoritos) {
                selectedFragment = new FavoritosFragment();

                // Navegar para pedidos
            } else if (itemId == R.id.nav_pedidos) {
                selectedFragment = new PedidosFragment();
            }

            // Atualizar fragment selecionado
            if (selectedFragment != null) {
                substituirFragment(selectedFragment);
            }

            return true;
        });

        // Atualizar badge do carrinho ao iniciar a activity
        atualizarBadgeCarrinho();

        // Configurar dados do usuário no Navigation Drawer
        configurarDadosUsuario();
    }

    /**
     * Configura o nome e e-mail do usuário logado no cabeçalho do menu lateral.
     */
    private void configurarDadosUsuario() {
        // Tenta obter o usuário vindo da LoginActivity
        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuarioLogado");

        if (usuario != null && navigationView != null) {
            // Acessa a View do cabeçalho
            View headerView = navigationView.getHeaderView(0);
            if (headerView != null) {
                TextView txtNome = headerView.findViewById(R.id.txtHeaderNome);
                TextView txtEmail = headerView.findViewById(R.id.txtHeaderEmail);

                if (txtNome != null) txtNome.setText(usuario.getNome());
                if (txtEmail != null) txtEmail.setText(usuario.getEmail());
            }
        }
    }

    // Substituir fragment atual com animação e adicionar ao histórico
    private void substituirFragment(Fragment fragment) {
        // Obter fragment atual antes da transação
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.container);

        // Evitar substituir pelo mesmo fragment
        if (currentFragment != null && currentFragment.getClass().equals(fragment.getClass())) {
            return;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        android.R.anim.fade_in,
                        android.R.anim.fade_out,
                        android.R.anim.fade_in,
                        android.R.anim.fade_out
                )
                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit();
    }

    // Atualizar visibilidade do botão de voltar conforme navegação
    private void atualizarIconeNavegacao() {

        // Verificar se há fragments na pilha
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {

            // Exibir botão de voltar
            btnBack.setVisibility(android.view.View.VISIBLE);

        } else {

            // Ocultar botão de voltar
            btnBack.setVisibility(android.view.View.GONE);
        }
    }

    // Atualizar badge com quantidade de itens no carrinho
    public void atualizarBadgeCarrinho() {

        // Obter quantidade de produtos no carrinho
        int count = CarrinhoService.getCarrinho().size();

        // Criar ou recuperar badge do carrinho
        BadgeDrawable badge = bottomNavigation.getOrCreateBadge(R.id.nav_carrinho);

        // Exibir badge caso existam itens
        if (count > 0) {
            badge.setVisible(true);
            badge.setNumber(count);

        } else {

            // Ocultar badge caso o carrinho esteja vazio
            badge.setVisible(false);
        }
    }
}