# ARQUITETURA E FLUXO

## Estrutura Geral do Projeto

Divisão por responsabilidades:

- Pessoa 1: Modelo de Dados + Serviços
- Pessoa 2: Interface de Usuário (UI/Fragments)
- Pessoa 3: Integrações + Activities + Testes

---

## Arquitetura

O sistema segue o padrão:

**MVC (Model-View-Controller)**

### Camadas

**Model (Dados)**

- Produto
- Carrinho
- Pedido

**View (Interface)**

- Activities
- Fragments
- Layouts XML

**Controller (Lógica)**

- Services
- Adapters
- Navegação

---

## Modelo e Serviços (Matheus)

### Responsabilidades

- Criar classes de modelo de dados
- Implementar RecyclerView Adapters
- Gerenciar dados dos produtos
- Criar serviços de lógica de negócio

### Estrutura de Arquivos

```

models/
├── Produto.java
├── Carrinho.java
└── Pedido.java

adapters/
├── ProdutoAdapter.java
└── CarrinhoAdapter.java

services/
├── ProdutoService.java
└── CarrinhoService.java

```

### O que Entregar

- Classes prontas com dados de exemplo
- Adapters testados
- Documentação básica das classes

---

## Interface (Lucas)

### Responsabilidades

- Criar 3 Fragments
- Criar layouts XML
- Implementar RecyclerView
- Criar comunicação entre telas

### Estrutura de Arquivos

```

ui/fragments/
├── ProdutosFragment.java
├── CarrinhoFragment.java
└── ConfirmacaoFragment.java

res/layout/
├── fragment_produtos.xml
├── fragment_carrinho.xml
├── fragment_confirmacao.xml
├── item_produto.xml
└── item_carrinho.xml

```

### Interfaces de Comunicação

```java
interface OnProdutoSelecionadoListener {
    void onProdutoAdicionado(Produto produto);
}

interface OnCarrinhoListener {
    void onConfirmarCompra(List<Produto> itens);
}
```

### O que Entregar

- Fragments funcionais
- Layouts responsivos
- Interfaces definidas

---

## Integração (Henrique)

### Responsabilidades

- Criar MainActivity
- Implementar navegação entre telas
- Integrar todas as partes do sistema
- Realizar testes de funcionamento

### Estrutura de Arquivos

```
activities/
└── MainActivity.java

helpers/
└── NavigationHelper.java

tests/
└── IntegrationTest.java
```

---

## Fluxo de Navegação

```
MainActivity
├── ProdutosFragment
│   └── Clique em produto → adiciona ao carrinho
├── CarrinhoFragment
│   └── Clique em "Confirmar" → vai para confirmação
└── ConfirmacaoFragment
    └── Clique em "Finalizar" → volta ao início
```

---

## Comunicação entre Activities

### Enviando dados

```java
Intent intent = new Intent(this, DetalheActivity.class);
Bundle bundle = new Bundle();
bundle.putSerializable("produto", produto);
intent.putExtras(bundle);
startActivity(intent);
```

### Recebendo dados

```java
Produto produto = (Produto) getIntent().getSerializableExtra("produto");
```

---

## Cronograma

| Fase            | Tempo    | Descrição                          |
| --------------- | -------- | ---------------------------------- |
| Planejamento    | 1–2 dias | Definir estrutura e alinhar equipe |
| Desenvolvimento | 5–7 dias | Implementação individual           |
| Integração      | 2–3 dias | Conectar todas as partes           |
| Ajustes         | 1–2 dias | Correção de bugs e melhorias       |

---

## Boas Práticas

### Uso de Git

```bash
git checkout -b feature/pessoa1-modelos
git checkout -b feature/pessoa2-ui
git checkout -b feature/pessoa3-activities
```

### Regras

- Cada pessoa trabalha em sua branch
- Fazer merge apenas após validação
- Evitar conflitos de código

---

## Contratos entre Equipes

- Matheus - define os modelos
- Lucas - define interfaces de comunicação
- Henrique - 3 integra tudo

---

## Testes

- Matheus - testa modelos e serviços
- Lucas - testa fragments isoladamente
- Henrique - 3 testa fluxo completo

---

## Entregáveis Finais

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

## Checklist

- [ ] Mínimo 3 telas implementadas
- [ ] RecyclerView em pelo menos 2 telas
- [ ] Activities e Fragments utilizados corretamente
- [ ] Comunicação entre telas funcionando
- [ ] Layout responsivo
- [ ] Aplicativo compilando sem erros
- [ ] Fluxo de navegação completo

```

```
