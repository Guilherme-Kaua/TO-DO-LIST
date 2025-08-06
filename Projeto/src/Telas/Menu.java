package Telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Menu extends JFrame {


    private JLabel labelTitulo;
    private JButton botaoTarefas;
    private JButton botaoEventos;
    private JButton botaoRelatorios;
    private JButton botaoSair;

    public Menu() {
        configurarJanela();
        inicializarComponentes();
        adicionarComponentes();
    }

    private void configurarJanela() {
        setTitle("TO-DO-LIST");
        setSize(550, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {

        labelTitulo = new JLabel("TO-DO-LIST", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 44));


        botaoTarefas = new JButton("Tarefas");
        botaoTarefas.setFont(new Font("Tahoma", Font.PLAIN, 25));
        botaoTarefas.setFocusPainted(false);

        botaoEventos = new JButton("Eventos");
        botaoEventos.setFont(new Font("Tahoma", Font.PLAIN, 25));
        botaoEventos.setFocusPainted(false);

        botaoRelatorios = new JButton("Relatórios");
        botaoRelatorios.setFont(new Font("Tahoma", Font.PLAIN, 25));
        botaoRelatorios.setFocusPainted(false);

        botaoSair = new JButton("Sair");
        botaoSair.setFont(new Font("Tahoma", Font.PLAIN, 25));
        botaoSair.setFocusPainted(false);
    }

    private void adicionarComponentes() {

        JPanel painelCentral = new JPanel();
        painelCentral.setLayout(new BoxLayout(painelCentral, BoxLayout.Y_AXIS));
        painelCentral.setBorder(new EmptyBorder(50, 0, 0, 0)); // Margem superior


        painelCentral.add(botaoEventos);
        painelCentral.add(Box.createVerticalStrut(20)); // Espaçamento
        painelCentral.add(botaoTarefas);
        painelCentral.add(Box.createVerticalStrut(20));
        painelCentral.add(botaoRelatorios);
        painelCentral.add(Box.createVerticalStrut(20));
        painelCentral.add(botaoSair);


        botaoEventos.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoTarefas.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoRelatorios.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoSair.setAlignmentX(Component.CENTER_ALIGNMENT);


        add(labelTitulo, BorderLayout.NORTH);
        add(painelCentral, BorderLayout.CENTER);

        setVisible(true); // Torna a janela visível
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Menu());
    }
}