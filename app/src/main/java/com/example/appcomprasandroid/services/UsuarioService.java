package com.example.appcomprasandroid.services;

// Importar classe Usuario (modelo de dados do usuário)
import com.example.appcomprasandroid.models.Usuario;

// Importar classe ArrayList (lista dinâmica para armazenamento de dados)
import java.util.ArrayList;

// Importar interface List (estrutura de coleção de elementos)
import java.util.List;

// Classe responsável pelo gerenciamento de usuários (cadastro, login e validações)
public class UsuarioService {

    // Instância única da classe (padrão Singleton)
    private static UsuarioService instance;

    // Lista de usuários em memória (simula um banco de dados)
    private final List<Usuario> usuarios;

    // Construtor privado responsável por inicializar o serviço (Singleton)
    private UsuarioService() {

        // Inicializar lista de usuários
        usuarios = new ArrayList<>();

        // Adicionar usuário padrão para facilitar testes
        usuarios.add(new Usuario("1", "Administrador", "admin@app.com", "123456", "11999999999"));
    }

    // Retornar a instância única do serviço (garante apenas um objeto na aplicação)
    public static synchronized UsuarioService getInstance() {

        // Verificar se a instância ainda não foi criada
        if (instance == null) {
            instance = new UsuarioService();
        }

        // Retornar instância existente
        return instance;
    }

    // Realizar login do usuário com base no email e senha
    public Usuario login(String email, String senha) {

        // Percorrer lista de usuários cadastrados
        for (Usuario u : usuarios) {

            // Validar se o email e senha correspondem
            if (u.getEmail().equalsIgnoreCase(email) && u.getSenha().equals(senha)) {
                return u;
            }
        }

        // Retornar null caso não encontre usuário válido
        return null;
    }

    // Cadastrar um novo usuário no sistema
    public boolean cadastrar(Usuario usuario) {

        // Verificar se o e-mail já está cadastrado
        for (Usuario u : usuarios) {

            // Comparar e-mails ignorando maiúsculas/minúsculas
            if (u.getEmail().equalsIgnoreCase(usuario.getEmail())) {
                return false;
            }
        }

        // Adicionar usuário à lista e retornar resultado da operação
        return usuarios.add(usuario);
    }

    // Verificar se um e-mail já existe no sistema
    public boolean verificarEmailExistente(String email) {

        // Percorrer lista de usuários
        for (Usuario u : usuarios) {

            // Validar existência do e-mail
            if (u.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }

        // Retornar falso caso não encontre o e-mail
        return false;
    }

    // Retornar lista de usuários cadastrados (uso administrativo)
    public List<Usuario> getUsuarios() {

        // Retornar uma cópia da lista para evitar alterações externas
        return new ArrayList<>(usuarios);
    }
}