package com.example.appcomprasandroid.models;

// Importar interface Serializable (permite converter o objeto para ser transportado entre Activities)
import java.io.Serializable;

// Classe responsável por representar o usuário do sistema
public class Usuario implements Serializable {

    // Identificador único do usuário
    private String id;

    // Nome do usuário
    private String nome;

    // Email do usuário (utilizado para login)
    private String email;

    // Senha do usuário
    private String senha;

    // Telefone do usuário
    private String telefone;

    // Construtor responsável por inicializar os dados do usuário
    public Usuario(String id, String nome, String email, String senha, String telefone) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.telefone = telefone;
    }

    // Retornar o identificador do usuário
    public String getId() {
        return id;
    }

    // Atualizar o identificador do usuário
    public void setId(String id) {
        this.id = id;
    }

    // Retornar o nome do usuário
    public String getNome() {
        return nome;
    }

    // Atualizar o nome do usuário
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Retornar o email do usuário
    public String getEmail() {
        return email;
    }

    // Atualizar o email do usuário
    public void setEmail(String email) {
        this.email = email;
    }

    // Retornar a senha do usuário
    public String getSenha() {
        return senha;
    }

    // Atualizar a senha do usuário
    public void setSenha(String senha) {
        this.senha = senha;
    }

    // Retornar o telefone do usuário
    public String getTelefone() {
        return telefone;
    }

    // Atualizar o telefone do usuário
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}