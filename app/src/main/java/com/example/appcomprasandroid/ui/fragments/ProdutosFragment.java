package com.example.appcomprasandroid.ui.fragments;

// Importar classe Bundle (armazenar estado do fragment)
import android.os.Bundle;

// Importar Button (não utilizado diretamente, mas disponível)
import android.widget.Button;

// Importar Toast (mensagens rápidas)
import android.widget.Toast;

// Importar Fragment (componente reutilizável de UI)
import androidx.fragment.app.Fragment;

// Importar layout de lista vertical
import androidx.recyclerview.widget.LinearLayoutManager;

// Importar RecyclerView (lista otimizada)
import androidx.recyclerview.widget.RecyclerView;

// Importar LayoutInflater (inflar XML em View)
import android.view.LayoutInflater;

// Importar View (componente base da interface)
import android.view.View;

// Importar ViewGroup (container de Views)
import android.view.ViewGroup;

// Importar recursos do projeto
import com.example.appcomprasandroid.R;

// Importar adapter de produtos
import com.example.appcomprasandroid.adapters.ProdutoAdapter;

// Importar modelo Produto
import com.example.appcomprasandroid.models.Produto;

// Importar serviço de produtos
import com.example.appcomprasandroid.services.ProdutoService;

// Importar serviço do carrinho
import com.example.appcomprasandroid.services.CarrinhoService;

// Importar Activity principal
import com.example.appcomprasandroid.activities.MainActivity;

// Importar interface de comunicação do produto
import com.example.appcomprasandroid.interfaces.ProdutoCommunication;

// Importar lista
import java.util.List;

// Fragment responsável por exibir a listagem de produtos
public class ProdutosFragment extends Fragment implements ProdutoCommunication {

    // RecyclerView para listar produtos
    private RecyclerView recyclerView;

    // Construtor padrão do fragment
    public ProdutosFragment() {}

    // Criar interface do fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar layout da tela de produtos
        View view = inflater.inflate(R.layout.fragment_produtos, container, false);

        // Referenciar RecyclerView
        recyclerView = view.findViewById(R.id.recyclerProdutos);

        // Definir layout da lista como vertical
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Criar adapter com lista de produtos
        ProdutoAdapter adapter = new ProdutoAdapter(
                ProdutoService.getListaProdutos(),
                this
        );

        // Definir adapter no RecyclerView
        recyclerView.setAdapter(adapter);

        // Retornar view do fragment
        return view;
    }

    // Método chamado ao adicionar produto ao carrinho
    @Override
    public void onAdicionarProduto(Produto produto) {

        // Adicionar produto ao carrinho
        CarrinhoService.adicionarProduto(produto);

        // Atualizar badge do carrinho
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).atualizarBadgeCarrinho();
        }
    }

    // Método chamado ao remover produto do carrinho
    @Override
    public void onRemoverProduto(Produto produto) {

        // Remover produto do carrinho
        CarrinhoService.removerProduto(produto);

        // Atualizar badge do carrinho
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).atualizarBadgeCarrinho();
        }
    }

    // Método chamado ao clicar para ver detalhes do produto
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