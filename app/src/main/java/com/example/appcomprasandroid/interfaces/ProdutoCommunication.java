package com.example.appcomprasandroid.interfaces;

// Importar modelo Produto (utilizado na comunicação entre camadas)
import com.example.appcomprasandroid.models.Produto;

// Interface responsável pela comunicação entre Adapter e Fragment/Activity
public interface ProdutoCommunication {

    // Método chamado ao adicionar um produto ao carrinho
    void onAdicionarProduto(Produto produto);

    // Método chamado ao remover um produto do carrinho
    void onRemoverProduto(Produto produto);

    // Método chamado ao clicar no produto para visualizar detalhes
    void onVerDetalhes(Produto produto);

    // Método opcional chamado ao alterar o estado de favorito do produto
    default void onFavoritoAlterado(Produto produto) {
        // Implementação opcional (pode ser sobrescrita se necessário)
    }
}