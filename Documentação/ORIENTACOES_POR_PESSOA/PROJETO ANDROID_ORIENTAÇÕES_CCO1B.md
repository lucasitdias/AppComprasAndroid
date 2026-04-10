## 1. Escopo do Projeto

- **3 telas obrigatórias**:
  1. **Listagem de Produtos** – RecyclerView exibindo produtos de informática.
  2. **Carrinho de Compras** – RecyclerView com produtos adicionados.
  3. **Confirmação de Compra** – Tela final com resumo do pedido.

- **Requisitos obrigatórios**:
  - Uso de **RecyclerView**
  - Uso de **Activities**
  - Uso de **Fragments**
  - Comunicação entre Activities **sempre via objetos**
  - Layout **ergonômico e agradável**

---

## 2. Orientações para Mateus – Backend/Modelo (Estrutura)

### Responsabilidades

- Criar classes de **Modelo de Dados** e **Serviços**.
- Gerenciar dados dos produtos e carrinho.
- Implementar adaptadores para RecyclerView.

### Estrutura de Classes

| Classe                 | Responsabilidade               | Principais Atributos / Métodos                                                 |
| ---------------------- | ------------------------------ | ------------------------------------------------------------------------------ |
| `Produto.java`         | Representa um produto          | `id`, `nome`, `preco`, `descricao` + getters/setters                           |
| `Carrinho.java`        | Gerencia produtos selecionados | Lista de `produtos`, `total` + métodos `adicionar`, `remover`, `calcularTotal` |
| `Pedido.java`          | Representa um pedido realizado | `id`, `data`, `carrinho`, `status` + métodos `confirmar`, `cancelar`           |
| `ProdutoAdapter.java`  | Adapter RecyclerView           | Converte objetos Produto para exibição                                         |
| `CarrinhoAdapter.java` | Adapter RecyclerView           | Converte Carrinho para exibição                                                |
| `ProdutoService.java`  | Serviços de produtos           | Métodos: consultar, adicionar, remover produtos                                |
| `CarrinhoService.java` | Serviços do carrinho           | Métodos: consultar carrinho, finalizar compra                                  |

### Interfaces de Comunicação

```java
public interface ProdutoComunication {
    void onProdutoSelected(Produto produto);
}
```

---

## 3. Orientações para Lucas – UI/Fragments

### Responsabilidades

- Criar Fragments e XMLs de layout responsivos.
- Implementar RecyclerViews e interfaces de callback.
- Garantir que a UI seja intuitiva e ergonômica.

### Estrutura de Fragments

| Fragment              | Responsabilidade                      |
| --------------------- | ------------------------------------- |
| `ProdutosFragment`    | Listagem de produtos com RecyclerView |
| `CarrinhoFragment`    | Cesta de compras com RecyclerView     |
| `ConfirmacaoFragment` | Resumo e confirmação de compra        |

### Layouts XML

- `fragment_produtos.xml`
- `fragment_carrinho.xml`
- `fragment_confirmacao.xml`
- `item_produto.xml`
- `item_carrinho.xml`

### Exemplo de Fragment

```kotlin
class ExemploFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exemplo, container, false)
    }
}
```

### Interfaces de Callback

```java
interface OnProdutoSelecionadoListener {
    void onProdutoAdicionado(Produto produto);
}

interface OnCarrinhoListener {
    void onConfirmarCompra(List<Produto> itens);
}
```

---

## 4. Orientações para Henrique – Integração, Activities e Testes

### Responsabilidades

- Integrar Models e UI.
- Criar `MainActivity` como controlador central.
- Gerenciar fluxo entre fragments.
- Testar integração completa.

### Arquivos/Classes

| Pasta         | Arquivo                 | Função                              |
| ------------- | ----------------------- | ----------------------------------- |
| `activities/` | `MainActivity.java`     | Coordena fragments e eventos de UI  |
| `helpers/`    | `NavigationHelper.java` | Gerencia transições entre fragments |
| `tests/`      | `IntegrationTest.java`  | Testes de fluxo completo            |

### Fluxo de Navegação

```text
MainActivity
 ├── ProdutosFragment (RecyclerView)
 │    └── Clica em produto → Adiciona ao Carrinho
 ├── CarrinhoFragment (RecyclerView)
 │    └── Clica em "Confirmar" → Vai para ConfirmacaoFragment
 └── ConfirmacaoFragment
      └── Clica em "Finalizar" → Volta ao início
```

### Passagem de Objetos

```java
// Envio
Intent intent = new Intent(this, DetalheActivity.class);
Bundle bundle = new Bundle();
bundle.putSerializable("produto", produto);
intent.putExtras(bundle);
startActivity(intent);

// Recebimento
Produto produto = (Produto) getIntent().getSerializableExtra("produto");
```
---

## 5. Entregáveis

- Projeto completo compilando no Android Studio
- ZIP do projeto contendo:

  ```
  ProjetoCompras.zip
  ├── app/src/main/java/
  │   ├── models/
  │   ├── adapters/
  │   ├── services/
  │   ├── ui/fragments/
  │   ├── activities/
  │   └── helpers/
  ├── app/src/main/res/layout/
  ├── README.md
  └── build.gradle
  ```

---

## 6. Referências

- [Android Developer – Fragments](https://developer.android.com/guide/fragments?hl=pt-br)
- [Android Developer – RecyclerView](https://developer.android.com/develop/ui/views/layout/recyclerview?hl=pt-br)
- [Android Developer – Activities](https://developer.android.com/guide/components/activities/intro-activities?hl=pt-br)

---
