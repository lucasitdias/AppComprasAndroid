package com.example.appcomprasandroid;

// Importar métodos de validação (asserts) do JUnit
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

// Importar modelos de dados
import com.example.appcomprasandroid.models.Pedido;
import com.example.appcomprasandroid.models.Produto;

// Importar serviço de pedidos
import com.example.appcomprasandroid.services.PedidoService;

// Importar anotação Test (define métodos de teste)
import org.junit.Test;

// Importar estruturas de lista
import java.util.ArrayList;
import java.util.List;

// Classe responsável por testar as funcionalidades do PedidoService
public class PedidoServiceTest {

    // Testar finalização de pedido
    @Test
    public void deveFinalizarPedidoComSucesso() {

        // Inicializar lista de produtos para o pedido
        List<Produto> itens = new ArrayList<>();
        itens.add(new Produto(1, "Teclado RGB", "Mecânico", 250.0, "url", 10));

        // Obter tamanho atual do histórico
        int tamanhoInicial = PedidoService.getHistorico().size();

        // Executar finalização do pedido
        PedidoService.finalizarPedido(itens, 250.0);

        // Validar se o pedido foi adicionado ao histórico
        assertEquals(tamanhoInicial + 1, PedidoService.getHistorico().size());

        // Validar se o status do pedido está correto (Aguardando Envio)
        assertEquals(Pedido.Status.AGUARDANDO_ENVIO, PedidoService.getHistorico().get(0).getStatus());
    }

    // Testar criação de rascunho no carrinho
    @Test
    public void deveAdicionarPedidoRascunho() {

        // Criar itens para o rascunho
        List<Produto> itens = new ArrayList<>();
        itens.add(new Produto(2, "Monitor 144hz", "Gamer", 1200.0, "url", 5));

        // Executar adição de rascunho
        PedidoService.adicionarPedidoRascunho(itens, 1200.0);

        // Validar se o rascunho está no topo da lista
        Pedido rascunho = PedidoService.getHistorico().get(0);
        assertEquals(Pedido.Status.CARRINHO_ABERTO, rascunho.getStatus());
        assertEquals(1200.0, rascunho.getValorTotal(), 0.01);
    }

    // Testar remoção de rascunho
    @Test
    public void deveRemoverRascunhoCorretamente() {

        // Garantir que existe um rascunho
        List<Produto> itens = new ArrayList<>();
        itens.add(new Produto(3, "Mouse Pad", "Extra Grande", 80.0, "url", 20));
        PedidoService.adicionarPedidoRascunho(itens, 80.0);

        // Executar remoção de rascunho
        PedidoService.removerRascunho();

        // Validar que não existe mais nenhum pedido com status CARRINHO_ABERTO
        for (Pedido p : PedidoService.getHistorico()) {
            assertTrue(p.getStatus() != Pedido.Status.CARRINHO_ABERTO);
        }
    }

    // Testar busca de pedido por ID
    @Test
    public void deveBuscarPedidoPorId() {

        // Adicionar um pedido para teste
        List<Produto> itens = new ArrayList<>();
        itens.add(new Produto(4, "Headset", "7.1 Surround", 350.0, "url", 15));
        PedidoService.finalizarPedido(itens, 350.0);

        // Obter o ID do pedido criado
        int idPedido = PedidoService.getHistorico().get(0).getId();

        // Executar busca pelo ID
        Pedido encontrado = PedidoService.getPedidoById(idPedido);

        // Validar se o pedido foi encontrado corretamente
        assertNotNull(encontrado);
        assertEquals(idPedido, encontrado.getId());
    }
}