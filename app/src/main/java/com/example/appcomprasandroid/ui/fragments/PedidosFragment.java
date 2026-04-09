package com.example.appcomprasandroid.ui.fragments;

// Importar classe Bundle (armazenar estado do fragment)
import android.os.Bundle;

// Importar LayoutInflater (inflar XML em View)
import android.view.LayoutInflater;

// Importar View (componente base da interface)
import android.view.View;

// Importar ViewGroup (container de Views)
import android.view.ViewGroup;

// Importar Fragment (componente reutilizável de UI)
import androidx.fragment.app.Fragment;

// Importar recursos do projeto (layouts, ids, etc)
import com.example.appcomprasandroid.R;

// Importar layout de lista vertical
import androidx.recyclerview.widget.LinearLayoutManager;

// Importar RecyclerView (lista otimizada)
import androidx.recyclerview.widget.RecyclerView;

// Importar TextView (exibir mensagens na tela)
import android.widget.TextView;

// Importar adapter de pedidos
import com.example.appcomprasandroid.adapters.PedidoAdapter;

// Importar serviço de pedidos
import com.example.appcomprasandroid.services.PedidoService;

// Fragment responsável por exibir o histórico de pedidos
public class PedidosFragment extends Fragment {

    // RecyclerView para listar pedidos
    private RecyclerView recyclerView;

    // Texto exibido quando não há pedidos
    private TextView txtVazio;

    // Construtor padrão do fragment
    public PedidosFragment() {}

    // Método responsável por criar a interface do fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar layout do fragment
        View view = inflater.inflate(R.layout.fragment_pedidos, container, false);

        // Referenciar RecyclerView
        recyclerView = view.findViewById(R.id.recyclerPedidos);

        // Referenciar TextView de lista vazia
        txtVazio = view.findViewById(R.id.txtPedidosVazio);

        // Definir layout da lista como vertical
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Verificar se o histórico de pedidos está vazio
        if (PedidoService.getHistorico().isEmpty()) {

            // Exibir mensagem de lista vazia
            txtVazio.setVisibility(View.VISIBLE);

            // Ocultar lista de pedidos
            recyclerView.setVisibility(View.GONE);

        } else {

            // Ocultar mensagem de vazio
            txtVazio.setVisibility(View.GONE);

            // Exibir lista de pedidos
            recyclerView.setVisibility(View.VISIBLE);

            // Definir adapter com os pedidos
            recyclerView.setAdapter(new PedidoAdapter(PedidoService.getHistorico()));
        }

        // Retornar view do fragment
        return view;
    }
}