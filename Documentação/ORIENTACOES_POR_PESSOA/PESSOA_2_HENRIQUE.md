# Orientações para Henrique – Integração, Activities e Testes

## Introdução

Henrique será responsável por **integrar todas as partes do projeto**, garantindo que o backend (Mateus) e a UI (Lucas) funcionem juntos corretamente. Também cuidará do fluxo de navegação entre telas e dos testes de integração.

---

## 1. Responsabilidades

### Integração de Camadas

- Conectar **Models e Services** (Mateus) com **Fragments e Layouts** (Lucas).
- Garantir que objetos (`Produto`, `Carrinho`, `Pedido`) possam ser passados corretamente entre Activities e Fragments usando `Bundles` ou métodos de callback.

### Activities

- Criar a `MainActivity.java` que será o **controlador central** do app.
- Gerenciar a navegação entre os 3 fragments principais:
  1. **ProdutosFragment** (listagem de produtos)
  2. **CarrinhoFragment** (cesta de compras)
  3. **ConfirmacaoFragment** (confirmação do pedido)

### Navegação

- Implementar **transações de fragmentos** ou um **NavigationController** para fluxo de telas.
- Criar uma **classe helper** opcional (`NavigationHelper.java`) para centralizar mudanças de fragmentos.

### Testes de Integração

- Verificar se o fluxo completo funciona:

- Produtos → Carrinho → Confirmação → Volta à listagem
- Testar passagem de dados entre Activities e Fragments.
- Criar testes básicos de integração (`IntegrationTest.java`) para validar as funcionalidades principais.

---

## 2. Arquivos e Estrutura

📦 **activities/**

- `MainActivity.java` – Orquestra os fragments, recebe eventos de UI e chama os serviços.

📦 **helpers/**

- `NavigationHelper.java` – (Opcional) Gerencia transições entre fragments.

📦 **tests/**

- `IntegrationTest.java` – Testes de fluxo completo, garantindo que a aplicação funcione do início ao fim.

---

## 3. Fluxo de Navegação

```text
MainActivity
 ├── ProdutosFragment (RecyclerView)
 │    └── Clica em produto → Adiciona ao Carrinho
 ├── CarrinhoFragment (RecyclerView)
 │    └── Clica em "Confirmar" → Vai para ConfirmacaoFragment
 └── ConfirmacaoFragment
      └── Clica em "Finalizar" → Volta ao início
```

---

## 4. Passagem de Objetos entre Activities/Fragments

Exemplo de como passar objetos `Produto`:

```java
// MainActivity → DetalheActivity ou outro fragment
Intent intent = new Intent(this, DetalheActivity.class);
Bundle bundle = new Bundle();
bundle.putSerializable("produto", produto); // objeto
intent.putExtras(bundle);
startActivity(intent);

// Na Activity ou Fragment destino
Produto produto = (Produto) getIntent().getSerializableExtra("produto");
```

---

## 5. Checklist de Entrega

- [ ] MainActivity funcional
- [ ] Fragmentos integrados corretamente
- [ ] Objetos sendo passados corretamente entre Activities e Fragments
- [ ] RecyclerViews funcionando em ProdutosFragment e CarrinhoFragment
- [ ] Fluxo de navegação completo: Produtos → Carrinho → Confirmação → Listagem
- [ ] Integração com Services de Mateus funcionando
- [ ] Testes de integração criados e funcionando (`IntegrationTest.java`)
- [ ] Projeto compilando sem erros

---

## 6. Observações Importantes

- Utilize **Bundles** ou **interfaces de callback** para comunicação entre fragments.
- Teste cada fragment isoladamente antes de integrar.
- Certifique-se de que **todas as funcionalidades de Mateus e Lucas estejam visíveis e funcionando**.
- Documente qualquer ajuste ou adaptação que precise ser feita no projeto final.

---
