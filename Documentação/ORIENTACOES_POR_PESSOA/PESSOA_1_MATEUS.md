# Orientações para Mateus

Neste documento, você encontrará as orientações detalhadas sobre a criação de classes e interfaces relacionadas aos conceitos de Modelos, Adaptadores e Serviços.

## 1. Estruturas de Classes

### Produto.java

- **Responsabilidade**: Representa um produto no sistema.
- **Atributos**: `id`, `nome`, `preco`, `descricao`.
- **Métodos**: Getters e Setters para cada atributo.
- **Checklist**:
  - [ ] Definir atributos.
  - [ ] Implementar métodos.
  - [ ] Criar construtor.

### Carrinho.java

- **Responsabilidade**: Gerencia um conjunto de produtos escolhidos pelo usuário.
- **Atributos**: `produtos`, `total`.
- **Métodos**: Adicionar produto, remover produto, calcular total.
- **Checklist**:
  - [ ] Definir atributos.
  - [ ] Implementar métodos.

### Pedido.java

- **Responsabilidade**: Representa a instância de um pedido realizado.
- **Atributos**: `id`, `data`, `carrinho`, `status`.
- **Métodos**: Confirmar pedido, cancelar pedido.
- **Checklist**:
  - [ ] Definir atributos.
  - [ ] Implementar métodos.

### ProdutoAdapter.java

- **Responsabilidade**: Converte objetos `Produto` em formatos adequados para exibição.
- **Checklist**:
  - [ ] Implementar método para conversão.

### CarrinhoAdapter.java

- **Responsabilidade**: Facilita a conversão de `Carrinho` para diferentes formatos.
- **Checklist**:
  - [ ] Implementar método para conversão.

### ProdutoService.java

- **Responsabilidade**: Camada de serviço para operações relacionadas a produtos.
- **Métodos**: Consultar produtos, adicionar produtos.
- **Checklist**:
  - [ ] Implementar métodos de acesso ao repositório.

### CarrinhoService.java

- **Responsabilidade**: Camada de serviço para operações relacionadas ao carrinho.
- **Métodos**: Consultar carrinho, finalizar compra.
- **Checklist**:
  - [ ] Implementar métodos de acesso ao repositório.

## 2. Interfaces de Comunicação

- Definir interfaces que serão utilizadas pelas classes de serviço e adaptadores para garantir consistência e reusabilidade.

### Exemplo de Interface

```java
public interface ProdutoComunication {
   void onProdutoSelected(Produto produto);
}
```

## Checklist Final

- [ ] Criar todas as classes.
- [ ] Implementar todos os métodos.
- [ ] Testar todas as integrações.
- [ ] Revisar o código.

Por favor, siga estas orientações e preencha o checklist.
