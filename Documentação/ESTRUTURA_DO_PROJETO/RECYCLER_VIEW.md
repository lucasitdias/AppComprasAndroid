# Uso de RecyclerView

O **RecyclerView** é um dos componentes mais importantes deste projeto, utilizado para exibir listas de dados de forma eficiente e performática.

### Onde foi aplicado

1.  **Tela de Produtos (`ProdutosFragment`):** Listagem principal de itens de informática.
2.  **Tela de Carrinho (`CarrinhoFragment`):** Listagem dos produtos selecionados pelo usuário.
3.  **Tela de Favoritos (`FavoritosFragment`):** Listagem de itens marcados como favoritos.
4.  **Tela de Pedidos (`PedidosFragment`):** Histórico de compras do usuário.

### Como foi feito

A implementação seguiu o padrão de três camadas:

- **XML Layout:** Criação de um arquivo de layout específico para o item da lista (ex: `item_produto.xml`).
- **ViewHolder:** Uma classe interna no Adapter que armazena as referências das Views (TextViews, ImageViews) para evitar chamadas repetitivas ao `findViewById`.
- **Adapter:** A ponte entre a lista de objetos (Java) e o RecyclerView (Interface).
  - Exemplo: O `ProdutoAdapter` recebe a lista de produtos e "infla" o layout de cada item.

### Por que usar

Diferente de uma `ListView` comum, o `RecyclerView` recicla as views que saem da tela, o que economiza memória RAM e evita travamentos durante a rolagem, garantindo uma experiência de usuário fluida.
