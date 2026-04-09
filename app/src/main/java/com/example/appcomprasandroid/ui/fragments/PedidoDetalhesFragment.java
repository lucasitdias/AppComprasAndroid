package com.example.appcomprasandroid.ui.fragments;

// Importar classe Bundle (armazenar dados entre componentes)
import android.os.Bundle;

// Importar LayoutInflater (inflar XML em View)
import android.view.LayoutInflater;

// Importar View (elemento base da interface)
import android.view.View;

// Importar ViewGroup (container de Views)
import android.view.ViewGroup;

// Importar Button (botões da interface)
import android.widget.Button;

// Importar TextView (exibição de textos)
import android.widget.TextView;

// Importar anotações para controle de nulidade
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

// Importar Fragment (componente reutilizável de UI)
import androidx.fragment.app.Fragment;

// Importar RecyclerView (lista otimizada)
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// Importar recursos do projeto (layouts, ids, etc)
import com.example.appcomprasandroid.R;

// Importar adapter reutilizado para exibir itens do pedido
import com.example.appcomprasandroid.adapters.CarrinhoAdapter;

// Importar modelo Pedido
import com.example.appcomprasandroid.models.Pedido;

// Importar serviço de pedidos
import com.example.appcomprasandroid.services.PedidoService;

// Importar formatação de moeda
import java.text.NumberFormat;

// Importar localização (pt-BR)
import java.util.Locale;

// Fragment responsável por exibir detalhes de um pedido específico
public class PedidoDetalhesFragment extends Fragment {

    // Chave usada para recuperar o ID do pedido
    private static final String ARG_PEDIDO_ID = "pedido_id";

    // Armazenar ID do pedido
    private int pedidoId;

    // Objeto do pedido selecionado
    private Pedido pedido;

    // Criar nova instância do fragment passando ID do pedido
    public static PedidoDetalhesFragment newInstance(int pedidoId) {
        PedidoDetalhesFragment fragment = new PedidoDetalhesFragment();

        // Criar bundle para enviar dados
        Bundle args = new Bundle();
        args.putInt(ARG_PEDIDO_ID, pedidoId);

        // Associar argumentos ao fragment
        fragment.setArguments(args);

        return fragment;
    }

    // Método chamado na criação do fragment
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Verificar se existem argumentos recebidos
        if (getArguments() != null) {

            // Recuperar ID do pedido
            pedidoId = getArguments().getInt(ARG_PEDIDO_ID);

            // Buscar pedido no serviço
            pedido = PedidoService.getPedidoById(pedidoId);
        }
    }

    // Criar e configurar a interface do fragment
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflar layout do fragment
        View view = inflater.inflate(R.layout.fragment_pedido_detalhes, container, false);

        // Verificar se o pedido existe
        if (pedido != null) {

            // Referenciar elementos da tela
            TextView txtId = view.findViewById(R.id.txtDetPedidoId);
            TextView txtStatus = view.findViewById(R.id.txtDetPedidoStatus);
            TextView txtData = view.findViewById(R.id.txtDetPedidoData);
            TextView txtTotal = view.findViewById(R.id.txtDetPedidoTotal);
            RecyclerView recycler = view.findViewById(R.id.recyclerItensPedido);

            // Exibir ID do pedido
            txtId.setText("Pedido #" + pedido.getId());

            // Exibir data do pedido
            txtData.setText("Data: " + pedido.getData());

            // Formatar valor total em moeda brasileira
            NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
            txtTotal.setText("Total: " + formatador.format(pedido.getValorTotal()));

            // Referenciar botões de ação
            Button btnCancelar = view.findViewById(R.id.btnCancelarDetPedido);
            Button btnFinalizar = view.findViewById(R.id.btnFinalizarDetPedido);

            // Configurar status visual do pedido
            configurarStatus(txtStatus, btnCancelar, btnFinalizar, pedido.getStatus());

            // Se for carrinho aberto, permitir finalizar
            if (pedido.getStatus() == Pedido.Status.CARRINHO_ABERTO) {

                btnFinalizar.setVisibility(View.VISIBLE);

                btnFinalizar.setOnClickListener(v -> {

                    // Navegar para tela de carrinho
                    if (getActivity() instanceof com.example.appcomprasandroid.activities.MainActivity) {

                        ((com.example.appcomprasandroid.activities.MainActivity) getActivity())
                                .findViewById(R.id.nav_carrinho)
                                .performClick();

                    } else {

                        // Navegação manual alternativa
                        getParentFragmentManager()
                                .beginTransaction()
                                .setCustomAnimations(
                                        R.anim.slide_in_right,
                                        R.anim.slide_out_left,
                                        R.anim.slide_in_left,
                                        R.anim.slide_out_right
                                )
                                .replace(R.id.container, new CarrinhoFragment())
                                .addToBackStack(null)
                                .commit();
                    }
                });
            }

            // Se estiver aguardando envio, permitir cancelar
            if (pedido.getStatus() == Pedido.Status.AGUARDANDO_ENVIO) {

                btnCancelar.setVisibility(View.VISIBLE);

                btnCancelar.setOnClickListener(v -> {

                    // Alterar status para cancelado
                    pedido.setStatus(Pedido.Status.CANCELADO);

                    // Atualizar visual
                    configurarStatus(txtStatus, btnCancelar, btnFinalizar, pedido.getStatus());

                    // Exibir mensagem
                    android.widget.Toast.makeText(getContext(), "Pedido Cancelado", android.widget.Toast.LENGTH_SHORT).show();
                });

            } else {

                // Ocultar botão se não aplicável
                if (pedido.getStatus() != Pedido.Status.CARRINHO_ABERTO) {
                    btnCancelar.setVisibility(View.GONE);
                }
            }

            // Configurar RecyclerView dos itens do pedido
            recycler.setLayoutManager(new LinearLayoutManager(getContext()));

            // Reutilizar adapter do carrinho (sem botão remover)
            recycler.setAdapter(new CarrinhoAdapter(pedido.getItens(), null));
        }

        return view;
    }

    // Atualizar status visual do pedido (texto + cor)
    private void configurarStatus(TextView txtStatus, Button btnCancelar, Button btnFinalizar, Pedido.Status status) {

        String statusText = "";
        int color = 0xFF757575; // Cor padrão (cinza)

        // Ocultar botão finalizar por padrão
        if (btnFinalizar != null) btnFinalizar.setVisibility(View.GONE);

        // Definir comportamento conforme status
        switch (status) {

            case CARRINHO_ABERTO:
                statusText = "CARRINHO ABERTO";
                color = 0xFFFF9800; // Laranja
                if (btnFinalizar != null) btnFinalizar.setVisibility(View.VISIBLE);
                break;

            case AGUARDANDO_ENVIO:
                statusText = "AGUARDANDO ENVIO";
                color = 0xFF2196F3; // Azul
                break;

            case ENTREGUE:
                statusText = "ENTREGUE";
                color = 0xFF4CAF50; // Verde
                break;

            case FINALIZADO:
                statusText = "FINALIZADO";
                color = 0xFF388E3C; // Verde escuro
                break;

            case CANCELADO:
                statusText = "CANCELADO";
                color = 0xFFB00020; // Vermelho
                if (btnCancelar != null) btnCancelar.setVisibility(View.GONE);
                break;
        }

        // Aplicar texto e cor no status
        txtStatus.setText(statusText);
        txtStatus.getBackground().setTint(color);
    }
}