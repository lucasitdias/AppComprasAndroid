# GUIA DE INTEGRAÇÃO, TESTES E DEPLOYMENT

---

## 1. Introdução

Este guia descreve o processo completo de integração, testes e geração do aplicativo Android, garantindo que todas as partes do projeto funcionem corretamente em conjunto.

---

## 2. Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

- Android Studio
- Java JDK
- Gradle

---

## 3. Integração do Projeto

### 3.1 Clonando o Repositório

```bash
git clone https://github.com/lucasitdias/E-COMMERCE-ANDROID-
cd E-COMMERCE-ANDROID-
```

---

### 3.2 Importando no Android Studio

1. Abra o Android Studio
2. Clique em **"Open" ou "Import Project"**
3. Selecione a pasta do projeto clonado
4. Aguarde a sincronização do Gradle

---

## 4. Testes

### 4.1 Testes Unitários

Os testes unitários validam a lógica da aplicação (models e services).

Executar via terminal:

```bash
./gradlew test
```

Ou pelo Android Studio:

- Clique com o botão direito no projeto → **Run Tests**

---

### 4.2 Testes de Instrumentação

Executa testes no dispositivo/emulador:

```bash
./gradlew connectedAndroidTest
```

---

## 5. Build e Geração do APK

Para gerar o APK do projeto:

```bash
./gradlew assembleRelease
```

O APK será gerado em:

```
app/build/outputs/apk/release/
```

---

## 6. Deployment (Publicação)

### Publicação na Google Play (Opcional)

1. Acesse a **Google Play Console**
2. Crie ou selecione um aplicativo
3. Faça upload do APK gerado
4. Preencha as informações exigidas
5. Envie para revisão

---

## 7. Integração entre Equipes

### Responsabilidades

- Pessoa 1 → Models e Services
- Pessoa 2 → Interface (Fragments e Layouts)
- Pessoa 3 → Activities e Integração

---

### Processo de Integração

1. Cada membro desenvolve sua parte separadamente
2. Utilizar branches no Git
3. Realizar merge na branch principal
4. Resolver conflitos
5. Testar o fluxo completo

---

## 8. Controle de Versão (Git)

### Criar branches

```bash
git checkout -b feature/pessoa1-modelos
git checkout -b feature/pessoa2-ui
git checkout -b feature/pessoa3-integracao
```

### Merge

```bash
git checkout main
git merge feature/nome-da-branch
```

---

## 9. Boas Práticas

- Manter código organizado
- Evitar duplicação
- Usar nomes descritivos
- Testar antes de integrar
- Comentar partes importantes do código

---

## 10. Problemas Comuns

### Erro de Gradle

- Executar: `File → Sync Project with Gradle Files`

### App não compila

- Verificar dependências
- Verificar imports

### Conflitos de Git

- Revisar alterações antes do merge
- Resolver manualmente se necessário

---

## 11. Conclusão

Este guia garante que o processo de integração, testes e geração do aplicativo seja realizado de forma organizada e eficiente, reduzindo erros e garantindo um produto final funcional.

---

## 12. Referências

- [Android Developers – Fragments](https://developer.android.com/guide/fragments?hl=pt-br)
- [Android Developers – RecyclerView](https://developer.android.com/develop/ui/views/layout/recyclerview?hl=pt-br)
- [Android Developers – Activities](https://developer.android.com/guide/components/activities/intro-activities?hl=pt-br)

```

```
