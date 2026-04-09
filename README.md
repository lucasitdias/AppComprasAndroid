
# 📱 TechStore - App de Compras Android

> Plataforma de **compras mobile,** desenvolvida em **Android Studio** com **Java**.

![Android](https://img.shields.io/badge/Android-34%2B-green)
![Java](https://img.shields.io/badge/Java-17%2B-orange)
![License](https://img.shields.io/badge/License-Apache%202.0-blue)
![Status](https://img.shields.io/badge/Status-Active-brightgreen)

---

## 📋 Índice

- [Informações do Projeto (P1)](#-informações-do-projeto-p1)
- [Descrição do Projeto](#-descrição-do-projeto)
- [Funcionalidades Principais](#-funcionalidades-principais)
- [Objetivos Principais](#-objetivos-principais)
- [Tecnologias e Dependências](#-tecnologias-e-dependências)
- [Pré-Requisitos e Instalação](#-pré-requisitos-e-instalação)
- [Divisão de Responsabilidades](#-divisão-de-responsabilidades)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Componentes Principais](#-componentes-principais)
- [Fluxo de Navegação](#-fluxo-de-navegação)
- [Documentação Técnica](#-documentação-técnica)
- [Build e Deployment](#-build-e-deployment)
- [Testes e Qualidade](#-testes-e-qualidade)
- [Troubleshooting](#-troubleshooting)
- [Contribuição](#-contribuição)
- [Referências](#-referências)
- [Licença](#-licença)

---

## 📌 Informações do Projeto (P1)

* **Disciplina:** Desenvolvimento Android
* **Entrega:** 09/04/2026
* **Formato:** ZIP via AVA
* **Equipe:** 3 pessoas (Mateus, Lucas, Henrique)
* **Ambiente:** Android studio com linguagem java

### Requisitos Mínimos

* 3 Telas (Produtos, Carrinho, Confirmação)
* RecyclerView
* Activities & Fragments
* Comunicação entre Activities via objetos
* Layout ergonômico e responsivo

---

A **TechStore** é uma aplicação mobile de e-commerce em produtos de informática. Desenvolvido como trabalho acadêmico (P1) em Android, a aplicação permite aos usuários:

- ✅ Navegar por um catálogo de produtos com descrição e imagens  
- ✅ Adicionar/remover produtos do carrinho de compras  
- ✅ Gerenciar o perfil e visualizar histórico de pedidos  
- ✅ Acompanhar o status de compras realizadas  
- ✅ Implementação de componentes Android → (RecyclerView, Fragments, Activities)  
- ✅ Interface responsiva e ergonômica com Material Design  
- ✅ Fluxo de compra intuitivo: Produtos → Carrinho → Confirmação  

---
## 👥 Divisão de Responsabilidades

O projeto foi desenvolvido em equipe com responsabilidades bem distribuidas:

### 🧑‍💻 **Pessoa 1: Backend & Modelos (Matheus)**

**Responsabilidades:**
- Criar classes de modelo de dados (Produto, Pedido, Carrinho, Usuario)
- Implementar adapters para RecyclerView
- Gerenciar lógica de negócio via Services
- Criar interfaces de comunicação

**Arquivos Principais:**
```
models/
├── Produto.java
├── Pedido.java
├── Carrinho.java
└── Usuario.java

adapters/
├── ProdutoAdapter.java
├── CarrinhoAdapter.java
└── PedidoAdapter.java

services/
├── ProdutoService.java
├── CarrinhoService.java
├── PedidoService.java
└── UsuarioService.java

interfaces/
└── ProdutoCommunication.java
```

**Checklist de Conclusão:**
- [x] Todas as classes criadas
- [x] Métodos de negócio implementados
- [x] Adapters testados
- [x] Interfaces de comunicação definidas

---

### 🎨 **Pessoa 2: UI & Fragments (Lucas)**

**Responsabilidades:**
- Criar fragments e layouts responsivos
- Implementar RecyclerViews nas telas
- Garantir UI intuitiva e ergonômica
- Seguir Material Design 3

**Arquivos Principais:**
```
ui/fragments/
├── ProdutosFragment.java
├── ProdutoDetalhesFragment.java
├── CarrinhoFragment.java
├── ConfirmacaoFragment.java
├── PedidosFragment.java
├── PedidoDetalhesFragment.java
├── FavoritosFragment.java
├── PerfilFragment.java
└── SettingsFragment.java

res/layout/
├── fragment_produtos.xml
├── fragment_carrinho.xml
├── fragment_confirmacao.xml
├── fragment_perfil.xml
├── fragment_pedidos.xml
├── fragment_favoritos.xml
├── item_produto.xml
├── item_carrinho.xml
└── [outros]
```

**Checklist de Conclusão:**
- [x] Todos os 9 fragments implementados
- [x] Layouts responsivos em ConstraintLayout
- [x] RecyclerViews funcionando
- [x] Material Design aplicado

---

### 🔗 **Pessoa 3: Integração & Testes (Henrique)**

**Responsabilidades:**
- Criar MainActivity como controlador central
- Integrar todas as camadas do projeto (Autenticação e Navegação)
- Gerenciar fluxo de navegação entre Activities e Fragments
- Realizar testes de integração instrumentados
- Garantir estabilidade geral e correção do Manifest

**Arquivos Principais:**
```
activities/
├── LoginActivity.java
├── CadastroActivity.java
├── ResetPasswordActivity.java
└── MainActivity.java

helpers/
├── FormatoHelper.java
└── NavigationHelper.java

tests/
├── IntegrationTest.java
├── [testes de unidade]
└── [outros]
```

**Checklist de Conclusão:**
- [x] MainActivity controlando fragments corretamente
- [x] Navegação funcionando sem crashes
- [x] Objetos passados corretamente entre telas
- [x] Fluxo completo validado (Login -> Compra -> Sucesso)
- [x] Testes de integração criados

---

## 📁 Estrutura do Projeto

```
AppCompras-Android/
├── 📄 README.md                                    # Este arquivo
├── 📄 LICENSE                                      # Apache License 2.0
├── 📄 build.gradle.kts                             # Configuração Gradle (projeto)
├── 📄 settings.gradle.kts                          # Configuração de módulos
├── 📄 gradle.properties                            # Propriedades Gradle
├── 📄 local.properties                             # Configuração local (SDK)
│
├── 📁 gradle/
│   └── 📄 libs.versions.toml                       # Catálogo de dependências
│
├── 📁 app/                                         # Módulo principal
│   ├── 📄 build.gradle.kts                         # Configuração build app
│   ├── 📄 proguard-rules.pro                       # Regras de ofuscação
│   │
│   ├── 📁 src/main/
│   │   ├── 📄 AndroidManifest.xml                  # Configuração da aplicação
│   │   │
│   │   ├── 📁 kotlin/com/example/appcomprasandroid/
│   │   │   ├── 📁 activities/                      # Activities (telas)
│   │   │   │   ├── LoginActivity.kt                #  Tela de login
│   │   │   │   ├── CadastroActivity.kt             #  Tela de registro
│   │   │   │   ├── MainActivity.kt                 #  Activity principal
│   │   │   │   └── ResetPasswordActivity.kt        #  Recuperação de senha
│   │   │   │
│   │   │   ├── 📁 adapters/                        # Adapters para RecyclerView
│   │   │   │   ├── ProdutoAdapter.kt               # Adapter de produtos
│   │   │   │   ├── CarrinhoAdapter.kt              # Adapter do carrinho
│   │   │   │   └── PedidoAdapter.kt                # Adapter de pedidos
│   │   │   │
│   │   │   ├── 📁 models/                          # Modelos de dados
│   │   │   │   ├── Carrinho.kt
│   │   │   │   ├──  Produto.kt                      # Classe Produto
│   │   │   │   └── Pedido.kt                       # Classe Pedido
│   │   │   │
│   │   │   ├── 📁 services/                        # Lógica de negócio
│   │   │   │   ├── ProdutoService.kt               # Serviço de produtos
│   │   │   │   ├── CarrinhoService.kt              # Serviço do carrinho
│   │   │   │   └── PedidoService.kt                # Serviço de pedidos
│   │   │   │
│   │   │   ├── 📁 ui/fragments/                    # Fragments (telas)
│   │   │   │   ├── ProdutosFragment.kt             #  Listagem de produtos
│   │   │   │   ├── ProdutoDetalhesFragment.kt      #  Detalhes do produto
│   │   │   │   ├── CarrinhoFragment.kt             #  Carrinho de compras
│   │   │   │   ├── ConfirmacaoFragment.kt          #  Confirmação de compra
│   │   │   │   ├── PedidosFragment.kt              #  Histórico de pedidos
│   │   │   │   ├── PedidoDetalhesFragment.kt       #  Detalhes do pedido
│   │   │   │   ├── FavoritosFragment.kt            #  Produtos favoritos
│   │   │   │   ├── PerfilFragment.kt               #  Perfil do usuário
│   │   │   │   │   └── SettingsFragment.kt         #  Configurações
│   │   │   │
│   │   │   ├── 📁 interfaces/                      # Interfaces de comunicação
│   │   │   │   └── ProdutoCommunication.kt         # Interface callback
│   │   │   │
│   │   │   └── 📁 helpers/                         # Funções utilitárias
│   │   │       └── FormatoHelper.kt                # Formatação de dados
│   │   │
│   │   └── 📁 res/                                 # Recursos
│   │       ├── 📁 layout/                          # Layouts XML
│   │       │   ├── activity_login.xml              # Layout do login
│   │       │   ├── activity_cadastro.xml           # Layout do cadastro
│   │       │   ├── activity_main.xml               # Layout principal
│   │       │   ├── activity_reset_password.xml     # Layout reset
│   │       │   ├── fragment_produtos.xml           # Layout produtos
│   │       │   ├── fragment_produto_detalhes.xml   # Layout detalhes
│   │       │   ├── fragment_carrinho.xml           # Layout carrinho
│   │       │   ├── fragment_confirmacao.xml        # Layout confirmação
│   │       │   ├── fragment_pedidos.xml            # Layout pedidos
│   │       │   ├── fragment_pedido_detalhes.xml    # Layout pedido
│   │       │   ├── fragment_favoritos.xml          # Layout favoritos
│   │       │   ├── fragment_perfil.xml             # Layout perfil
│   │       │   ├── fragment_settings.xml           # Layout config
│   │       │   ├── item_produto.xml                # Item produto (RecyclerView)
│   │       │   ├── item_carrinho.xml               # Item carrinho (RecyclerView)
│   │       │   ├── item_pedido.xml                 # Item pedido (RecyclerView)
│   │       │   └── nav_header.xml                  # Header do menu
│   │       │
│   │       ├── 📁 drawable/                        # Imagens e ícones
│   │       │   ├── logo_techstore.png              # Logo da loja
│   │       │   ├── icon_app.png                    # Ícone do app
│   │       │   ├── ic_back.xml                     # Ícone voltar
│   │       │   ├── ic_carrinho.xml                 # Ícone carrinho
│   │       │   ├── ic_produtos.xml                 # Ícone produtos
│   │       │   ├── ic_menu.xml                     # Ícone menu
│   │       │   ├── ic_launcher_*.xml               # Ícone launcher
│   │       │   ├── sl_favorito.xml                 # Selector favorito
│   │       │   ├── bg_quantity_selector.xml        # Background quantidade
│   │       │   ├── bg_status_default.xml           # Background status
│   │       │   └── [imagens de produtos].png       # Imagens de exemplos
│   │       │
│   │       ├── 📁 menu/                            # Menus
│   │       │   ├── bottom_nav_menu.xml             # Menu de navegação inferior
│   │       │   └── drawer_menu.xml                 # Menu lateral
│   │       │
│   │       ├── 📁 anim/                            # Animações
│   │       │   ├── slide_in_left.xml               # Entrada esquerda
│   │       │   ├── slide_in_right.xml              # Entrada direita
│   │       │   ├── slide_out_left.xml              # Saída esquerda
│   │       │   └── slide_out_right.xml             # Saída direita
│   │       │
│   │       ├── 📁 values/                          # Recursos strings/cores
│   │       │   ├── colors.xml                      # Paleta de cores
│   │       │   ├── strings.xml                     # Textos da app
│   │       │   └── themes.xml                      # Temas (light/dark)
│   │       │
│   │       ├── 📁 values-night/                    # Recursos tema escuro
│   │       │   └── themes.xml                      # Tema noturno
│   │       │
│   │       ├── 📁 mipmap/                          # Ícones launcher
│   │       │   ├── ic_launcher.xml                 # Ícone adaptive
│   │       │   └── ic_launcher_round.xml           # Ícone round
│   │       │
│   │       └── 📁 xml/                             # Configurações XML
│   │           ├── backup_rules.xml                # Regras de backup
│   │           └── data_extraction_rules.xml       # Regras Android 11+
│   │
│   ├── 📁 src/test/                                # Testes unitários
│   │   └── com/example/appcomprasandroid/
│   │       ├── models/
│   │       ├── services/
│   │       └── helpers/
│   │
│   └── 📁 src/androidTest/                         # Testes instrumentados
│       └── com/example/appcomprasandroid/
│           ├── activities/
│           ├── fragments/
│           └── integration/
│
└── 📁 documentation/                               # Documentação técnica
    ├── 📄 RECYCLER_VIEW.md                         #  RecyclerView
    ├── 📄 ACTIVITIES_FRAGMENTS.md                  #  Activities/Fragments
    ├── 📄 COMUNICACAO.md                           #  Comunicação
    ├── 📄 TELAS_FLUXO.md                           #  Fluxo de navegação
    ├── 📄 LAYOUT.md                                #  Design/Layout
    └── 
```
---

## ✨ Funcionalidades Principais

### 🔐 Autenticação
- **LoginActivity**: Tela de login com validação de credenciais
- **CadastroActivity**: Registro de novo usuário
- **ResetPasswordActivity**: Recuperação de senha

### 🛍️ Catálogo de Produtos
- Listagem de produtos com RecyclerView
- Detalhes completos do produto
- Sistema de favoritos
- Busca de produtos (Barra de pesquisa)
- Imagens de produtos com Glide

### 🛒 Carrinho de Compras
- Adicionar/remover itens
- Ajustar quantidades (+/-)
- Cálculo automático de totais
- Persistência de dados em sessão
- Badge de contador de itens

### 📦 Gerenciamento de Pedidos
- Visualização de histórico de compras
- Detalhes de cada pedido
- Status de entrega
- Timeline de transações
- Animações de transição suave

### 👤 Perfil do Usuário
- Informações pessoais
- Configurações de conta
- Histórico de atividades
- Opção de logout

---

## 🔄 Fluxo de Navegação

### Fluxo Visual Completo

```
┌─────────────────────────────────────────────────────┐
│            FLUXO COMPLETO DA APLICAÇÃO              │
└─────────────────────────────────────────────────────┘

    ┌───────────────────┐
    │  LoginActivity    │
    │ [Autenticação]    │
    └─────────┬─────────┘
              │
         [Login OK]
              │
    ┌─────────▼──────────────────────────────┐
    │           MainActivity                 │
    │  ┌─────────────────────────────────┐   │
    │  │   BottomNavigationView          │   │
    │  │  [Produtos|Carrinho|Favoritos   │   │
    │  │   Pedidos|Perfil]               │   │
    │  └─────────────────────────────────┘   │
    │                                        │
    │  ┌─────────────────────────────────┐   │
    │  │      FrameLayout (container)    │   │
    │  │ ┌───────────────────────────┐   │   │
    │  │ │  ProdutosFragment         │   │   │
    │  │ │  ┌─────────────────────┐  │   │   │
    │  │ │  │ RecyclerView        │  │   │   │
    │  │ │  │ [Produtos]          │  │   │   │
    │  │ │  └─────────────────────┘  │   │   │
    │  │ │  [Clica em Produto]       │   │   │
    │  │ └───────────────────────────┘   │   │
    │  │            │                    │   │
    │  │    ┌───────▼──────────────────┐ │   │
    │  │    │ProdutoDetalhesFragment   │ │   │
    │  │    │[Imagem + Specs + Botão]  │ │   │
    │  │    │[Adiciona ao Carrinho]    │ │   │
    │  │    └───────┬──────────────────┘ │   │
    │  │            │                    │   │
    │  │    ┌───────▼──────────────────┐ │   │
    │  │    │  CarrinhoFragment        │ │   │
    │  │    │  ┌─────────────────────┐ │ │   │
    │  │    │  │ RecyclerView        │ │ │   │
    │  │    │  │ [Itens do Carrinho] │ │ │   │
    │  │    │  └─────────────────────┘ │ │   │
    │  │    │  [Botão Finalizar]       │ │   │
    │  │    └───────┬──────────────────┘ │   │
    │  │            │                    │   │
    │  │    ┌───────▼──────────────────┐ │   │
    │  │    │ConfirmacaoFragment       │ │   │
    │  │    │✅ [Pedido Confirmado!]  │ │   │
    │  │    │[Botão Voltar]            │ │   │
    │  │    └──────────────────────────┘ │   │
    │  │                                 │   │
    │  └─────────────────────────────────┘   │
    │                                        │
    │         ┌──────────────────┐           │
    │         │ Outros Fragments │           │
    │         ├──────────────────┤           │
    │         │ PedidosFragment  │           │
    │         │ FavoritosFragment│           │
    │         │ PerfilFragment   │           │
    │         │ SettingsFragment │           │
    │         └──────────────────┘           │
    │                                        │
    └────────────────────────────────────────┘
```

### Sequência Passo a Passo

```
1️⃣  ACESSO INICIAL
   └─ LoginActivity → MainActivity

2️⃣  NAVEGAÇÃO PARA PRODUTOS
   └─ MainActivity → ProdutosFragment (RecyclerView)

3️⃣  VISUALIZAR DETALHES
   └─ ProdutosFragment → ProdutoDetalhesFragment

4️⃣  ADICIONAR AO CARRINHO
   └─ ProdutoDetalhesFragment → CarrinhoService.adicionar()

5️⃣  VISUALIZAR CARRINHO
   └─ BottomNavigation clique em Carrinho → CarrinhoFragment

6️⃣  FINALIZAR COMPRA
   └─ CarrinhoFragment → ConfirmacaoFragment

7️⃣  CONFIRMAÇÃO
   └─ ConfirmacaoFragment → PedidoService.criar()

8️⃣  VOLTAR AO CATÁLOGO
   └─ ConfirmacaoFragment → ProdutosFragment
```

---

## 🛠️ Tecnologias e Dependências

### Ambiente de Desenvolvimento
| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| **Android Studio 3** | (2025.3.3) | IDE desenvolvimento Android Studio |
| **Java SDK** | 17 | Linguagem de programação  |
| **Android SDK** | 34+ | Kit de desenvolvimento Android |
| **Gradle** | 8.0+ | Sistema de build |

### Linguagens e Frameworks
| Tecnologia | Versão | Descrição |
|-----------|--------|-----------|
| **Java** | 17 | Linguagem de programação principal |
| **Android SDK** | 34+ | Suporte a múltiplos níveis de API |
| **Material Design** |  3  | Sistema de design moderno da Google |

### Ferramentas de Build
- **Gradle** `9.1.0` - Sistema de build
- **Android Gradle Plugin** `9.1.0`
- **Java Compiler** `17`
- **Kotlin DSL** - Configuração de build

---
### Software Obrigatório
```bash
✓ Java Development Kit (JDK) 17 (instalado e testado neste projeto)
✓ Android Studio (versão 2025 ou posterior)
✓ Android SDK Platform API Level 34 (compileSdk)
✓ Android SDK Tools (atualizados)
✓ Gradle 8.0 ou superior (geralmente instalado com Android Studio)
✓ Git (para controle de versão)
```

### Verificar Instalações
```bash
# Verificar Java
java -version
javac -version

# Verificar se é Java 17
java -version
# Deve retornar: "17.0.x" ou superior

# Verificar Gradle
gradle -version

# Verificar Android SDK
echo $ANDROID_HOME

# Verificar Git
git --version
```

### Emulador ou Dispositivo
- Android 14 (API 34) ou superior
- 2GB de RAM mínimo

---

## 🔧 Instalação e Setup

### Passo 1: Clonar o Repositório

```bash
# Clone o repositório
git clone https://github.com/lucasitdias/AppComprasAndroid.git

# Entre no diretório
cd AppCompras-Android

# Verifique o status
git status
```

### Passo 2: Configurar o Ambiente Android

#### No Linux/Mac:
```bash
# Abra ou crie o arquivo .bash_profile ou .zshrc
nano ~/.bash_profile
# ou
nano ~/.zshrc

# Adicione as seguintes linhas:
export ANDROID_HOME=$HOME/Library/Android/sdk
export PATH=$PATH:$ANDROID_HOME/tools
export PATH=$PATH:$ANDROID_HOME/tools/bin
export PATH=$PATH:$ANDROID_HOME/platform-tools

# Salve (Ctrl+O, Enter, Ctrl+X) e aplique as mudanças
source ~/.bash_profile
# ou
source ~/.zshrc
```

#### No Windows:
```bash
# 1. Abra: Variáveis de Ambiente
# Pesquise "Variáveis de Ambiente" no menu Iniciar

# 2. Clique em: Variáveis de Ambiente

# 3. Nova variável do sistema:
# Nome: ANDROID_HOME
# Valor: C:\Users\[SeuUsuario]\AppData\Local\Android\sdk

# 4. Adicione ao PATH:
# C:\Users\[SeuUsuario]\AppData\Local\Android\sdk\tools
# C:\Users\[SeuUsuario]\AppData\Local\Android\sdk\platform-tools
```

### Passo 3: Configurar local.properties

O arquivo `local.properties` já deve estar configurado, mas verifique:

```properties
# local.properties
sdk.dir=/home/usuario/Android/Sdk
# ou no Windows:
# sdk.dir=C:\\Users\\usuario\\AppData\\Local\\Android\\sdk
```

Se não existir, crie um na raiz do projeto:

```bash
# Linux/Mac
echo "sdk.dir=$HOME/Library/Android/sdk" > local.properties

# Windows
echo sdk.dir=C:\Users\[SeuUsuario]\AppData\Local\Android\sdk > local.properties
```

### Passo 4: Abrir no Android Studio

```bash
# Linux/Mac
open -a "Android Studio" .

# Windows
explorer .
# (Clique com botão direito > Abrir com > Android Studio)

# Ou manualmente:
# 1. Abra Android Studio
# 2. File > Open
# 3. Selecione a pasta AppCompras-Android
# 4. Aguarde a indexação
```

### Passo 5: Sincronizar Gradle

```bash
# No diretório raiz do projeto
./gradlew sync

# Ou no Windows:
# gradlew.bat sync

# Ou manualmente no Android Studio:
# File > Sync Now
```

### Passo 6: Baixar SDKs Necessários

```bash
# Baixar SDK 34 (compileSdk)
sdkmanager "platforms;android-34"

# Baixar SDK tools
sdkmanager "platform-tools"
sdkmanager "build-tools;34.0.0"

# Baixar emulador
sdkmanager "emulator"
sdkmanager "system-images;android-34;google_apis;x86_64"
```

### Passo 7: Criar Emulador (se necessário)

```bash
# Listar dispositivos virtuais
emulator -list-avds

# Criar novo emulador
avdmanager create avd -n TechStoreEmulator \
  -k "system-images;android-34;google_apis;x86_64" \
  -d "pixel_4"

# Iniciar emulador
emulator -avd TechStoreEmulator
```

### Passo 8: Build e Execução

```bash
# Build debug
./gradlew build

# Ou diretamente no Android Studio:
# Build > Build Variant > debug
# Run > Run 'app'

# Build release
./gradlew assembleRelease
```

### Passo 9: Executar no Emulador/Dispositivo

#### Via Android Studio:
1. Conecte um dispositivo Android ou inicie um emulador
2. Aguarde o dispositivo ser reconhecido
3. Clique em ▶️ **Run 'app'** (ou Shift + F10)
4. Selecione o dispositivo alvo
5. Aguarde a instalação

#### Via Terminal:
```bash
# Listar dispositivos conectados
adb devices

# Instalar APK (debug)
adb install -r build/outputs/apk/debug/app-debug.apk

# Iniciar a aplicação
adb shell am start -n com.example.appcomprasandroid/.activities.LoginActivity

# Ver logs em tempo real
adb logcat | grep appcompras

# Ver logs detalhados
adb logcat | grep -E "(appcompras|ERROR|Exception)"

# Limpar logs
adb logcat -c

```
---

## 🧩 Componentes Principais

### 1️⃣ **Activities (Telas Principais)**

As Activities são os contêineres principais que gerenciam a navegação e exibem os Fragments.

| Activity | Função | Fragments Contidos |
|----------|--------|-------------------|
| **LoginActivity** | Autenticação do usuário | - |
| **CadastroActivity** | Registro de novo usuário | - |
| **ResetPasswordActivity** | Recuperação de senha | - |
| **MainActivity** | Tela inicial e navegação principal | ProdutosFragment, FavoritosFragment, PerfilFragment |
| **ProdutoDetalhesActivity** | Exibir detalhes de um produto | ProdutoDetalhesFragment |
| **CarrinhoActivity** | Gerenciar carrinho de compras | CarrinhoFragment, ConfirmacaoFragment |
| **PedidosActivity** | Histórico e acompanhamento de pedidos | PedidosFragment, PedidoDetalhesFragment |
| **SettingsActivity** | Configurações da aplicação | SettingsFragment |

#### LoginActivity
```
Responsabilidades:
✓ Autenticação do usuário
✓ Validação de credenciais
✓ Navegação para MainActivity
✓ Link para CadastroActivity
✓ Link para ResetPasswordActivity

Fluxo:
└─ Usuário insere email/senha → Valida → MainActivity
```

#### CadastroActivity
```
Responsabilidades:
✓ Registro de novo usuário
✓ Validação de email e senha
✓ Confirmação de senha
✓ Persistência de dados

Fluxo:
└─ Preenchimento de dados → Validação → LoginActivity
```

#### MainActivity
```
Responsabilidades:
✓ Container principal (FrameLayout)
✓ Gerenciamento de fragments
✓ BottomNavigationView com 5 opções
✓ Toolbar com informações

Opções BottomNav:
├─ 🛍️ Produtos
├─ 🛒 Carrinho
├─ ⭐ Favoritos
├─ 📋 Pedidos
└─ 👤 Perfil
```

#### ResetPasswordActivity
```
Responsabilidades:
✓ Recuperação de senha por email
✓ Validação de usuário
✓ Redefinição de senha

Fluxo:
└─ Email → Validação → Sucesso → LoginActivity
```

---

### 2️⃣ Fragments (Telas Dinâmicas)

Os **Fragments** são componentes reutilizáveis que funcionam dentro das Activities.

---

### 📋 Fragments com RecyclerView (Listas)

| Fragment | Funcionalidades | Activity |
|----------|----------------|----------|
| **ProdutosFragment** | Listar produtos, buscar e filtrar por categoria, favoritar | `MainActivity` |
| **CarrinhoFragment** | Listar itens, alterar quantidade, remover produtos, calcular total | `CarrinhoActivity` |
| **PedidosFragment** | Listar pedidos e filtrar por status | `PedidosActivity` |
| **FavoritosFragment** | Listar favoritos, remover itens, adicionar ao carrinho | `MainActivity` |

---

### 🧾 Fragments de Detalhes e Formulários

| Fragment | Funcionalidades | Activity |
|----------|----------------|----------|
| **ProdutoDetalhesFragment** | Detalhes do produto, zoom de imagem, especificações, avaliações, adicionar ao carrinho | `ProdutoDetalhesActivity` |
| **ConfirmacaoFragment** | Resumo do pedido, endereço, pagamento, confirmação final | `CarrinhoActivity` |
| **PedidoDetalhesFragment** | Status do pedido, rastreamento, entrega estimada, dados gerais | `PedidosActivity` |
| **PerfilFragment** | Dados pessoais, endereço, edição de perfil, logout | `MainActivity` |
| **SettingsFragment** | Preferências, notificações, tema, privacidade | `SettingsActivity` |

---

### 3️⃣ **RecyclerView & Adapters**

#### Implementação Padrão

```kotlin
// ProdutoAdapter.kt
class ProdutoAdapter(
    private val produtos: List<Produto>,
    private val callback: ProdutoCommunication
) : RecyclerView.Adapter<ProdutoAdapter.ViewHolder>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.bind(produto)
    }
    
    override fun getItemCount() = produtos.size
    
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(produto: Produto) {
            // Carregar imagem com Glide
            Glide.with(itemView.context)
                .load(produto.imagemUrl)
                .into(itemView.findViewById(R.id.img_produto))
            
            // Setar dados
            itemView.findViewById<TextView>(R.id.txt_nome).text = produto.nome
            itemView.findViewById<TextView>(R.id.txt_preco).text = 
                FormatoHelper.formatarMoeda(produto.preco)
            
            // Listeners
            itemView.setOnClickListener {
                callback.aoAdicionarAoCarrinho(produto)
            }
        }
    }
}
```

---

### 4️⃣ **Models (Dados)**

```kotlin
// Produto.kt
data class Produto(
    val id: Int,
    val nome: String,
    val descricao: String,
    val preco: Double,
    val imagemUrl: String,
    val estaFavoritado: Boolean = false,
    val quantidadeEmEstoque: Int
) : Serializable

// Pedido.kt
data class Pedido(
    val id: Int,
    val dataPedido: String,
    val status: String, // "Pendente", "Enviado", "Entregue", "Cancelado"
    val itens: List<Produto>,
    val totalPedido: Double
) : Serializable
```

---

### 5️⃣ **Services (Lógica de Negócio)**

#### ProdutoService
```kotlin
object ProdutoService {
    private val produtos = mutableListOf<Produto>(
        Produto(1, "Notebook Dell", "8GB RAM, SSD 256GB", 2500.00, "dell_g15.png", false, 5),
        Produto(2, "Mouse Logitech", "Sem fio", 150.00, "mouse_logitech_g502.png", false, 10),
        // ...
    )
    
    fun obterTodosProdutos(): List<Produto> = produtos
    fun obterProdutoPorId(id: Int): Produto? = produtos.find { it.id == id }
    fun buscarProdutos(query: String): List<Produto> = 
        produtos.filter { it.nome.contains(query, ignoreCase = true) }
    fun obterFavoritos(): List<Produto> = produtos.filter { it.estaFavoritado }
}
```

#### CarrinhoService
```kotlin
object CarrinhoService {
    private val carrinho = mutableMapOf<Int, Int>() // id -> quantidade
    
    fun adicionarProduto(produto: Produto) {
        carrinho[produto.id] = (carrinho[produto.id] ?: 0) + 1
    }
    
    fun removerProduto(produtoId: Int) {
        carrinho.remove(produtoId)
    }
    
    fun obterCarrinho(): Map<Int, Int> = carrinho
    
    fun calcularTotal(): Double {
        var total = 0.0
        carrinho.forEach { (produtoId, quantidade) ->
            val produto = ProdutoService.obterProdutoPorId(produtoId)
            total += (produto?.preco ?: 0.0) * quantidade
        }
        return total
    }
    
    fun limparCarrinho() = carrinho.clear()
}
```

---

### 6️⃣ **Interface de Comunicação**

```kotlin
// ProdutoCommunication.kt
interface ProdutoCommunication {
    fun aoAdicionarAoCarrinho(produto: Produto)
    fun aoFavoritarProduto(produto: Produto)
    fun aoExibirDetalhes(produto: Produto)
}
```

---

### 7️⃣ **FormatoHelper (Utilidades)**

```kotlin
// FormatoHelper.kt
object FormatoHelper {
    fun formatarMoeda(valor: Double): String = 
        "R$ %.2f".format(valor)
    
    fun formatarData(data: String): String {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR"))
        return sdf.format(Date())
    }
    
    fun formatarTempo(data: String): String = 
        "2 dias atrás" // Simplificado para exemplo
}
```
---

### Componentes Utilizados

O projeto implementa os componentes principais do Android:

#### **RecyclerView**

Componente utilizado para otimizar a exibição de grandes listas de dados de forma eficiente.

**Aplicado em:**
- ProdutosFragment
- CarrinhoFragment
- FavoritosFragment
- PedidosFragment

**Padrão Implementado:**
```
XML Layout (item_produto.xml)
        ↓
ViewHolder (cache de views)
        ↓
Adapter (converte dados)
        ↓
RecyclerView (exibe lista)
```

- Reciclagem de views (economiza RAM)
- Suavidade ao rolar
- Performance otimizada

---

#### **Activities e Fragments**

**O que são?**
- **Activities**: Telas principais com ciclo de vida completo
- **Fragments**: Componentes reutilizáveis dentro de uma Activity

**Estrutura:**
```
LoginActivity (Tela 1)
    ↓
MainActivity (Container)
    ├─ ProdutosFragment (Tela 2)
    ├─ CarrinhoFragment (Tela 2)
    ├─ ConfirmacaoFragment (Tela 3)
    └─ [outros fragments]
```

**Transações:**
```kotlin
supportFragmentManager.beginTransaction()
    .replace(R.id.container, novoFragment)
    .addToBackStack(null)
    .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
    .commit()
```

---

#### **Comunicação entre Componentes**

**Métodos Implementados:**

1. **Intents e Bundles** (entre Activities)
```kotlin
val intent = Intent(this, MainActivity::class.java)
val bundle = Bundle()
bundle.putSerializable("usuario", usuario)
intent.putExtras(bundle)
startActivity(intent)
```

2. **Interfaces de Callback** (entre Fragment e Adapter)
```kotlin
interface ProdutoCommunication {
    fun aoAdicionarAoCarrinho(produto: Produto)
}

// No Fragment
class ProdutosFragment : Fragment(), ProdutoCommunication {
    override fun aoAdicionarAoCarrinho(produto: Produto) {
        CarrinhoService.adicionarProduto(produto)
    }
}
```

3. **LiveData/StateFlow** para reatividade
```kotlin
val carrinhoTotal = MutableStateFlow(0.0)
```

---

#### **Layout, Ergonomia e Design**

**Material Design Implementado:**
- Cores primárias
- ConstraintLayout responsivo
- Touch targets 48x48dp
- Hierarquia visual clara

**Paleta de Cores:**
```xml
<!-- Cores Principais -->
<color name="primary">#0D47A1</color>           <!-- Azul -->
<color name="accent">#FFAB00</color>            <!-- Amarelo -->
<color name="error">#B00020</color>             <!-- Vermelho -->
<color name="success">#2E7D32</color>           <!-- Verde -->
```

---

## 📦 Build e Deployment

### Build Debug

```bash
# Terminal
./gradlew assembleDebug

# Resultado
app/build/outputs/apk/debug/app-debug.apk

# Instalar em dispositivo
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

### Build Release

```bash
# Terminal
./gradlew assembleRelease

# Resultado
app/build/outputs/apk/release/app-release.apk
```

### Erro: "Gradle sync failed"

**Causa**: Dependências não encontradas ou versão incompatível

**Solução:**
```bash
# Limpar cache
./gradlew clean

# Sincronizar novamente
./gradlew sync

# Ou no Android Studio: File > Sync Now
```

---

## 👥 Contribução no versionamento

### Como Contribuir

1. **Fork** o repositório
```bash
git clone https://github.com/lucasitdias/AppComprasAndroid.git
cd AppCompras-Android
```

2. **Crie uma branch** para sua feature
```bash
git checkout -b feature/sua-funcionalidade
# Exemplos:
# git checkout -b feature/new-login-screen
# git checkout -b feature/cart-improvements
# git checkout -b fix/navigation-bug
```

3. **Desenvolva** sua funcionalidade

4. **Commit** suas mudanças
```bash
git add .
git commit -m "feat: Descrição clara da mudança"
# Padrão de commits:
# feat: Nova funcionalidade
# fix: Correção de bug
# docs: Documentação
# style: Formatação
# refactor: Refatoração
# test: Testes
```

5. **Push** para a branch
```bash
git push origin feature/sua-funcionalidade
```

6. **Abra uma Pull Request**
```
Título: [TIPO] Descrição breve
Descrição:
- O que foi mudado?
- Por quê?
- Como testar?
- Screenshots (se UI)
```
---

## 📖 Documentações para consulta
### Documentação Oficial
- [Android Developer Docs](https://developer.android.com/docs)
- [Material Design Guidelines](https://material.io/design)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [AndroidX Reference](https://developer.android.com/jetpack)

### Ferramentas e Bibliotecas
- [Glide - Image Loading](https://bumptech.github.io/glide/)
- [Gradle Build Tool](https://gradle.org/)
- [Android Studio](https://developer.android.com/studio)

### Referências Técnicas
- [Fragments Best Practices](https://developer.android.com/guide/fragments)
- [RecyclerView Performance](https://developer.android.com/develop/ui/views/layout/recyclerview)
- [Activities Lifecycle](https://developer.android.com/guide/components/activities/activity-lifecycle)

---

<p align="center">
  <strong>Se este projeto foi útil, deixe uma estrela ⭐!</strong>
</p>

<p align="center">
  <img src="https://img.shields.io/github/stars/pizzariamassanostra/AppCompras-Android?style=social" />
</p>

---

## 👨‍💻 Contribuidores

* 🧑‍💻 **Matheus**
  🔗 https://github.com/Mbolsanello
  *Backend & Modelos*

* 🎨 **Lucas**
  🔗 https://github.com/lucasitdias
  *UI & Fragments*

* 🔗 **Henrique**
  🔗 https://github.com/IronVisuals
  *Integração & Testes*

---

**Desenvolvido por:** Matheus, Lucas e Henrique  
**Data:** 07/04/2026  
**Disciplina:** Desenvolvimento Android  
**Repositório de Referência:** [AppCompras-Android](https://github.com/lucasitdias/AppComprasAndroid)

---

## 📄 Licença

Este projeto está licenciado sob a **Apache License 2.0**. 

```
Copyright 2024 lucasitdev / IronVisuals / Mbolsanello

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
---
