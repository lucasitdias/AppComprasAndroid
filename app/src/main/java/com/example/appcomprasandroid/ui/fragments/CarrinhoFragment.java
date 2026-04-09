package com.example.appcomprasandroid.ui.fragments;

// Importar classe Bundle (armazenamento de dados de estado)
import android.os.Bundle;

// Importar classe base Fragment
import androidx.fragment.app.Fragment;

// Importar layout linear para RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager;

// Importar RecyclerView (lista de itens)
import androidx.recyclerview.widget.RecyclerView;

// Importar classes de layout e views
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// Importar componentes de interface
import android.widget.Button;
import android.widget.TextView;

// Importar classes para formatação de moeda
import java.text.NumberFormat;
import java.util.Locale;

// Importar recursos do projeto
import com.example.appcomprasandroid.R;

// Importar Activity principal (para atualizar badge)
import com.example.appcomprasandroid.activities.MainActivity;

// Importar adapter do carrinho
import com.example.appcomprasandroid.adapters.CarrinhoAdapter;

// Importar modelo Produto
import com.example.appcomprasandroid.models.Produto;

// Importar serviço do carrinho
import com.example.appcomprasandroid.services.CarrinhoService;

// Fragment responsável por exibir o carrinho de compras
public class CarrinhoFragment extends Fragment {

    // RecyclerView para listar produtos do carrinho
    private RecyclerView recyclerView;

    // Botão para confirmar compra
    private Button btnConfirmar;

    // TextView para exibir o total da compra
    private TextView txtTotal;

    // Construtor padrão obrigatório
    public CarrinhoFragment() {}

    // Criar e configurar a interface do fragmento
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflar layout do fragmento
        View view = inflater.inflate(R.layout.fragment_carrinho, container, false);

        // Inicializar componentes da interface
        txtTotal = view.findViewById(R.id.txtTotal);
        recyclerView = view.findViewById(R.id.recyclerCarrinho);
        btnConfirmar = view.findViewById(R.id.btnConfirmar);

        // Atualizar valor total ao iniciar
        atualizarTotal();

        // Definir layout vertical para lista
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Criar adapter com lista do carrinho e ação de remover produto
        CarrinhoAdapter adapter = new CarrinhoAdapter(
                CarrinhoService.getCarrinho(),
                this::onRemoverProduto
        );

        // Definir adapter na RecyclerView
        recyclerView.setAdapter(adapter);

        // Configurar ação do botão confirmar compra
        btnConfirmar.setOnClickListener(v -> {

            // Navegar para tela de confirmação
            getParentFragmentManager()
                    .beginTransaction()
                    .setCustomAnimations(
                            R.anim.slide_in_right,
                            R.anim.slide_out_left,
                            R.anim.slide_in_left,
                            R.anim.slide_out_right
                    )
                    .replace(R.id.container, new ConfirmacaoFragment())
                    .addToBackStack(null)
                    .commit();
        });

        return view;
    }

    // Atualizar dados sempre que o fragmento voltar para a tela
    @Override
    public void onResume() {
        super.onResume();

        // Recarregar lista do carrinho
        if (recyclerView != null) {
            recyclerView.setAdapter(new CarrinhoAdapter(
                    CarrinhoService.getCarrinho(),
                    this::onRemoverProduto
            ));
        }

        // Atualizar total da compra
        atualizarTotal();
    }

    // Método chamado ao remover um produto do carrinho
    private void onRemoverProduto(Produto produto) {

        // Remover produto do carrinho
        CarrinhoService.removerProduto(produto);

        // Atualizar lista exibida
        recyclerView.setAdapter(new CarrinhoAdapter(
                CarrinhoService.getCarrinho(),
                this::onRemoverProduto
        ));

        // Atualizar total da compra
        atualizarTotal();

        // Atualizar badge do carrinho na MainActivity
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).atualizarBadgeCarrinho();
        }
    }

    // Calcular e exibir o total da compra
    private void atualizarTotal() {

        // Calcular valor total do carrinho
        double total = CarrinhoService.calcularTotal();

        // Criar formatador de moeda brasileira
        NumberFormat formatador = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        // Converter total para formato monetário
        String totalFormatado = formatador.format(total);

        // Exibir total formatado na tela
        txtTotal.setText(getString(R.string.total_carrinho, totalFormatado));

        // Desativar botão se não houver itens
        if (total <= 0) {
            btnConfirmar.setEnabled(false);
            btnConfirmar.setAlpha(0.5f);
        } else {
            // Ativar botão se houver itens
            btnConfirmar.setEnabled(true);
            btnConfirmar.setAlpha(1.0f);
        }
    }
}