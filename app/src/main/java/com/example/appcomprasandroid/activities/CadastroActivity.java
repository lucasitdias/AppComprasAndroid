package com.example.appcomprasandroid.activities;

// Importar classe Bundle (armazenar e recuperar estado da Activity)
import android.os.Bundle;

// Importar componente Button (botões interativos da interface)
import android.widget.Button;

// Importar componente TextView (exibição de textos na tela)
import android.widget.TextView;

// Importar classe Toast (mensagens rápidas para o usuário)
import android.widget.Toast;

// Importar classe base AppCompatActivity (estrutura principal da Activity)
import androidx.appcompat.app.AppCompatActivity;

// Importar classe R (referência aos recursos do projeto: layout, ids, etc.)
import com.example.appcomprasandroid.R;
import com.example.appcomprasandroid.models.Usuario;
import com.example.appcomprasandroid.services.UsuarioService;

// Importar componente TextInputEditText (campo de entrada com Material Design)
import com.google.android.material.textfield.TextInputEditText;

import java.util.UUID;

// Activity responsável pelo cadastro de novos usuários
public class CadastroActivity extends AppCompatActivity {

    // Campo de entrada para nome do usuário
    private TextInputEditText editNome;

    // Campo de entrada para email do usuário
    private TextInputEditText editEmail;

    // Campo de entrada para senha do usuário
    private TextInputEditText editSenha;

    // Botão para realizar o cadastro
    private Button btnCadastrar;

    // Texto clicável para voltar à tela de login
    private TextView txtIrParaLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Definir layout da tela de cadastro
        setContentView(R.layout.activity_cadastro);

        // Inicializar campos de entrada
        editNome = findViewById(R.id.editCadastroNome);
        editEmail = findViewById(R.id.editCadastroEmail);
        editSenha = findViewById(R.id.editCadastroSenha);

        // Inicializar botão de cadastro
        btnCadastrar = findViewById(R.id.btnCadastrar);

        // Inicializar opção de voltar para login
        txtIrParaLogin = findViewById(R.id.txtIrParaLogin);

        // Ação ao clicar no botão de cadastrar
        btnCadastrar.setOnClickListener(v -> {

            // Capturar dados digitados pelo usuário
            String nome = editNome.getText().toString();
            String email = editEmail.getText().toString();
            String senha = editSenha.getText().toString();

            // Validar se todos os campos foram preenchidos
            if (nome.isEmpty() || email.isEmpty() || senha.isEmpty()) {

                // Exibir mensagem de erro caso algum campo esteja vazio
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

            } else {

                // Cria o novo usuário
                Usuario novoUsuario = new Usuario(
                        UUID.randomUUID().toString(),
                        nome,
                        email,
                        senha,
                        "" // Telefone opcional no cadastro simples
                );

                // Tenta cadastrar via UsuarioService
                if (UsuarioService.getInstance().cadastrar(novoUsuario)) {
                    // Exibir mensagem de sucesso no cadastro
                    Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

                    // Finalizar a activity e retornar para tela anterior
                    finish();
                } else {
                    // Caso o e-mail já esteja em uso
                    Toast.makeText(this, "Este e-mail já está cadastrado", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Ação ao clicar para voltar ao login
        txtIrParaLogin.setOnClickListener(v -> finish());
    }
}