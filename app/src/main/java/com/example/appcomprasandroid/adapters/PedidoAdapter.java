package com.example.appcomprasandroid.adapters;

// Importar classe LayoutInflater (responsável por inflar layouts XML em Views)
import android.view.LayoutInflater;

// Importar classe View (componente base da interface)
import android.view.View;

// Importar classe ViewGroup (container de Views)
import android.view.ViewGroup;

// Importar TextView (exibição de textos na interface)
import android.widget.TextView;

// Importar anotação NonNull (garante que o parâmetro não seja nulo)
import androidx.annotation.NonNull;

// Importar RecyclerView (lista otimizada para exibir dados)
import androidx.recyclerview.widget.RecyclerView;

// Importar classe R (acesso aos recursos do projeto: layouts, ids, etc.)
import com.example.appcomprasandroid.R;

// Importar helper de formatação (ex: moeda, lista de itens)
import com.example.appcomprasandroid.helpers.FormatoHelper;

// Importar modelo Pedido (representa um pedido realizado)
import com.example.appcomprasandroid.models.Pedido;

// Importar modelo Produto (itens que compõem o pedido)
import com.example.appcomprasandroid.models.Produto;

// Importar List (estrutura de dados para listas)
import java.util.List;

// Adapter responsável por exibir a lista de pedidos realizados no RecyclerView
public class PedidoAdapter extends RecyclerView.Adapter<PedidoAdapter.ViewHolder> {

    // Lista de pedidos
    private List<Pedido> lista;

    // Construtor com lista de pedidos
    public PedidoAdapter(List<Pedido> lista) {
        this.lista = lista;
    }

    // Criar layout de cada item de pedido
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflar layout item_pedido.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pedido, parent, false);

        return new ViewHolder(view);
    }

    // Vincular dados do pedido ao item da lista
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Obter pedido da posição atual
        Pedido pedido = lista.get(position);

        // Exibir ID do pedido
        holder.txtId.setText("Pedido #" + pedido.getId());

        // Exibir data do pedido
        holder.txtData.setText(pedido.getData());

        // Exibir valor total formatado
        holder.txtTotal.setText("Total: " + FormatoHelper.formatarMoeda(pedido.getValorTotal()));

        // Exibir lista de itens formatada
        holder.txtItens.setText(FormatoHelper.formatarListaItens(pedido.getItens()));

        // Configurar clique no item para abrir detalhes do pedido
        holder.itemView.setOnClickListener(v -> {

            // Verificar se o contexto é uma FragmentActivity
            if (v.getContext() instanceof androidx.fragment.app.FragmentActivity) {

                // Obter FragmentManager da activity
                androidx.fragment.app.FragmentManager fm =
                        ((androidx.fragment.app.FragmentActivity) v.getContext()).getSupportFragmentManager();

                // Navegar para tela de detalhes do pedido com animação
                fm.beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in_right,
                                R.anim.slide_out_left,
                                R.anim.slide_in_left,
                                R.anim.slide_out_right
                        )
                        .replace(
                                R.id.container,
                                com.example.appcomprasandroid.ui.fragments.PedidoDetalhesFragment
                                        .newInstance(pedido.getId())
                        )
                        .addToBackStack(null)
                        .commit();
            }
        });

        // Configurar status e comportamento do pedido
        configurarStatus(holder, pedido);
    }

    // Configurar status visual e ações do pedido
    private void configurarStatus(ViewHolder holder, Pedido pedido) {

        String statusText = "";
        int color = 0xFF757575; // Cor padrão (cinza)

        // Ocultar botão de cancelar por padrão
        holder.btnCancelar.setVisibility(View.GONE);

        // Definir comportamento conforme status do pedido
        switch (pedido.getStatus()) {

            // Pedido ainda em aberto
            case CARRINHO_ABERTO:
                statusText = "CARRINHO ABERTO";
                color = 0xFFFF9800; // Laranja
                break;

            // Pedido aguardando envio
            case AGUARDANDO_ENVIO:
                statusText = "AGUARDANDO ENVIO";
                color = 0xFF2196F3; // Azul

                // Exibir botão de cancelar
                holder.btnCancelar.setVisibility(View.VISIBLE);
                break;

            // Pedido entregue
            case ENTREGUE:
                statusText = "ENTREGUE";
                color = 0xFF4CAF50; // Verde
                break;

            // Pedido finalizado
            case FINALIZADO:
                statusText = "FINALIZADO";
                color = 0xFF388E3C; // Verde escuro
                break;

            // Pedido cancelado
            case CANCELADO:
                statusText = "CANCELADO";
                color = 0xFFB00020; // Vermelho
                break;
        }

        // Atualizar texto do status
        holder.txtStatus.setText(statusText);

        // Atualizar cor de fundo do status
        holder.txtStatus.getBackground().setTint(color);

        // Configurar ação do botão cancelar
        holder.btnCancelar.setOnClickListener(v -> {

            // Atualizar status do pedido para cancelado
            pedido.setStatus(Pedido.Status.CANCELADO);

            // Atualizar lista na tela
            notifyDataSetChanged();

            // Exibir mensagem de confirmação
            android.widget.Toast.makeText(
                    v.getContext(),
                    "Pedido #" + pedido.getId() + " cancelado.",
                    android.widget.Toast.LENGTH_SHORT
            ).show();
        });
    }

    // Retornar quantidade de pedidos
    @Override
    public int getItemCount() {
        return lista.size();
    }

    // ViewHolder responsável por armazenar referências das views
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Textos de exibição do pedido
        TextView txtId, txtData, txtItens, txtTotal, txtStatus;

        // Botão para cancelar pedido
        android.widget.Button btnCancelar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inicializar componentes do layout
            txtId = itemView.findViewById(R.id.txtPedidoId);
            txtData = itemView.findViewById(R.id.txtPedidoData);
            txtItens = itemView.findViewById(R.id.txtPedidoItens);
            txtTotal = itemView.findViewById(R.id.txtPedidoTotal);
            txtStatus = itemView.findViewById(R.id.txtPedidoStatus);
            btnCancelar = itemView.findViewById(R.id.btnCancelarPedido);
        }
    }
}