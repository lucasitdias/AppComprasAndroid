package com.example.appcomprasandroid.ui.fragments;

// Importar classe Bundle (armazenamento de estado)
import android.os.Bundle;

// Importar classes de layout e views
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Importar componentes de interface
import android.widget.TextView;

// Importar classe base Fragment
import androidx.fragment.app.Fragment;

// Importar layout linear para RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager;

// Importar RecyclerView (lista de itens)
import androidx.recyclerview.widget.RecyclerView;

// Importar recursos do projeto
import com.example.appcomprasandroid.R;

// Importar adapter de produtos
import com.example.appcomprasandroid.adapters.ProdutoAdapter;

// Importar interface de comunicação com adapter
import com.example.appcomprasandroid.interfaces.ProdutoCommunication;

// Importar modelo Produto
import com.example.appcomprasandroid.models.Produto;

// Importar serviço do carrinho
import com.example.appcomprasandroid.services.CarrinhoService;

// Importar serviço de produtos
import com.example.appcomprasandroid.services.ProdutoService;

// Importar Activity principal (para atualizar badge)
import com.example.appcomprasandroid.activities.MainActivity;

// Importar estruturas de lista
import java.util.ArrayList;
import java.util.List;

// Fragment responsável por exibir produtos favoritos
public class FavoritosFragment extends Fragment implements ProdutoCommunication {

    // RecyclerView para listar produtos favoritos
    private RecyclerView recyclerView;

    // TextView para exibir mensagem de lista vazia
    private TextView txtVazio;

    // Adapter dos produtos favoritos
    private ProdutoAdapter adapter;

    // Lista de produtos favoritos
    private List<Produto> favoritos = new ArrayList<>();

    // Construtor padrão obrigatório
    public FavoritosFragment() {}

    // Criar e configurar a interface do fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar layout do fragmento
        View view = inflater.inflate(R.layout.fragment_favoritos, container, false);

        // Inicializar componentes da interface
        recyclerView = view.findViewById(R.id.recyclerFavoritos);
        txtVazio = view.findViewById(R.id.txtFavoritosVazio);

        // Definir layout vertical para lista
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Carregar lista de favoritos
        carregarFavoritos();

        return view;
    }

    // Carregar produtos marcados como favoritos
    private void carregarFavoritos() {

        // Limpar lista atual
        favoritos.clear();

        // Percorrer lista de produtos disponíveis
        for (Produto p : ProdutoService.getListaProdutos()) {

            // Verificar se o produto está marcado como favorito
            if (p.isFavorito()) {
                favoritos.add(p);
            }
        }

        // Verificar se a lista de favoritos está vazia
        if (favoritos.isEmpty()) {

            // Exibir mensagem de lista vazia
            txtVazio.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);

        } else {

            // Exibir lista de favoritos
            txtVazio.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);

            // Criar adapter com lista de favoritos
            adapter = new ProdutoAdapter(favoritos, this);

            // Definir adapter na RecyclerView
            recyclerView.setAdapter(adapter);
        }
    }

    // Ação ao adicionar produto ao carrinho
    @Override
    public void onAdicionarProduto(Produto produto) {

        // Adicionar produto ao carrinho
        CarrinhoService.adicionarProduto(produto);

        // Atualizar badge do carrinho
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).atualizarBadgeCarrinho();
        }
    }

    // Ação ao remover produto do carrinho
    @Override
    public void onRemoverProduto(Produto produto) {

        // Remover produto do carrinho
        CarrinhoService.removerProduto(produto);

        // Atualizar badge do carrinho
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).atualizarBadgeCarrinho();
        }
    }

    // Ação ao alterar estado de favorito
    @Override
    public void onFavoritoAlterado(Produto produto) {

        // Verificar se o produto foi removido dos favoritos
        if (!produto.isFavorito()) {

            // Buscar posição do produto na lista
            int position = favoritos.indexOf(produto);

            // Verificar se o produto existe na lista
            if (position != -1) {

                // Remover produto da lista
                favoritos.remove(position);

                // Atualizar item removido na interface
                adapter.notifyItemRemoved(position);

                // Verificar se a lista ficou vazia após remoção
                if (favoritos.isEmpty()) {

                    // Exibir mensagem de lista vazia
                    txtVazio.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                }
            }
        }
    }

    // Ação ao clicar para ver detalhes do produto
    @Override
    public void onVerDetalhes(Produto produto) {

        // Navegar para tela de detalhes do produto
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.container, ProdutoDetalhesFragment.newInstance(produto.getId()))
                .addToBackStack(null)
                .commit();
    }
}