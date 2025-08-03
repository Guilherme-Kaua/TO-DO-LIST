package Telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class JanelaRelatorios {
    public static void main(String[] args) {
        JFrame janelaMenu = new JFrame();
        janelaMenu.setSize(550, 400);
        janelaMenu.setResizable(false);
        janelaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaMenu.setLocationRelativeTo(null);
        janelaMenu.setLayout(new BorderLayout());

        JLabel labelTitulo= new JLabel("Relatórios",SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 44));
        janelaMenu.add(labelTitulo, BorderLayout.NORTH);


        JButton botaoPdf = new JButton("Exportar relatório no formato PDF");
        botaoPdf.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoPdf.setFocusPainted(false);

        JButton botaoEmail = new JButton("Enviar as tarefas por e-mail");
        botaoEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoEmail.setFocusPainted(false);

        JButton botaoPlanilha = new JButton("Exportar o relatorio para uma planilha");
        botaoPlanilha.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoPlanilha.setFocusPainted(false);


        JPanel painelBotoes = new JPanel();

        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBorder(new EmptyBorder(50, 0, 50, 0));


        botaoPdf.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoPlanilha.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoEmail.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelBotoes.add(botaoPdf);
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(botaoPlanilha);
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(botaoEmail);


        janelaMenu.add(painelBotoes, BorderLayout.CENTER);
        janelaMenu.setVisible(true);
    }
}