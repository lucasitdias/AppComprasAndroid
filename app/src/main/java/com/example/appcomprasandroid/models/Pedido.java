package com.example.appcomprasandroid.models;

// Importar List (estrutura de dados para lista de produtos)
import java.util.List;

// Classe que representa um pedido realizado pelo usuário
public class Pedido {

    // Enum responsável por definir os possíveis status do pedido
    public enum Status {

        // Produto adicionado ao carrinho, mas ainda não finalizado
        CARRINHO_ABERTO,

        // Pedido finalizado e aguardando envio
        AGUARDANDO_ENVIO,

        // Pedido entregue ao cliente
        ENTREGUE,

        // Pedido finalizado com sucesso
        FINALIZADO,

        // Pedido cancelado
        CANCELADO
    }

    // Identificador único do pedido
    private int id;

    // Lista de produtos que compõem o pedido
    private List<Produto> itens;

    // Valor total do pedido
    private double valorTotal;

    // Data em que o pedido foi realizado
    private String data;

    // Status atual do pedido
    private Status status;

    // Construtor responsável por criar um novo pedido
    public Pedido(int id, List<Produto> itens, double valorTotal, String data, Status status) {
        this.id = id;
        this.itens = itens;
        this.valorTotal = valorTotal;
        this.data = data;
        this.status = status;
    }

    // Retornar o ID do pedido
    public int getId() {
        return id;
    }

    // Retornar a lista de itens do pedido
    public List<Produto> getItens() {
        return itens;
    }

    // Retornar o valor total do pedido
    public double getValorTotal() {
        return valorTotal;
    }

    // Retornar a data do pedido
    public String getData() {
        return data;
    }

    // Retornar o status atual do pedido
    public Status getStatus() {
        return status;
    }

    // Atualizar o status do pedido
    public void setStatus(Status status) {
        this.status = status;
    }
}