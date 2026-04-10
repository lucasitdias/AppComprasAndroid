# 📋 ESCOPO COMPLETO DO PROJETO

---

## 📌 1. Identificação do Projeto

- **Nome:** Aplicativo de Compras de Informática (App Compras Info)
- **Disciplina:** Desenvolvimento Android
- **Avaliação:** P1
- **Modalidade:** Trabalho em Grupo
- **Grupo:** 3 pessoas (Matheus, Lucas e Henrique)
- **Data de Entrega:** 09/04/2026
- **Formato de Entrega:** Arquivo ZIP
- **Local de Entrega:** AVA

---

## 📱 2. Requisitos Obrigatórios

### Telas (mínimo 3)

#### 🧾 Tela 1 – Produtos

- Lista de produtos de informática
- Exibição de nome, descrição, preço e imagem
- Uso obrigatório de **RecyclerView**

---

#### 🛒 Tela 2 – Carrinho

- Exibir itens adicionados
- Alterar quantidade
- Remover produtos
- Exibir total da compra
- Uso de **RecyclerView**

---

#### ✅ Tela 3 – Confirmação

- Resumo do pedido
- Lista de itens
- Valor total
- Mensagem de sucesso

---

### 3. Tecnologias Obrigatórias

- Java
- Android Studio
- RecyclerView
- Activities
- Fragments
- Comunicação entre Activities (Bundle/Parcelable)
- Layout responsivo e organizado

---

### 4. Funcionalidades

| Funcionalidade        | Descrição                 |
| --------------------- | ------------------------- |
| Listar Produtos       | Exibir produtos em lista  |
| Adicionar ao Carrinho | Inserir itens             |
| Visualizar Carrinho   | Ver produtos adicionados  |
| Alterar Quantidade    | Ajustar itens             |
| Remover Produto       | Excluir item              |
| Calcular Total        | Atualizar automaticamente |
| Confirmar Compra      | Finalizar pedido          |
| Navegação             | Troca de telas            |

---

## 🏗️ 5. Arquitetura

**Apresentação**

- Activities
- Fragments
- Layouts XML

**Lógica**

- Services
- Adapters

**Dados**

- Models (Produto, Carrinho, Pedido)

---

## 🔄 6. Fluxo da Aplicação

```id="flow1"
Produtos → Carrinho → Confirmação → Reinício
```

### Detalhamento

1. Usuário acessa produtos
2. Adiciona itens ao carrinho
3. Visualiza carrinho
4. Finaliza compra
5. Visualiza confirmação
6. Pode reiniciar o processo

---

## 📦 7. Dados de Exemplo

| ID  | Nome     | Descrição    | Preço    |
| --- | -------- | ------------ | -------- |
| 1   | Notebook | 8GB RAM, SSD | R$ 2.500 |
| 2   | Mouse    | Sem fio      | R$ 150   |
| 3   | Teclado  | Mecânico RGB | R$ 450   |
| 4   | Monitor  | Full HD      | R$ 800   |
| 5   | Webcam   | 1080p        | R$ 200   |
| 6   | Headset  | Gamer        | R$ 350   |

---

## ✅ 8. Critérios de Aceitação

### Funcional

- [ ] 3 telas implementadas
- [ ] Navegação funcionando
- [ ] Carrinho funcional
- [ ] Cálculo correto
- [ ] Sem crashes

---

### Técnico

- [ ] Uso de Activities
- [ ] Uso de Fragments
- [ ] RecyclerView implementado
- [ ] Comunicação entre telas
- [ ] Código organizado

---

## 📚 9. Referências

- [https://developer.android.com/guide/fragments](https://developer.android.com/guide/fragments)
- [https://developer.android.com/guide/topics/ui/layout/recyclerview](https://developer.android.com/guide/topics/ui/layout/recyclerview)
- [https://developer.android.com/guide/components/activities](https://developer.android.com/guide/components/activities)

---
