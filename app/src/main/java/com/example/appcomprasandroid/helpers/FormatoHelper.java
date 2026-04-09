package com.example.appcomprasandroid.helpers;

// Importar modelo Produto (utilizado na formatação de listas de itens)
import com.example.appcomprasandroid.models.Produto;
// Importar NumberFormat (responsável por formatar valores numéricos, como moeda)
import java.text.NumberFormat;
// Importar SimpleDateFormat para formatação de datas
import java.text.SimpleDateFormat;
// Importar Date para manipulação de tempo
import java.util.Date;
// Importar List (estrutura de dados para listas de produtos)
import java.util.List;
// Importar Locale (define padrão regional, ex: Brasil para moeda R$)
import java.util.Locale;

// Classe auxiliar responsável por formatar dados exibidos na aplicação
public class FormatoHelper {

    // Definir localidade brasileira para formatação de moeda
    private static final Locale LOCALE_BR = new Locale("pt", "BR");

    // Formatar valor monetário no padrão brasileiro (R$)
    public static String formatarMoeda(double valor) {
        // Criar formatador de moeda com base na localidade
        NumberFormat formatador = NumberFormat.getCurrencyInstance(LOCALE_BR);
        // Retornar valor formatado
        return formatador.format(valor);
    }

    // Formatar lista de produtos em uma string única
    public static String formatarListaItens(List<Produto> itens) {
        // Verificar se a lista está vazia ou nula (Mantendo sua lógica original)
        if (itens == null || itens.isEmpty()) {
            // Retornar mensagem padrão para lista vazia
            return "Itens: (vazio)";
        }

        // Criar StringBuilder para montar texto
        StringBuilder sb = new StringBuilder("Itens: ");
        // Percorrer lista de produtos
        for (int i = 0; i < itens.size(); i++) {
            // Adicionar nome do produto
            sb.append(itens.get(i).getNome());
            // Adicionar vírgula entre itens (exceto último)
            if (i < itens.size() - 1) {
                sb.append(", ");
            }
        }
        // Retornar lista formatada
        return sb.toString();
    }

    // Formatar data para exibição no padrão brasileiro (dd/MM/yyyy)
    public static String formatarData(Date data) {
        if (data == null) return "";
        // Criar formatador de data dia/mês/ano
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", LOCALE_BR);
        return sdf.format(data);
    }

    // Formatar quantidade de itens com texto descritivo
    public static String formatarQuantidade(int qtd) {
        // Retorna "1 item" ou "X itens" dependendo do valor
        return qtd + (qtd == 1 ? " item" : " itens");
    }
}