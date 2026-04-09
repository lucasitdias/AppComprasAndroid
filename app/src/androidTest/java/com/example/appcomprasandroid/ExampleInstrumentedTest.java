package com.example.appcomprasandroid;

// Importação do contexto da aplicação Android
import android.content.Context;

// Importação das classes base para execução de testes no dispositivo
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

// Importação das anotações de teste do JUnit
import org.junit.Test;
import org.junit.runner.RunWith;

// Importação das ferramentas de validação (assert)
import static org.junit.Assert.*;

// Classe responsável por testes instrumentados (executados no dispositivo/emulador)
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    // Método de teste que valida se o nome do pacote da aplicação está correto
    @Test
    public void deveRetornarNomePacoteCorreto() {

        // Obtém o contexto da aplicação em execução
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        // Verifica se o nome do pacote corresponde ao esperado
        assertEquals("com.example.appcomprasandroid", appContext.getPackageName());
    }
}