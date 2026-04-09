package com.example.appcomprasandroid.ui.fragments;

// Importar classe Bundle (usada para passar dados entre componentes)
import android.os.Bundle;

// Importar LayoutInflater (responsável por inflar layouts XML)
import android.view.LayoutInflater;

// Importar View (componente base da interface)
import android.view.View;

// Importar ViewGroup (container de Views)
import android.view.ViewGroup;

// Importar classe Fragment (base para criação de telas reutilizáveis)
import androidx.fragment.app.Fragment;

// Importar classe R (acesso aos recursos do projeto: layouts, ids, etc.)
import com.example.appcomprasandroid.R;

// Fragment responsável pela tela de configurações do aplicativo
public class SettingsFragment extends Fragment {

    // Construtor padrão do Fragment
    public SettingsFragment() {}

    // Método chamado para criar a interface do Fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar o layout XML associado ao Fragment de configurações
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
}