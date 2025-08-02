package Telas;

import javax.swing.*;
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


        JButton botaoTarefas= new JButton("Tarefas");
        botaoTarefas.setFont(new Font("Tahoma", Font.PLAIN,35));

        JPanel painelesquerda = new JPanel(new FlowLayout(FlowLayout.CENTER));
        painelesquerda.add(botaoTarefas);
        janelaMenu.add(painelesquerda, BorderLayout.WEST);






        //JPanel painelTarefas = new JPanel();
        //janelaMenu.add(painelTarefas,BorderLayout.CENTER);






        janelaMenu.setVisible(true);
    }
}

