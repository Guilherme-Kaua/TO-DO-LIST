package Telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Menu {
    public static void main(String[] args) {
        JFrame janelaMenu = new JFrame();
        janelaMenu.setSize(550, 400);
        janelaMenu.setResizable(false);
        janelaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaMenu.setLocationRelativeTo(null);
        janelaMenu.setLayout(new BorderLayout());

        JLabel labelTitulo= new JLabel("TO-DO-LIST",SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 44));
        janelaMenu.add(labelTitulo, BorderLayout.NORTH);


        JButton botaoTarefas = new JButton("Tarefas");
        botaoTarefas.setFont(new Font("Tahoma", Font.PLAIN, 25));
        botaoTarefas.setFocusPainted(false);

        JButton botaoEventos = new JButton("Eventos");
        botaoEventos.setFont(new Font("Tahoma", Font.PLAIN, 25));
        botaoEventos.setFocusPainted(false);

        JButton botaoRelatorios = new JButton("Relatorios");
        botaoRelatorios.setFont(new Font("Tahoma", Font.PLAIN, 25));
        botaoRelatorios.setFocusPainted(false);

        JButton botaoSair = new JButton("Sair");
        botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 25));
        botaoSair.setFocusPainted(false);

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.setBorder(new EmptyBorder(50, 0, 0, 0));
        painelCentral.add(botaoEventos);
        painelCentral.add(Box.createVerticalStrut(20));
        painelCentral.add(botaoTarefas);
        painelCentral.add(Box.createVerticalStrut(20));
        painelCentral.add(botaoRelatorios);
        painelCentral.add(Box.createVerticalStrut(20));
        painelCentral.add(botaoSair);

        botaoEventos.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoTarefas.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoRelatorios.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoRelatorios.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);


        janelaMenu.add(painelCentral, BorderLayout.CENTER);
        janelaMenu.setVisible(true);
    }
}

