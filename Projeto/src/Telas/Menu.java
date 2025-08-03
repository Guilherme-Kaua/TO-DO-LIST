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


        JPanel painelCentral = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelCentral.setBorder(new EmptyBorder(50, 0, 0, 0));
        painelCentral.add(botaoTarefas);





        janelaMenu.add(painelCentral, BorderLayout.CENTER);
        janelaMenu.setVisible(true);
    }
}

