package com.example.appcomprasandroid.activities;

// Importar classe Intent (responsável por navegação entre Activities)
import android.content.Intent;

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

// Importar classe R (referência aos recursos do projeto: layouts, ids, etc.)
import com.example.appcomprasandroid.R;
import com.example.appcomprasandroid.models.Usuario;
import com.example.appcomprasandroid.services.UsuarioService;

// Importar componente TextInputEditText (campo de entrada com Material Design)
import com.google.android.material.textfield.TextInputEditText;

// Activity responsável pelo login do usuário
public class LoginActivity extends AppCompatActivity {

    // Campo de entrada para email
    private TextInputEditText editEmail;

    // Campo de entrada para senha
    private TextInputEditText editSenha;

    // Botão para realizar login
    private Button btnLogin;

    // Texto para navegar para tela de cadastro
    private TextView txtIrParaCadastro;

    // Texto para navegar para recuperação de senha
    private TextView txtEsqueciSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Definir layout da tela de login
        setContentView(R.layout.activity_login);

        // Inicializar campos de entrada
        editEmail = findViewById(R.id.editLoginEmail);
        editSenha = findViewById(R.id.editLoginSenha);

        // Inicializar botão de login
        btnLogin = findViewById(R.id.btnLogin);

        // Inicializar opções de navegação
        txtIrParaCadastro = findViewById(R.id.txtIrParaCadastro);
        txtEsqueciSenha = findViewById(R.id.txtEsqueciSenha);

        // Ação ao clicar no botão de login
        btnLogin.setOnClickListener(v -> {

            // Capturar dados digitados pelo usuário
            String email = editEmail.getText().toString();
            String senha = editSenha.getText().toString();

            // Verificar se os campos estão vazios
            if (email.isEmpty() || senha.isEmpty()) {

                // Exibir mensagem de erro caso algum campo esteja vazio
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();

            } else {

                // Valida o usuário com o UsuarioService
                Usuario usuario = UsuarioService.getInstance().login(email, senha);

                if (usuario != null) {
                    // Navegar para a tela principal do aplicativo
                    Intent intent = new Intent(this, MainActivity.class);
                    // Passa o objeto usuário autenticado
                    intent.putExtra("usuarioLogado", usuario);
                    startActivity(intent);

                    // Finalizar a tela de login
                    finish();
                } else {
                    // Caso as credenciais sejam inválidas
                    Toast.makeText(this, "E-mail ou senha incorretos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Ação ao clicar para ir para tela de cadastro
        txtIrParaCadastro.setOnClickListener(v -> {

            // Navegar para a tela de cadastro
            startActivity(new Intent(this, CadastroActivity.class));
        });

        // Ação ao clicar para ir para recuperação de senha
        txtEsqueciSenha.setOnClickListener(v -> {

            // Navegar para a tela de redefinição de senha
            startActivity(new Intent(this, ResetPasswordActivity.class));
        });
    }
}