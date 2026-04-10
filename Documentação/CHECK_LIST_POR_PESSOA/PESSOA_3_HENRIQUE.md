# Relatório de Contribuição: Henrique

Segue minha contribuição, no desenvolvimento do projeto TechStore, focando na **Integração de Camadas, Controle de Navegação e Qualidade (Testes)**.

---

## Responsabilidades Técnicas Implementadas

Fui o responsável por unir o trabalho do Mateus (Dados) e do Lucas (Interface), garantindo que o fluxo do aplicativo fosse coeso e livre de erros.

### 1. Integração e Controle Central (MainActivity)

Henrique desenvolvi a lógica central da `MainActivity.java`, que atua como o cérebro coordenador do app.

- **Orquestração de Fragments**: Implementei a lógica que decide qual tela exibir (Produtos, Carrinho ou Confirmação) baseada na interação do usuário.
- **Comunicação por Objetos**: Garanti o cumprimento do requisito de passar objetos entre componentes. Implementou o uso de `Serializable` para enviar dados de produtos entre fragmentos e atividades.
- **Conexão de Camadas**: Vinculei os botões da interface (Lucas) às chamadas dos serviços de dados (Mateus).

### 2. Fluxo de Navegação e Helpers

- **Gerenciamento de Pilha (BackStack)**: Configurei o comportamento do botão "voltar" para que o usuário não saia do app acidentalmente e sim retorne à tela anterior.
- **Navigation Logic**: Implementei as transições de fragmentos dentro da MainActivity, garantindo que o estado do carrinho fosse preservado durante a navegação.
- **Helper de Formatação**: Colaborei na utilização do `FormatoHelper.java` para garantir que os dados integrados fossem exibidos corretamente (moeda, datas).

### 3. Qualidade e Testes de Integração

Validei o ciclo de vida completo da aplicação:

- **Fluxo Ponta a Ponta**: Testei manualmente e validei a sequência: _Produtos → Adicionar → Carrinho → Validar Total → Finalizar → Confirmação_.
- **Passagem de Dados**: Garanti que, ao clicar em um produto, as informações corretas chegassem à tela de detalhes sem perda de dados.
- **Estabilidade**: Responsável por identificar e corrigir conflitos de IDs e crashs durante a troca de fragmentos.

---

## Pontos Importantes do Trabalho

- **Sincronização**: Implementei o sistema de **Badges** (contadores) que atualizam o ícone do carrinho no menu inferior sempre que um item é adicionado, integrando a UI com o `CarrinhoService`.
- **Navegação Ergonômica**: Garanti que o menu lateral (Drawer) e o menu inferior funcionassem de forma sincronizada.

---

## Cronograma e Entregas

| Etapa                       | Status       | Descrição                                       |
| :-------------------------- | :----------- | :---------------------------------------------- |
| **Integração Inicial**      | ✅ Concluído | Configuração da MainActivity e transições base. |
| **Conexão de Camadas**      | ✅ Concluído | Unir Services de dados com os Fragments de UI.  |
| **Testes de Fluxo**         | ✅ Concluído | Validação do caminho de compra completo.        |
| **Ajustes de Estabilidade** | ✅ Concluído | Resolução de bugs de navegação e sobreposição.  |

---

## Checklist de Qualidade (Henrique)

- [x] MainActivity controla os Fragments sem erros de transição.
- [x] Objetos de Produto e Pedido passam corretamente entre telas.
- [x] O fluxo "Produtos -> Carrinho -> Confirmação" funciona 100%.
- [x] O app compila e roda sem crashes em fluxos de navegação rápida.
- [x] Integração com os Services do Mateus validada.

---
