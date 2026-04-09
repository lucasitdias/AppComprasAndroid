package com.example.appcomprasandroid.ui.fragments;

// Importar classe Bundle (armazenar dados entre componentes)
import android.os.Bundle;

// Importar LayoutInflater (inflar XML em View)
import android.view.LayoutInflater;

// Importar View (componente base da interface)
import android.view.View;

// Importar ViewGroup (container de Views)
import android.view.ViewGroup;

// Importar Button (botões da interface)
import android.widget.Button;

// Importar CheckBox (não utilizado diretamente, mas disponível)
import android.widget.CheckBox;

// Importar ImageButton (botões com ícone)
import android.widget.ImageButton;

// Importar ImageView (exibir imagens)
import android.widget.ImageView;

// Importar TextView (exibir textos)
import android.widget.TextView;

// Importar Toast (mensagens rápidas)
import android.widget.Toast;

// Importar anotações de nulidade
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// Importar Fragment (componente reutilizável de UI)
import androidx.fragment.app.Fragment;

// Importar biblioteca Glide (carregar imagens)
import com.bumptech.glide.Glide;

// Importar recursos do projeto
import com.example.appcomprasandroid.R;

// Importar Activity principal
import com.example.appcomprasandroid.activities.MainActivity;

// Importar modelo Produto
import com.example.appcomprasandroid.models.Produto;

// Importar serviço do carrinho
import com.example.appcomprasandroid.services.CarrinhoService;

// Importar serviço de produtos
import com.example.appcomprasandroid.services.ProdutoService;

// Importar formatação de moeda
import java.text.NumberFormat;

// Importar localização brasileira
import java.util.Locale;

// Fragment responsável por exibir detalhes do produto
public class ProdutoDetalhesFragment extends Fragment {

    // Chave para receber ID do produto
    private static final String ARG_PRODUTO_ID = "produto_id";

    // ID do produto selecionado
    private int produtoId;

    // Objeto do produto
    private Produto produto;

    // Criar nova instância do fragment com ID do produto
    public static ProdutoDetalhesFragment newInstance(int produtoId) {
        ProdutoDetalhesFragment fragment = new ProdutoDetalhesFragment();

        // Criar bundle para envio de dados
        Bundle args = new Bundle();
        args.putInt(ARG_PRODUTO_ID, produtoId);

        // Associar argumentos ao fragment
        fragment.setArguments(args);

        return fragment;
    }

