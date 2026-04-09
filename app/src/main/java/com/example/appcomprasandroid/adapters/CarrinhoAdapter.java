package com.example.appcomprasandroid.adapters;

// Importar classe LayoutInflater (responsável por inflar layouts XML em Views)
import android.view.LayoutInflater;

// Importar classe View (componente base da interface)
import android.view.View;

// Importar classe ViewGroup (container de Views)
import android.view.ViewGroup;

// Importar ImageButton (botão com imagem)
import android.widget.ImageButton;

// Importar ImageView (exibição de imagens)
import android.widget.ImageView;

// Importar TextView (exibição de textos)
import android.widget.TextView;

// Importar anotação NonNull (garante que o parâmetro não seja nulo)
import androidx.annotation.NonNull;

// Importar RecyclerView (lista otimizada de elementos)
import androidx.recyclerview.widget.RecyclerView;

// Importar biblioteca Glide (carregamento eficiente de imagens)
import com.bumptech.glide.Glide;

// Importar classe R (acesso aos recursos do projeto)
import com.example.appcomprasandroid.R;

// Importar helper de formatação (ex: moeda)
import com.example.appcomprasandroid.helpers.FormatoHelper;

// Importar modelo Produto (dados do item exibido)
import com.example.appcomprasandroid.models.Produto;

// Importar List (estrutura de lista de dados)
import java.util.List;

// Adapter responsável por exibir os produtos dentro do carrinho
public class CarrinhoAdapter extends RecyclerView.Adapter<CarrinhoAdapter.ViewHolder> {

    // Lista de produtos adicionados ao carrinho
    private List<Produto> lista;

    // Construtor padrão com lista de produtos
    public CarrinhoAdapter(List<Produto> lista) {
        this.lista = lista;
    }

    // Criar layout de cada item do carrinho
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflar layout item_carrinho.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_carrinho, parent, false);

        return new ViewHolder(view);
    }

    // Vincular dados do produto ao item da lista
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Obter produto da posição atual
        Produto produto = lista.get(position);

        // Definir nome do produto
        holder.nome.setText(produto.getNome());

        // Definir preço formatado
        holder.preco.setText(FormatoHelper.formatarMoeda(produto.getPreco()));

        // Carregar imagem do produto usando Glide
        if (produto.getImagemResId() != 0) {
            Glide.with(holder.itemView.getContext())
                    .load(produto.getImagemResId())
                    .fitCenter()
                    .into(holder.imagem);
        }

        // Verificar se existe listener para remoção
        if (listener != null) {

            // Exibir botão de remover
            holder.btnRemover.setVisibility(View.VISIBLE);

            // Configurar ação de remover produto
            holder.btnRemover.setOnClickListener(v -> {
                listener.onRemoverProduto(produto);
            });

        } else {

            // Ocultar botão caso não haja listener
            holder.btnRemover.setVisibility(View.GONE);
        }
    }

    // Retornar quantidade de itens no carrinho
    @Override
    public int getItemCount() {
        return lista.size();
    }

    // Classe ViewHolder responsável por armazenar referências das views
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // TextView para nome do produto
        TextView nome;

        // TextView para preço do produto
        TextView preco;

        // ImageView para imagem do produto
        ImageView imagem;

        // Botão para remover item do carrinho
        ImageButton btnRemover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inicializar componentes do item
            nome = itemView.findViewById(R.id.txtNomeCarrinho);
            preco = itemView.findViewById(R.id.txtPrecoCarrinho);
            imagem = itemView.findViewById(R.id.imgCarrinho);
            btnRemover = itemView.findViewById(R.id.btnRemover);
        }
    }

    // Interface para comunicação de remoção de produto
    public interface CarrinhoListener {

        // Método chamado ao remover um produto do carrinho
        void onRemoverProduto(Produto produto);
    }

    // Listener para eventos do carrinho
    private CarrinhoListener listener;

    // Construtor com listener para ações do carrinho
    public CarrinhoAdapter(List<Produto> lista, CarrinhoListener listener) {
        this.lista = lista;
        this.listener = listener;
    }
}