package com.example.appcomprasandroid.ui.fragments;

// Importar classe Bundle (armazenamento de estado)
import android.os.Bundle;

// Importar classe base Fragment
import androidx.fragment.app.Fragment;

// Importar classes de layout e views
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Importar componente Button
import android.widget.Button;

// Importar recursos do projeto
import com.example.appcomprasandroid.R;

// Importar Activity principal (para atualizar badge e navegação)
import com.example.appcomprasandroid.activities.MainActivity;

// Importar serviço do carrinho
import com.example.appcomprasandroid.services.CarrinhoService;

// Importar serviço de pedidos
import com.example.appcomprasandroid.services.PedidoService;

// Fragment responsável por finalizar e confirmar a compra
public class ConfirmacaoFragment extends Fragment {

    // Botão para voltar para tela de pedidos
    private Button btnVoltar;

    // Construtor padrão obrigatório
    public ConfirmacaoFragment() {}

    // Criar e configurar a interface do fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflar layout da tela de confirmação
        View view = inflater.inflate(R.layout.fragment_confirmacao, container, false);

        // Inicializar botão
        btnVoltar = view.findViewById(R.id.btnVoltarInicio);

        // Definir texto do botão
        btnVoltar.setText("Meus Pedidos");

        // Verificar se existem produtos no carrinho
        if (!CarrinhoService.getCarrinho().isEmpty()) {

            // Finalizar pedido com os itens atuais do carrinho
            PedidoService.finalizarPedido(
                    CarrinhoService.getCarrinho(),
                    CarrinhoService.calcularTotal()
            );

            // Remover rascunho do pedido
            PedidoService.removerRascunho();

            // Limpar carrinho após finalizar compra
            CarrinhoService.limparCarrinho();

            // Atualizar badge do carrinho na MainActivity
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).atualizarBadgeCarrinho();
            }
        }

        // Configurar ação do botão voltar
        btnVoltar.setOnClickListener(v -> {

            // Verificar se está dentro da MainActivity
            if (getActivity() instanceof MainActivity) {

                // Obter referência da activity
                MainActivity activity = (MainActivity) getActivity();

                // Simular clique no menu inferior para ir para "Pedidos"
                activity.findViewById(R.id.nav_pedidos).performClick();

            } else {

                // Navegação manual caso não esteja na MainActivity
                getParentFragmentManager()
                        .beginTransaction()
                        .setCustomAnimations(
                                R.anim.slide_in_right,
                                R.anim.slide_out_left,
                                R.anim.slide_in_left,
                                R.anim.slide_out_right
                        )
                        .replace(R.id.container, new PedidosFragment())
                        .commit();
            }
        });

        // Retornar view do fragmento
        return view;
    }
}