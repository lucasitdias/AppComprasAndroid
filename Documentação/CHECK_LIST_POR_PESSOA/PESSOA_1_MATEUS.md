# Relatório de Contribuição: Mateus

Segue minha contrinbuição no desenvolvimento do projeto TechStore, focando na construção da espinha dorsal lógica do aplicativo: Modelos, Adaptadores e Serviços.

---

## Responsabilidades Técnicas Implementadas

Mateus foi o responsável por garantir que os dados do aplicativo fossem estruturados, processados e exibidos corretamente nas listas.

### 1. Estruturas de Dados (Models)

Implementei as classes fundamentais que representam as entidades do negócio:

- **`Produto.java`**: Definição técnica dos itens de informática (ID, nome, preço, especificações). Incluiu a lógica de estado para "Favoritos".
- **`Pedido.java`**: Estrutura que armazena a instância de uma compra realizada, incluindo data, lista de produtos, valor total e status (Entregue, Cancelado, etc).
- **Gerenciamento de Carrinho**: Lógica integrada ao `CarrinhoService` para manipulação de coleções de produtos.

### 2. Camada de exibição (Adapters)

Desenvolvi os adaptadores necessários para o funcionamento das `RecyclerViews`:

- **`ProdutoAdapter.java`**: Responsável por "inflar" o layout dos produtos e vincular os dados da lista às views da interface. Implementou o padrão _ViewHolder_ para otimização de performance.
- **`CarrinhoAdapter.java`**: Adaptador especializado para a cesta de compras, permitindo a visualização e interação (remoção) de itens em tempo real.
- **`PedidoAdapter.java`**: Responsável por renderizar o histórico de pedidos com cores dinâmicas baseadas no status da compra.

### 3. Lógica de Negócio (Services)

Construi a camada de serviços que simula o backend do aplicativo:

- **`ProdutoService.java`**: Repositório centralizado de produtos com métodos de consulta e filtragem.
- **`CarrinhoService.java`**: Gerenciador global do estado da compra. Implementou métodos críticos como `adicionarProduto`, `removerProduto` e o algoritmo de `calcularTotal`.
- **`PedidoService.java`**: Gerencia a finalização de compras e a persistência temporária (rascunhos) dos pedidos.

---

## Interfaces de Comunicação

Para garantir a desacoplagem do código, implementei interfaces de contrato:

- **`ProdutoCommunication.java`**: Interface que permite a comunicação segura entre o Adapter (onde o clique ocorre) e o Fragment (onde a ação é processada), garantindo que a seleção de um produto atualize o carrinho e a interface global.

---

## Cronograma e Entregas

| Etapa                        | Status       | Descrição                                         |
| :--------------------------- | :----------- | :------------------------------------------------ |
| **Definição de Estrutura**   | ✅ Concluído | Criação das classes base (POJOs).                 |
| **Implementação de Métodos** | ✅ Concluído | Lógica de cálculo e manipulação de listas.        |
| **Criação de Adaptadores**   | ✅ Concluído | Integração com RecyclerView.                      |
| **Testes de Integração**     | ✅ Concluído | Verificação de fluxo de dados entre Service e UI. |

---

## ✅ Checklist de Qualidade (Mateus)

- [x] Todas as classes de modelo possuem Getters/Setters.
- [x] O cálculo do total do carrinho considera adição e remoção.
- [x] Os adaptadores utilizam o padrão ViewHolder para performance.
- [x] As interfaces garantem que não haja dependência direta entre UI e Dados.

---
