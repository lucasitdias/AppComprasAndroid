package com.example.appcomprasandroid.helpers;

// Importar classe Fragment (representa uma parte reutilizável da interface)
import androidx.fragment.app.Fragment;

// Importar classe FragmentManager (gerencia os Fragments da Activity)
import androidx.fragment.app.FragmentManager;

// Importar classe FragmentTransaction (controla operações entre Fragments)
import androidx.fragment.app.FragmentTransaction;

// Importar classe R (referência ao container de exibição dos Fragments)
import com.example.appcomprasandroid.R;

// Classe utilitária responsável por gerenciar a navegação entre Fragments
public class NavigationHelper {

    // Método responsável por substituir o Fragment atual por um novo
    public static void substituirFragment(FragmentManager fragmentManager, Fragment fragment) {

        // Validar se o gerenciador de fragments e o fragmento são válidos
        if (fragmentManager == null || fragment == null) return;

        // Iniciar uma nova transação de Fragment
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        // Definir animações de transição (entrada e saída com efeito fade)
        transaction.setCustomAnimations(
                android.R.anim.fade_in,
                android.R.anim.fade_out,
                android.R.anim.fade_in,
                android.R.anim.fade_out
        );

        // Substituir o conteúdo do container pelo novo Fragment
        transaction.replace(R.id.container, fragment);

        // Adicionar a transação à pilha de navegação (permite voltar ao Fragment anterior)
        transaction.addToBackStack(null);

        // Finalizar e aplicar a transação na interface
        transaction.commit();
    }
}