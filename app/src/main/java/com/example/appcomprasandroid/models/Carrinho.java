package com.example.appcomprasandroid.models;

// Importar classe ArrayList (lista dinâmica para armazenamento de dados)
import java.util.ArrayList;

// Importar interface List (estrutura de coleção de elementos)
import java.util.List;

// Classe responsável por representar o carrinho de compras do sistema
public class Carrinho {

    // Lista de produtos adicionados ao carrinho
    private List<Produto> itens;

    // Construtor responsável por inicializar o carrinho com lista vazia
    public Carrinho() {
        this.itens = new ArrayList<>();
    }

    // Retornar a lista de itens do carrinho (utilizado para exibição)
    public List<Produto> getItens() {
        return itens;
    }

    // Atualizar a lista completa de itens do carrinho
    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }

    // Adicionar um novo produto ao carrinho
    public void adicionarItem(Produto produto) {

        // Validar se o produto é válido antes de adicionar
        if (produto != null) {
            this.itens.add(produto);
        }
    }

    // Remover um produto específico do carrinho
    public void removerItem(Produto produto) {
        this.itens.remove(produto);
    }

    // Calcular o valor total somando o preço de todos os itens
    public double getValorTotal() {

        // Inicializar variável acumuladora do total
        double total = 0.0;

        // Percorrer todos os produtos do carrinho
        for (Produto produto : itens) {

            // Somar o preço de cada produto ao total
            total += produto.getPreco();
        }

        // Retornar o valor total calculado
        return total;
    }

    // Retornar a quantidade de itens no carrinho (usado para badge)
    public int getQuantidadeItens() {
        return itens.size();
    }

    // Limpar todos os itens do carrinho após finalização da compra
    public void limpar() {
        itens.clear();
    }
}