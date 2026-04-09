package com.example.appcomprasandroid;

// Importar métodos de validação (asserts) do JUnit
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

// Importar classe Produto (modelo de dados utilizado nos testes)
import com.example.appcomprasandroid.models.Produto;

// Importar classe ProdutoService (responsável pelo gerenciamento de produtos)
import com.example.appcomprasandroid.services.ProdutoService;

// Importar anotação Test (define métodos de teste)
import org.junit.Test;

// Importar interface List (estrutura de coleção de elementos)
import java.util.List;

// Classe responsável por testar as funcionalidades do ProdutoService
public class ProdutoServiceTest {

    // Testar se a lista de produtos não está vazia
    @Test
    public void deveRetornarListaDeProdutosNaoVazia() {

        // Obter lista de produtos do serviço
        List<Produto> produtos = ProdutoService.getListaProdutos();

        // Validar se a lista não é nula
        assertNotNull(produtos);

        // Validar se a lista possui elementos
        assertFalse(produtos.isEmpty());
    }

    // Testar se a lista contém produtos padrão
    @Test
    public void deveConterProdutosPadrao() {

        // Obter lista de produtos do serviço
        List<Produto> produtos = ProdutoService.getListaProdutos();

        // Validar se o primeiro produto corresponde ao padrão definido
        assertTrue(produtos.get(0).getNome().contains("Dell G15"));
    }
}