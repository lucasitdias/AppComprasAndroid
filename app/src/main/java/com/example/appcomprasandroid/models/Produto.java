package com.example.appcomprasandroid.models;

// Classe que representa um produto disponível para compra
public class Produto {

    // Identificador único do produto
    private int id;

    // Nome do produto
    private String nome;

    // Descrição resumida do produto
    private String descricao;

    // Preço do produto
    private double preco;

    // Especificações detalhadas do produto
    private String especificacoes;

    // ID da imagem associada ao produto (drawable)
    private int imagemResId;

    // Indica se o produto está marcado como favorito
    private boolean favorito;

    // Construtor para criar um novo produto
    public Produto(int id, String nome, String descricao, double preco, String especificacoes, int imagemResId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.especificacoes = especificacoes;
        this.imagemResId = imagemResId;

        // Inicializar produto como não favorito
        this.favorito = false;
    }

    // Retornar ID do produto
    public int getId() {
        return id;
    }

    // Retornar nome do produto
    public String getNome() {
        return nome;
    }

    // Retornar descrição do produto
    public String getDescricao() {
        return descricao;
    }

    // Retornar preço do produto
    public double getPreco() {
        return preco;
    }

    // Retornar especificações do produto
    public String getEspecificacoes() {
        return especificacoes;
    }

    // Retornar ID da imagem do produto
    public int getImagemResId() {
        return imagemResId;
    }

    // Verificar se o produto é favorito
    public boolean isFavorito() {
        return favorito;
    }

    // Definir estado de favorito do produto
    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}