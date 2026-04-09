package com.example.appcomprasandroid;

// Importar métodos de validação (asserts) do JUnit
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Importar classe Produto (modelo de dados a ser testado)
import com.example.appcomprasandroid.models.Produto;

// Importar anotação Test (define métodos de teste)
import org.junit.Test;

// Classe responsável por testar as funcionalidades da classe Produto
public class ProdutoTest {

    // Testar criação correta do objeto Produto
    @Test
    public void deveCriarProdutoCorretamente() {

        // Criar instância de produto para teste
        Produto produto = new Produto(1, "Teclado Mechanical", "RGB", 250.0, "specs", 101);

        // Validar se o ID foi definido corretamente
        assertEquals(1, produto.getId());

        // Validar se o nome foi definido corretamente
        assertEquals("Teclado Mechanical", produto.getNome());

        // Validar se o preço foi definido corretamente
        assertEquals(250.0, produto.getPreco(), 0.001);

        // Validar se o produto não está marcado como favorito por padrão
        assertFalse(produto.isFavorito());
    }

    // Testar alteração do estado de favorito do produto
    @Test
    public void deveAlterarEstadoDeFavorito() {

        // Criar instância de produto para teste
        Produto produto = new Produto(1, "Mouse", "Desc", 100.0, "specs", 102);

        // Alterar estado do produto para favorito
        produto.setFavorito(true);

        // Validar se o produto foi marcado como favorito
        assertTrue(produto.isFavorito());
    }
}