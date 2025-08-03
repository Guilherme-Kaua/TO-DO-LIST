package Telas;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class JanelaEventos {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Sistema de Eventos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);


        JTabbedPane abas = new JTabbedPane();


        JPanel painelTodas = criarPainelTodas();
        JPanel painelMes = new JPanel();
        JPanel painelDia = new JPanel();
        JPanel painelSair = new JPanel();
        JButton botaoSair = new JButton("Sair");

        painelSair.add(botaoSair);
        abas.addTab("Todas", painelTodas);
        abas.addTab("Listar por mês", painelMes);
        abas.addTab("Listar por dia", painelDia);
        abas.addTab("Sair", painelSair);


        frame.add(abas);
        frame.setVisible(true);
    }

    private static JPanel criarPainelTodas() {
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());


        JButton botaoAdicionar = new JButton("+ Adicionar Evento");
        painel.add(botaoAdicionar, BorderLayout.NORTH);


        JPanel painelEvento = new JPanel();
        painelEvento.setLayout(new GridLayout(5, 2, 10, 10));

        Border borda = BorderFactory.createLineBorder(Color.BLACK);

        JLabel tituloLabel = new JLabel("Titulo:");
        painelEvento.add(tituloLabel);
        JTextArea inputTitulo = new JTextArea();
        inputTitulo.setBorder(borda);
        painelEvento.add(inputTitulo);

        painelEvento.add(new JLabel("Descrição:"));
        JTextArea inputDesc = new JTextArea();
        inputDesc.setBorder(borda);
        painelEvento.add(inputDesc);

        painelEvento.add(new JLabel("Data do evento:"));
        JTextArea inputData = new JTextArea();
        inputData.setBorder(borda);
        painelEvento.add(inputData);


        JPanel botoes = new JPanel();
        botoes.add(new JButton("Editar Evento"));
        botoes.add(new JButton("Excluir Evento"));

        // Adiciona ao painel principal
        painel.add(painelEvento, BorderLayout.CENTER);
        painel.add(botoes, BorderLayout.SOUTH);

        return painel;
    }
}