    // Método chamado na criação do fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Verificar se recebeu argumentos
        if (getArguments() != null) {

            // Recuperar ID do produto
            produtoId = getArguments().getInt(ARG_PRODUTO_ID);

            // Buscar produto na lista
            for (Produto p : ProdutoService.getListaProdutos()) {
                if (p.getId() == produtoId) {
                    produto = p;
                    break;
                }
            }
        }
    }

    // Quantidade selecionada do produto
    private int quantidade = 1;

    // TextView que exibe quantidade
    private TextView txtQuantidade;

    // Criar interface do fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflar layout da tela
        View view = inflater.inflate(R.layout.fragment_produto_detalhes, container, false);

        // Verificar se o produto foi encontrado
        if (produto != null) {

            // Referenciar elementos da tela
            TextView txtNome = view.findViewById(R.id.txtNomeDetalhe);
            TextView txtPreco = view.findViewById(R.id.txtPrecoDetalhe);
            TextView txtDescricao = view.findViewById(R.id.txtDescricaoDetalhe);
            ImageView imgProduto = view.findViewById(R.id.imgDetalheProduto);
            Button btnAdicionar = view.findViewById(R.id.btnAdicionarAoCarrinho);
            Button btnFinalizarDetalhe = view.findViewById(R.id.btnFinalizarCompraDetalhe);

            txtQuantidade = view.findViewById(R.id.txtQuantidade);
            ImageButton btnAumentar = view.findViewById(R.id.btnAumentar);
            ImageButton btnDiminuir = view.findViewById(R.id.btnDiminuir);
            ImageButton btnFavorito = view.findViewById(R.id.btnFavoritoDetalhe);

            // Definir nome do produto
            txtNome.setText(produto.getNome());

            // Formatar preço em moeda brasileira
            NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtPreco.setText(formatador.format(produto.getPreco()));

            // Definir descrição detalhada
            txtDescricao.setText(produto.getEspecificacoes());

            // Carregar imagem do produto
            if (produto.getImagemResId() != 0) {
                Glide.with(this)
                        .load(produto.getImagemResId())
                        .centerInside()
                        .into(imgProduto);
            }

            // Aumentar quantidade
            btnAumentar.setOnClickListener(v -> {
                quantidade++;
                txtQuantidade.setText(String.valueOf(quantidade));
                atualizarEstadoQuantidade(btnDiminuir);
            });

            // Diminuir quantidade
            btnDiminuir.setOnClickListener(v -> {
                if (quantidade > 0) {
                    quantidade--;
                    txtQuantidade.setText(String.valueOf(quantidade));
                    atualizarEstadoQuantidade(btnDiminuir);
                }
            });

            // Atualizar estado inicial do botão diminuir
            atualizarEstadoQuantidade(btnDiminuir);

            // Atualizar ícone inicial do favorito
            atualizarIconeFavorito(btnFavorito);

            // Alternar estado de favorito
            btnFavorito.setOnClickListener(v -> {
                boolean novoEstado = !produto.isFavorito();
                produto.setFavorito(novoEstado);

                // Atualizar ícone
                atualizarIconeFavorito(btnFavorito);

                // Exibir mensagem
                String msg = novoEstado ? "Adicionado aos favoritos" : "Removido dos favoritos";
                Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
            });

            // Adicionar produto ao carrinho
            btnAdicionar.setOnClickListener(v -> {

                // Adicionar conforme quantidade
                for (int i = 0; i < quantidade; i++) {
                    CarrinhoService.adicionarProduto(produto);
                }

                // Exibir mensagem
                Toast.makeText(getContext(), quantidade + " produto(s) adicionado(s) ao carrinho!", Toast.LENGTH_SHORT).show();

                // Atualizar botão finalizar
                atualizarBotaoFinalizar(btnFinalizarDetalhe);

                // Atualizar badge do carrinho
                if (getActivity() instanceof MainActivity) {
                    ((MainActivity) getActivity()).atualizarBadgeCarrinho();
                }
            });

            // Configurar estado inicial do botão finalizar
            atualizarBotaoFinalizar(btnFinalizarDetalhe);

            // Navegar para carrinho
            btnFinalizarDetalhe.setOnClickListener(v -> {
                getParentFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                android.R.anim.fade_in,
                                android.R.anim.fade_out,
                                android.R.anim.fade_in,
                                android.R.anim.fade_out
                        )
                        .replace(R.id.container, new CarrinhoFragment())
                        .addToBackStack(null)
                        .commit();
            });
        }

        return view;
    }

    // Atualizar estado do botão de diminuir quantidade
    private void atualizarEstadoQuantidade(ImageButton btnDiminuir) {

        // Verificar se quantidade é zero
        if (quantidade <= 0) {

            // Desabilitar botão
            btnDiminuir.setEnabled(false);
            btnDiminuir.setAlpha(0.3f);

        } else {

            // Habilitar botão
            btnDiminuir.setEnabled(true);
            btnDiminuir.setAlpha(1.0f);
        }
    }

    // Atualizar estado do botão finalizar compra
    private void atualizarBotaoFinalizar(Button btnFinalizar) {

        // Verificar se carrinho está vazio
        if (CarrinhoService.getCarrinho().isEmpty()) {

            // Desabilitar botão
            btnFinalizar.setEnabled(false);
            btnFinalizar.setAlpha(0.5f);

        } else {

            // Habilitar botão
            btnFinalizar.setEnabled(true);
            btnFinalizar.setAlpha(1.0f);
        }
    }

    // Atualizar ícone de favorito
    private void atualizarIconeFavorito(ImageButton btn) {

        // Verificar se produto é favorito
        if (produto.isFavorito()) {

            // Ícone de favorito ativo
            btn.setImageResource(android.R.drawable.btn_star_big_on);
            btn.setColorFilter(getResources().getColor(android.R.color.holo_orange_light));

        } else {

            // Ícone de favorito inativo
            btn.setImageResource(android.R.drawable.btn_star_big_off);
            btn.setColorFilter(getResources().getColor(android.R.color.darker_gray));
        }
    }
}