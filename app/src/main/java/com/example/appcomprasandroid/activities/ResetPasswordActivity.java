package com.example.appcomprasandroid.activities;

// Importar classe Bundle (responsável por armazenar e recuperar estado da Activity)
import android.os.Bundle;

// Importar componente Button (representa botões clicáveis na interface)
import android.widget.Button;

// Importar componente TextView (responsável por exibir textos na tela)
import android.widget.TextView;

// Importar classe Toast (exibir mensagens rápidas para o usuário)
import android.widget.Toast;

// Importar classe AppCompatActivity (classe base para Activities modernas)
import androidx.appcompat.app.AppCompatActivity;

// Importar classe R (acesso aos recursos do projeto como layouts, ids e strings)
import com.example.appcomprasandroid.R;
import com.example.appcomprasandroid.services.UsuarioService;

// Importar TextInputEditText (campo de entrada de texto com padrão Material Design)
import com.google.android.material.textfield.TextInputEditText;

// Activity responsável pela recuperação de senha do usuário
public class ResetPasswordActivity extends AppCompatActivity {

    // Campo de entrada para email do usuário
    private TextInputEditText editEmail;

    // Botão para enviar solicitação de redefinição de senha
    private Button btnEnviarReset;

    // Texto clicável para voltar à tela de login
    private TextView txtVoltarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Definir layout da tela de redefinição de senha
        setContentView(R.layout.activity_reset_password);

        // Inicializar campo de email
        editEmail = findViewById(R.id.editResetEmail);

        // Inicializar botão de envio
        btnEnviarReset = findViewById(R.id.btnEnviarReset);

        // Inicializar opção de voltar ao login
        txtVoltarLogin = findViewById(R.id.txtVoltarLogin);

        // Ação ao clicar no botão de enviar redefinição de senha
        btnEnviarReset.setOnClickListener(v -> {

            // Capturar email digitado pelo usuário
            String email = editEmail.getText().toString();

            // Verificar se o campo está vazio
            if (email.isEmpty()) {

                // Exibir mensagem de erro caso não tenha sido preenchido
                Toast.makeText(this, "Por favor, digite seu e-mail", Toast.LENGTH_SHORT).show();

            } else {

                // Verifica se o e-mail existe no UsuarioService
                if (UsuarioService.getInstance().verificarEmailExistente(email)) {
                    // Simular envio de link de recuperação de senha
                    Toast.makeText(this, "Link de redefinição enviado para: " + email, Toast.LENGTH_LONG).show();

                    // Finalizar activity e retornar para login
                    finish();
                } else {
                    // Caso o e-mail não seja encontrado
                    Toast.makeText(this, "E-mail não encontrado no sistema", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Ação ao clicar para voltar à tela de login
        txtVoltarLogin.setOnClickListener(v -> {

            // Encerrar a tela atual
            finish();
        });
    }
}