package com.example.appcomprasandroid;

// Importar métodos de validação (asserts) do JUnit
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

// Importar classe FormatoHelper (responsável por formatações de dados)
import com.example.appcomprasandroid.helpers.FormatoHelper;

// Importar classe Produto (modelo utilizado nos testes de lista)
import com.example.appcomprasandroid.models.Produto;

// Importar anotação Test (define métodos de teste)
import org.junit.Test;

// Importar classe ArrayList (lista dinâmica para testes)
import java.util.ArrayList;

// Importar interface List (estrutura de coleção de elementos)
import java.util.List;

// Classe responsável por testar as funcionalidades do FormatoHelper
public class FormatoHelperTest {

    // Testar formatação de valores monetários
    @Test
    public void deveFormatarMoedaCorretamente() {

        // Definir valor de teste
        double valor = 1500.50;

        // Executar formatação de moeda
        String resultado = FormatoHelper.formatarMoeda(valor);

        // Validar se contém símbolo de moeda (Real)
        assertTrue(resultado.contains("R$"));

        // Validar se o valor está formatado corretamente
        assertTrue(resultado.contains("1.500,50"));
    }

    // Testar formatação de quantidade (singular e plural)
    @Test
    public void deveFormatarQuantidadeSingularPlural() {

        // Validar quantidade singular
        assertEquals("1 item", FormatoHelper.formatarQuantidade(1));

        // Validar quantidade plural
        assertEquals("5 itens", FormatoHelper.formatarQuantidade(5));

        // Validar quantidade zero
        assertEquals("0 itens", FormatoHelper.formatarQuantidade(0));
    }

    // Testar formatação de lista vazia
    @Test
    public void deveFormatarListaDeItensVazia() {

        // Criar lista vazia
        String resultado = FormatoHelper.formatarListaItens(new ArrayList<>());

        // Validar mensagem de lista vazia
        assertEquals("Itens: (vazio)", resultado);
    }

    // Testar formatação de lista com produtos
    @Test
    public void deveFormatarListaDeItensComProdutos() {

        // Inicializar lista de produtos
        List<Produto> produtos = new ArrayList<>();

        // Adicionar primeiro produto
        produtos.add(new Produto(1, "Notebook", "Desc", 3000.0, "img", 10));

        // Adicionar segundo produto
        produtos.add(new Produto(2, "Mouse", "Desc", 100.0, "img", 5));

        // Executar formatação da lista
        String resultado = FormatoHelper.formatarListaItens(produtos);

        // Validar se os nomes dos produtos foram formatados corretamente
        assertEquals("Itens: Notebook, Mouse", resultado);
    }
}