package com.example.appcomprasandroid;

// Importar métodos de validação (asserts) do JUnit
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// Importar classe Produto (modelo de dados utilizado nos testes)
import com.example.appcomprasandroid.models.Produto;

// Importar serviço CarrinhoService (responsável pelas operações do carrinho)
import com.example.appcomprasandroid.services.CarrinhoService;

// Importar anotação Before (executado antes de cada teste)
import org.junit.Before;

// Importar anotação Test (define métodos de teste)
import org.junit.Test;

// Classe responsável por testar as funcionalidades do CarrinhoService
public class CarrinhoServiceTest {

    // Método executado antes de cada teste (preparação do ambiente)
    @Before
    public void setup() {

        // Limpar o carrinho para garantir estado inicial consistente
        CarrinhoService.limparCarrinho();
    }

    // Testar adição de produto ao carrinho
    @Test
    public void deveAdicionarProdutoAoCarrinho() {

        // Criar produto de teste
        Produto p = new Produto(1, "Teste", "Desc", 100.0, "", 0);

        // Adicionar produto ao carrinho
        CarrinhoService.adicionarProduto(p);

        // Validar se o carrinho possui 1 item
        assertEquals(1, CarrinhoService.getCarrinho().size());

        // Validar se o valor total foi calculado corretamente
        assertEquals(100.0, CarrinhoService.calcularTotal(), 0.001);
    }

    // Testar cálculo do valor total do carrinho
    @Test
    public void deveCalcularTotalCorretamente() {

        // Adicionar primeiro produto ao carrinho
        CarrinhoService.adicionarProduto(new Produto(1, "P1", "", 50.0, "", 0));

        // Adicionar segundo produto ao carrinho
        CarrinhoService.adicionarProduto(new Produto(2, "P2", "", 150.0, "", 0));

        // Validar se o total corresponde à soma dos produtos
        assertEquals(200.0, CarrinhoService.calcularTotal(), 0.001);
    }

    // Testar limpeza do carrinho
    @Test
    public void deveLimparCarrinho() {

        // Adicionar produto ao carrinho
        CarrinhoService.adicionarProduto(new Produto(1, "P1", "", 50.0, "", 0));

        // Executar limpeza do carrinho
        CarrinhoService.limparCarrinho();

        // Validar se o carrinho está vazio
        assertTrue(CarrinhoService.getCarrinho().isEmpty());
    }
}