package com.example.appcomprasandroid.services;

// Importar modelo Produto (representa os itens adicionados ao carrinho)
import com.example.appcomprasandroid.models.Produto;

// Importar ArrayList (implementação de lista dinâmica)
import java.util.ArrayList;

// Importar List (estrutura de dados para manipulação de listas)
import java.util.List;

// Classe responsável por gerenciar o carrinho de compras
public class CarrinhoService {

    // Lista estática que armazena os produtos do carrinho
    private static List<Produto> carrinho = new ArrayList<>();

    // Adicionar produto ao carrinho
    public static void adicionarProduto(Produto produto) {

        // Inserir produto na lista
        carrinho.add(produto);

        // Atualizar ou criar rascunho de pedido com os itens atuais
        PedidoService.adicionarPedidoRascunho(
                new ArrayList<>(carrinho),
                calcularTotal()
        );
    }

    // Retornar lista atual do carrinho
    public static List<Produto> getCarrinho() {
        return carrinho;
    }

    // Calcular valor total dos produtos no carrinho
    public static double calcularTotal() {

        double total = 0;

        // Somar preços de todos os produtos
        for (Produto produto : carrinho) {
            total += produto.getPreco();
        }

        // Retornar valor total
        return total;
    }

    // Limpar todos os itens do carrinho
    public static void limparCarrinho() {

        // Remover todos os produtos da lista
        carrinho.clear();

        // Observação: não removemos o rascunho automaticamente
    }

    // Remover um produto do carrinho
    public static void removerProduto(Produto produto) {

        // Remover produto da lista
        carrinho.remove(produto);

        // Verificar se o carrinho ficou vazio
        if (carrinho.isEmpty()) {

            // Remover rascunho de pedido se não houver itens
            PedidoService.removerRascunho();

        } else {

            // Atualizar rascunho com os itens restantes
            PedidoService.adicionarPedidoRascunho(
                    new ArrayList<>(carrinho),
                    calcularTotal()
            );
        }
    }

    // Retornar quantidade de um produto específico no carrinho
    public static int getQuantidadeProduto(int produtoId) {

        int count = 0;

        // Contar quantas vezes o produto aparece na lista
        for (Produto p : carrinho) {
            if (p.getId() == produtoId) {
                count++;
            }
        }

        // Retornar quantidade encontrada
        return count;
    }
}