package com.example.appcomprasandroid.ui.fragments;

// Importar classe Bundle (armazenar e recuperar estado do Fragment)
import android.os.Bundle;

// Importar classe LayoutInflater (converter XML em View)
import android.view.LayoutInflater;

// Importar classe View (componente base da interface)
import android.view.View;

// Importar classe ViewGroup (container de componentes visuais)
import android.view.ViewGroup;

// Importar classe TextView (exibição de textos na interface)
import android.widget.TextView;

// Importar classe Fragment (componente reutilizável de interface)
import androidx.fragment.app.Fragment;

// Importar classe R (referência aos recursos do projeto)
import com.example.appcomprasandroid.R;

// Importar classe Usuario (modelo de dados do usuário)
import com.example.appcomprasandroid.models.Usuario;

// Fragment responsável por exibir as informações do perfil do usuário
public class PerfilFragment extends Fragment {

    // Construtor padrão do Fragment
    public PerfilFragment() {}

    // Método responsável por criar e configurar a interface do Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar o layout da tela de perfil
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);

        // Inicializar componentes de texto da interface
        TextView txtNome = view.findViewById(R.id.txtPerfilNome);
        TextView txtEmail = view.findViewById(R.id.txtPerfilEmail);
        TextView txtTelefone = view.findViewById(R.id.txtPerfilTelefone);

        // Obter a Activity associada ao Fragment
        if (getActivity() != null && getActivity().getIntent() != null) {

            // Recuperar o usuário logado enviado pela Activity
            Usuario usuario = (Usuario) getActivity().getIntent().getSerializableExtra("usuarioLogado");

            // Validar se o usuário foi encontrado
            if (usuario != null) {

                // Preencher o nome do usuário
                txtNome.setText(usuario.getNome());

                // Preencher o email do usuário
                txtEmail.setText(usuario.getEmail());

                // Preencher telefone ou exibir mensagem padrão
                txtTelefone.setText(usuario.getTelefone().isEmpty() ? "Não informado" : usuario.getTelefone());
            }
        }

        // Retornar a View configurada do Fragment
        return view;
    }
}