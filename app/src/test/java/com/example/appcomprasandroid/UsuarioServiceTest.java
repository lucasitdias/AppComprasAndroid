package com.example.appcomprasandroid;

// Importar métodos de validação (asserts) do JUnit
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

// Importar classe Usuario (modelo de dados utilizado nos testes)
import com.example.appcomprasandroid.models.Usuario;

// Importar classe UsuarioService (responsável pelas operações de usuário)
import com.example.appcomprasandroid.services.UsuarioService;

// Importar anotação Before (executado antes de cada teste)
import org.junit.Before;

// Importar anotação Test (define métodos de teste)
import org.junit.Test;

// Importar classe UUID (geração de identificadores únicos)
import java.util.UUID;

// Classe responsável por testar as funcionalidades do UsuarioService
public class UsuarioServiceTest {

    // Instância do serviço de usuários
    private UsuarioService service;

    // Método executado antes de cada teste (preparação do ambiente)
    @Before
    public void setup() {

        // Inicializar instância do serviço (Singleton)
        service = UsuarioService.getInstance();
    }

    // Testar login com credenciais válidas
    @Test
    public void deveRealizarLoginComSucesso() {

        // Utilizar usuário padrão definido no sistema
        Usuario usuario = service.login("admin@app.com", "123456");

        // Validar se o usuário foi autenticado com sucesso
        assertNotNull(usuario);
    }

    // Testar falha no login com senha incorreta
    @Test
    public void deveFalharLoginComSenhaIncorreta() {

        // Tentar login com senha inválida
        Usuario usuario = service.login("admin@app.com", "senha_errada");

        // Validar se o retorno é nulo (falha na autenticação)
        assertNull(usuario);
    }

    // Testar cadastro de novo usuário
    @Test
    public void deveCadastrarNovoUsuario() {

        // Gerar email único para evitar conflito
        String email = "novo" + UUID.randomUUID() + "@teste.com";

        // Criar novo usuário para cadastro
        Usuario novo = new Usuario(UUID.randomUUID().toString(), "Teste", email, "123", "");

        // Executar cadastro do usuário
        boolean sucesso = service.cadastrar(novo);

        // Validar se o cadastro foi realizado com sucesso
        assertTrue(sucesso);

        // Validar se é possível realizar login com o novo usuário
        assertNotNull(service.login(email, "123"));
    }
}