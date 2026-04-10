# Comunicação entre Componentes

A comunicação eficiente entre diferentes partes do aplicativo é vital para a integridade dos dados, especialmente em um fluxo de compras.

### Onde foi aplicado

- **Navegação entre Activities:** Do `LoginActivity` para a `MainActivity`.
- **Navegação entre Fragments:** Da listagem de produtos para os detalhes do produto.
- **Interface de Comunicação:** `ProdutoCommunication`.

### Como foi feito

1.  **Intents e Bundles:** Para enviar informações simples entre Activities, usamos Intents.
2.  **Objetos e Serializable:** Conforme o requisito do projeto, a comunicação é baseada em objetos. Embora usemos IDs para buscar dados nos Services, o fluxo simula a passagem de estados complexos.
3.  **Interfaces:** Criamos a interface `ProdutoCommunication` para permitir que o Fragment se comunique com o Adapter. Assim, quando o usuário clica em "Adicionar", o Adapter avisa o Fragment para atualizar o carrinho.

### Por que usar

Passar objetos ou referências claras garante que a tela de destino sempre tenha os dados necessários para renderizar o conteúdo corretamente, evitando erros de "dados não encontrados".
