package com.example.appcomprasandroid;

// Importar classe Espresso (executar interações na interface do usuário)
import static androidx.test.espresso.Espresso.onView;

// Importar ações de interação (clique, digitação e fechamento do teclado)
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;

// Importar validações de teste (verificações na interface)
import static androidx.test.espresso.assertion.ViewAssertions.matches;

// Importar matchers para localizar e validar componentes
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

// Importar regra de Activity (inicia a tela automaticamente para testes)
import androidx.test.ext.junit.rules.ActivityScenarioRule;

// Importar executor de testes AndroidJUnit4
import androidx.test.ext.junit.runners.AndroidJUnit4;

// Importar anotação de teste de grande escala
import androidx.test.filters.LargeTest;

// Importar Activity inicial do fluxo (login)
import com.example.appcomprasandroid.activities.LoginActivity;

// Importar anotações do JUnit (estrutura de testes)
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

// Classe responsável por executar testes de integração do fluxo completo da aplicação
@RunWith(AndroidJUnit4.class)
@LargeTest
public class IntegrationTest {

    // Regra responsável por iniciar a LoginActivity antes da execução do teste
    @Rule
    public ActivityScenarioRule<LoginActivity> activityRule =
            new ActivityScenarioRule<>(LoginActivity.class);

    // Método responsável por simular o fluxo completo do usuário na aplicação
    @Test
    public void testFullApplicationFlow() {

        // Realizar login do usuário

        // Preencher campo de email
        onView(withId(R.id.editLoginEmail))
                .perform(typeText("admin@app.com"), closeSoftKeyboard());

        // Preencher campo de senha
        onView(withId(R.id.editLoginSenha))
                .perform(typeText("123456"), closeSoftKeyboard());

        // Clicar no botão de login
        onView(withId(R.id.btnLogin)).perform(click());

        // Aguardar carregamento da próxima tela (MainActivity)
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //  Adicionar produto ao carrinho

        // Clicar no botão de adicionar produto
        onView(withId(R.id.btnAdicionar)).perform(click());

        // Navegar para a tela do carrinho

        // Clicar no item do menu inferior (carrinho)
        onView(withId(R.id.nav_carrinho)).perform(click());

        // Finalizar a compra

        // Clicar no botão de confirmar pedido
        onView(withId(R.id.btnConfirmar)).perform(click());

        // Validar mensagem de sucesso

        // Verificar se a mensagem está visível na tela
        onView(withId(R.id.txtMensagemSucesso))
                .check(matches(isDisplayed()))

                // Verificar se o texto exibido está correto
                .check(matches(withText("Pedido Finalizado com Sucesso!")));

        // Retornar para a tela inicial

        // Clicar no botão para voltar ao início
        onView(withId(R.id.btnVoltarInicio)).perform(click());
    }
}