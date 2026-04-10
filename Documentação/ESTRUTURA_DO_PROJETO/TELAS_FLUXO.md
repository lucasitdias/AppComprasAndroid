# Telas Obrigatórias e Fluxo do App

Este documento detalha o cumprimento do requisito de ter no mínimo 3 telas específicas e como o fluxo de usuário foi estruturado.

### 1. Tela de Listagem de Produtos

- **Onde:** `ProdutosFragment.java` / `fragment_produtos.xml`.
- **O que foi feito:** Uma interface que consome o `ProdutoService` para exibir cards de produtos de informática. Cada card possui imagem, preço, descrição e botões de ação (Adicionar/Favoritar).
- **Como foi feito:** Uso de um `RecyclerView` com um `GridLayoutManager` ou `LinearLayoutManager` para organizar os itens de forma ergonômica.

### 2. Tela de (Carrinho)

- **Onde:** `CarrinhoFragment.java` / `fragment_carrinho.xml`.
- **O que foi feito:** Uma tela que lista os itens adicionados, calcula o total automaticamente e permite a remoção de itens.
- **Como foi feito:** O fragmento observa as mudanças no `CarrinhoService`. Ao alterar a quantidade ou remover um item, a interface é atualizada em tempo real usando o `CarrinhoAdapter`.

### 3. Tela de Confirmação de Compra

- **Onde:** `ConfirmacaoFragment.java` / `fragment_confirmacao.xml`.
- **O que foi feito:** Uma tela de feedback positivo que aparece após o usuário clicar em "Finalizar Compra".
- **Como foi feito:** Esta tela limpa o carrinho via código e exibe uma mensagem de sucesso com um botão para navegar até o histórico de pedidos, garantindo que o ciclo de compra seja fechado corretamente.

### Fluxo de Integração

O fluxo completo segue a lógica:
**Login** -> **Produtos** -> **Adicionar ao Carrinho** -> **Ver Carrinho** -> **Finalizar** -> **Confirmação**.
Toda a transição entre essas telas é feita com animações customizadas (`slide_in`, `slide_out`) localizadas na pasta `res/anim`.
