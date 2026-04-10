# Activities e Fragments

Neste projeto, utilizamos uma combinação de **Activities** e **Fragments** para gerenciar a navegação, seguindo as melhores práticas do desenvolvimento Android Moderno.

### Onde foi aplicado

- **Activities:**
  - `LoginActivity`, `CadastroActivity`, `ResetPasswordActivity`: Gerenciam o fluxo de autenticação.
  - `MainActivity`: Atua como o "Container" principal do aplicativo.
- **Fragments:**
  - `ProdutosFragment`, `CarrinhoFragment`, `FavoritosFragment`, `PerfilFragment`, etc.

### Como foi feito

1.  **Host Activity:** A `MainActivity` possui um `FrameLayout` (id: `container`) que é substituído dinamicamente pelos fragmentos.
2.  **Transações:** Utilizamos o `FragmentManager` para realizar a troca de telas sem fechar a Activity principal.
    - **Código:**
      ```java
      getSupportFragmentManager()
          .beginTransaction()
          .replace(R.id.container, fragment)
          .addToBackStack(null) // Permite que o botão 'voltar' funcione
          .commit();
      ```

### Por que usar

O uso de **Fragments** permite que o aplicativo seja modular. Podemos manter a barra de navegação inferior (BottomNavigation) e a Toolbar sempre visíveis, trocando apenas o conteúdo central. Isso torna o app muito mais rápido e econômico em termos de processamento.
