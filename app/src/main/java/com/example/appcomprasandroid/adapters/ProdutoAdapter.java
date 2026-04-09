package com.example.appcomprasandroid.adapters;

// Importar classe LayoutInflater (responsável por inflar layouts XML em Views)
import android.view.LayoutInflater;

// Importar classe View (componente base da interface)
import android.view.View;

// Importar classe ViewGroup (container de Views)
import android.view.ViewGroup;

// Importar TextView (exibição de textos na interface)
import android.widget.TextView;

// Importar ImageButton (botão com ícone)
import android.widget.ImageButton;

// Importar ImageView (exibição de imagens)
import android.widget.ImageView;

// Importar anotação NonNull (garante que o parâmetro não seja nulo)
import androidx.annotation.NonNull;

// Importar RecyclerView (lista otimizada para exibição de dados)
import androidx.recyclerview.widget.RecyclerView;

// Importar biblioteca Glide (carregamento eficiente de imagens)
import com.bumptech.glide.Glide;

// Importar classe R (acesso aos recursos do projeto: layouts, ids, etc.)
import com.example.appcomprasandroid.R;

// Importar helper de formatação (ex: moeda)
import com.example.appcomprasandroid.helpers.FormatoHelper;

// Importar modelo Produto (representa um item da lista)
import com.example.appcomprasandroid.models.Produto;

// Importar interface de comunicação (callback entre Adapter e Fragment)
import com.example.appcomprasandroid.interfaces.ProdutoCommunication;

// Importar serviço de carrinho (controle de produtos adicionados)
import com.example.appcomprasandroid.services.CarrinhoService;

// Importar List (estrutura de dados para listas)
import java.util.List;

// Adapter responsável por exibir a lista de produtos disponíveis
public class ProdutoAdapter extends RecyclerView.Adapter<ProdutoAdapter.ViewHolder> {

    // Lista de produtos exibidos
    private List<Produto> listaProdutos;

    // Interface de comunicação com o Fragment/Activity
    private ProdutoCommunication communication;

    // Construtor com lista e interface de comunicação
    public ProdutoAdapter(List<Produto> listaProdutos, ProdutoCommunication communication) {
        this.listaProdutos = listaProdutos;
        this.communication = communication;
    }

    // Criar layout de cada item de produto
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflar layout item_produto.xml
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_produto, parent, false);

        return new ViewHolder(view);
    }

    // Vincular dados do produto ao item da lista
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        // Obter produto da posição atual
        Produto produto = listaProdutos.get(position);

        // Definir nome do produto
        holder.nome.setText(produto.getNome());

        // Definir descrição do produto
        holder.descricao.setText(produto.getDescricao());

        // Definir preço formatado
        holder.preco.setText(FormatoHelper.formatarMoeda(produto.getPreco()));

        // Carregar imagem do produto
        if (produto.getImagemResId() != 0) {

            // Usar Glide para carregar imagem
            Glide.with(holder.itemView.getContext())
                    .load(produto.getImagemResId())
                    .fitCenter()
                    .into(holder.imagem);

        } else {

            // Exibir imagem padrão caso não exista
            holder.imagem.setImageResource(android.R.drawable.ic_menu_report_image);
        }

        // Atualizar ícone inicial do favorito
        if (produto.isFavorito()) {

            // Produto marcado como favorito
            holder.btnFavorito.setImageResource(android.R.drawable.btn_star_big_on);
            holder.btnFavorito.setColorFilter(
                    holder.itemView.getContext().getResources()
                            .getColor(android.R.color.holo_orange_light)
            );

        } else {

            // Produto não favorito
            holder.btnFavorito.setImageResource(android.R.drawable.btn_star_big_off);
            holder.btnFavorito.setColorFilter(
                    holder.itemView.getContext().getResources()
                            .getColor(android.R.color.darker_gray)
            );
        }

        // Ação ao clicar no botão de favorito
        holder.btnFavorito.setOnClickListener(v -> {

            // Alternar estado de favorito
            boolean novoEstado = !produto.isFavorito();
            produto.setFavorito(novoEstado);

            // Definir mensagem conforme estado
            String msg = novoEstado ? "Adicionado aos favoritos" : "Removido dos favoritos";

            // Exibir mensagem ao usuário
            android.widget.Toast.makeText(v.getContext(), msg, android.widget.Toast.LENGTH_SHORT).show();

            // Notificar alteração via interface
            communication.onFavoritoAlterado(produto);

            // Atualizar item na lista
            notifyItemChanged(position);
        });

        // Obter quantidade do produto no carrinho
        int qtd = CarrinhoService.getQuantidadeProduto(produto.getId());

        // Atualizar exibição da quantidade
        if (qtd > 0) {

            // Mostrar quantidade e botão de remover
            holder.txtQuantidade.setVisibility(View.VISIBLE);
            holder.btnRemover.setVisibility(View.VISIBLE);
            holder.txtQuantidade.setText(String.valueOf(qtd));

        } else {

            // Ocultar quantidade e botão de remover
            holder.txtQuantidade.setVisibility(View.GONE);
            holder.btnRemover.setVisibility(View.GONE);
        }

        // Ação ao clicar no item para ver detalhes
        holder.itemView.setOnClickListener(v -> {

            // Chamar interface para exibir detalhes
            communication.onVerDetalhes(produto);
        });

        // Ação ao adicionar produto ao carrinho
        holder.btnAdicionar.setOnClickListener(v -> {

            // Notificar adição via interface
            communication.onAdicionarProduto(produto);

            // Atualizar item na lista
            notifyItemChanged(position);
        });

        // Ação ao remover produto do carrinho
        holder.btnRemover.setOnClickListener(v -> {

            // Notificar remoção via interface
            communication.onRemoverProduto(produto);

            // Atualizar item na lista
            notifyItemChanged(position);
        });
    }

    // Retornar quantidade de produtos
    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }

    // ViewHolder responsável por armazenar referências das views
    public static class ViewHolder extends RecyclerView.ViewHolder {

        // Textos de exibição do produto
        TextView nome, descricao, preco, txtQuantidade;

        // Imagem do produto
        ImageView imagem;

        // Botões de ação
        ImageButton btnAdicionar, btnRemover, btnFavorito;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Inicializar componentes do layout
            nome = itemView.findViewById(R.id.txtNome);
            descricao = itemView.findViewById(R.id.txtDescricao);
            preco = itemView.findViewById(R.id.txtPreco);
            imagem = itemView.findViewById(R.id.imgProduto);
            btnAdicionar = itemView.findViewById(R.id.btnAdicionar);
            btnRemover = itemView.findViewById(R.id.btnRemover);
            txtQuantidade = itemView.findViewById(R.id.txtQuantidade);
            btnFavorito = itemView.findViewById(R.id.btnFavorito);
        }
    }
}