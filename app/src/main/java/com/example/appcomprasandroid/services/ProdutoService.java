package com.example.appcomprasandroid.services;

// Importar classe R (acesso a imagens e recursos do projeto)
import com.example.appcomprasandroid.R;

// Importar modelo Produto (representa um produto da aplicação)
import com.example.appcomprasandroid.models.Produto;

// Importar lista dinâmica
import java.util.ArrayList;

// Importar interface de lista
import java.util.List;

// Classe responsável por fornecer a lista de produtos disponíveis no app
public class ProdutoService {

    // Lista estática que armazena os produtos (simulando banco de dados)
    private static List<Produto> listaProdutos = null;

    // Retornar lista de produtos
    public static List<Produto> getListaProdutos() {

        // Verificar se a lista ainda não foi inicializada
        if (listaProdutos == null) {

            // Criar nova lista de produtos
            listaProdutos = new ArrayList<>();

            // Adicionar produto: Notebook Gamer
            listaProdutos.add(new Produto(
                    1,
                    "Notebook Gamer Dell G15",
                    "Processador i7, 16GB RAM, RTX 3050",
                    5499.00,
                    "Processador: Intel Core i7-12700H\nMemória: 16GB DDR5\nArmazenamento: 512GB SSD\nPlaca de Vídeo: NVIDIA RTX 3050 4GB",
                    R.drawable.dell_g15
            ));

            // Adicionar produto: Mouse Gamer
            listaProdutos.add(new Produto(
                    2,
                    "Mouse Gamer Logitech G502",
                    "Sensor HERO 25K, 11 botões programáveis",
                    349.90,
                    "DPI: 100 - 25.600\nConexão: USB\nPeso ajustável: Sim\nIluminação: RGB Lightsync",
                    R.drawable.mouse_logitech_g502
            ));

            // Adicionar produto: Teclado Mecânico
            listaProdutos.add(new Produto(
                    3,
                    "Teclado Mecânico Razer BlackWidow",
                    "Switches Green, Iluminação Chroma RGB",
                    899.00,
                    "Tipo: Mecânico\nSwitch: Razer Green (Clicky)\nLayout: ABNT2\nSoftware: Razer Synapse",
                    R.drawable.teclado_razer_blackwindow_
            ));

            // Adicionar produto: Monitor Gamer
            listaProdutos.add(new Produto(
                    4,
                    "Monitor Gamer LG UltraGear 27\"",
                    "144Hz, 1ms, IPS, G-Sync Compatible",
                    1450.00,
                    "Resolução: Full HD (1920x1080)\nTaxa de Atualização: 144Hz\nTempo de Resposta: 1ms (GtG)\nPainel: IPS",
                    R.drawable.monitor_lg_ultragear_27polegadas
            ));

            // Adicionar produto: Placa de Vídeo
            listaProdutos.add(new Produto(
                    5,
                    "Placa de Vídeo RTX 4060 Ti",
                    "8GB GDDR6, Ray Tracing, DLSS 3",
                    2890.00,
                    "Núcleos CUDA: 4352\nClock: 2535 MHz (Boost)\nMemória: 8GB GDDR6 128-bit\nInterface: PCIe 4.0",
                    R.drawable.placa_de_video_rtx4060ti
            ));

            // Adicionar produto: Processador
            listaProdutos.add(new Produto(
                    6,
                    "Processador AMD Ryzen 7 5700X",
                    "8 Cores, 16 Threads, 4.6GHz Max Boost",
                    1250.00,
                    "Socket: AM4\nBase Clock: 3.4GHz\nTDP: 65W\nCache: 36MB Total",
                    R.drawable.processador_ryzer7
            ));
        }

        // Retornar lista de produtos pronta
        return listaProdutos;
    }
}