# Layout, Ergonomia e Design

O design do **TechStore** foi concebido para ser funcional, moderno e acessível, seguindo as diretrizes do **Material Design 3**.

### Onde foi aplicado

- Em todos os arquivos XML da pasta `res/layout/`.
- Uso de estilos em `res/values/themes.xml`.

### Como foi feito

1.  **Material Design 3:** Utilizamos componentes como `MaterialToolbar`, `BottomNavigationView` e `ShapeableImageView` (para fotos circulares).
2.  **ConstraintLayout:** Todos os layouts complexos foram construídos com `ConstraintLayout`, o que garante que a interface se ajuste perfeitamente em telas de diferentes tamanhos (celulares pequenos a tablets).
3.  **Ergonomia:**
    - **Touch Targets:** Botões possuem pelo menos 48x48dp de área de toque.
    - **Contraste:** Cores de texto e fundo validadas para leitura clara.
    - **Hierarquia:** Títulos em negrito e cores primárias para destacar o que é mais importante.

### Por que usar

Um layout ergonômico reduz a carga cognitiva do usuário. Ao usar padrões conhecidos (como o menu inferior e ícones intuitivos), o usuário não precisa "aprender" a usar o app; ele já sabe onde clicar para comprar.
