package com.example.appcomprasandroid.services;

// Importar classe Pedido (modelo de dados dos pedidos)
import com.example.appcomprasandroid.models.Pedido;

// Importar classe Produto (modelo de dados dos produtos)
import com.example.appcomprasandroid.models.Produto;

// Importar classe para formatação de data
import java.text.SimpleDateFormat;

// Importar lista dinâmica
import java.util.ArrayList;

// Importar classe para trabalhar com datas
import java.util.Date;

// Importar interface de lista
import java.util.List;

// Importar classe para definir localidade (idioma/região)
import java.util.Locale;

// Classe responsável por gerenciar os pedidos e histórico
public class PedidoService {

    // Lista estática que armazena o histórico de pedidos
    private static List<Pedido> historicoPedidos = new ArrayList<>();

    // Controle de ID incremental dos pedidos
    private static int proximoId = 1;

    // Finalizar pedido e adicionar ao histórico
    public static void finalizarPedido(List<Produto> itens, double total) {

        // Gerar data atual formatada
        String data = new SimpleDateFormat(
                "dd/MM/yyyy HH:mm",
                Locale.getDefault()
        ).format(new Date());

        // Criar novo pedido com status de aguardando envio
        Pedido novoPedido = new Pedido(
                proximoId++,
                new ArrayList<>(itens),
                total,
                data,
                Pedido.Status.AGUARDANDO_ENVIO
        );

        // Adicionar pedido no topo da lista
        historicoPedidos.add(0, novoPedido);
    }

    // Criar ou atualizar pedido rascunho (carrinho aberto)
    public static void adicionarPedidoRascunho(List<Produto> itens, double total) {

        // Remover rascunhos anteriores para evitar duplicação
        historicoPedidos.removeIf(
                p -> p.getStatus() == Pedido.Status.CARRINHO_ABERTO
        );

        // Verificar se existem itens no carrinho
        if (!itens.isEmpty()) {

            // Gerar data atual
            String data = new SimpleDateFormat(
                    "dd/MM/yyyy HH:mm",
                    Locale.getDefault()
            ).format(new Date());

            // Criar novo rascunho de pedido
            Pedido rascunho = new Pedido(
                    proximoId++,
                    new ArrayList<>(itens),
                    total,
                    data,
                    Pedido.Status.CARRINHO_ABERTO
            );

            // Adicionar rascunho no topo da lista
            historicoPedidos.add(0, rascunho);
        }
    }

    // Remover rascunho do carrinho aberto
    public static void removerRascunho() {

        // Remover pedidos com status de carrinho aberto
        historicoPedidos.removeIf(
                p -> p.getStatus() == Pedido.Status.CARRINHO_ABERTO
        );
    }

    // Retornar histórico completo de pedidos
    public static List<Pedido> getHistorico() {
        return historicoPedidos;
    }

    // Buscar pedido pelo ID
    public static Pedido getPedidoById(int id) {

        // Percorrer lista de pedidos
        for (Pedido p : historicoPedidos) {

            // Verificar se o ID corresponde
            if (p.getId() == id) {
                return p;
            }
        }

        // Retornar null caso não encontre
        return null;
    }
}