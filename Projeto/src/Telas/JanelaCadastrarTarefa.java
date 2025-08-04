package Telas;

import javax.swing.*;
import java.awt.*;

public class JanelaCadastrarTarefa {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cadastro de Tarefas");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550, 400);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        /// /
        JLabel labelTitulo = new JLabel("Cadastrar Tarefas", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 44));
        JPanel painelTitulo = new JPanel();
        painelTitulo.add(labelTitulo);
        frame.add(painelTitulo, BorderLayout.NORTH);

      /// /
        JPanel painelPrincipal = new JPanel(new GridLayout(3, 1, 10, 20));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));


        JPanel painelNome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelNome.setPreferredSize(new Dimension(150, 30));
        JTextField jtCampoNome = new JTextField(20);
        jtCampoNome.setPreferredSize(new Dimension(200, 30));
        painelNome.add(labelNome);
        painelNome.add(jtCampoNome);
        painelPrincipal.add(painelNome);

        /// /
        JPanel painelData = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelData = new JLabel("Data Limite (d/m/a):");
        labelData.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelData.setPreferredSize(new Dimension(200, 30));
        JTextField campoData = new JTextField(20);
        campoData.setPreferredSize(new Dimension(200, 30));
        painelData.add(labelData);
        painelData.add(campoData);
        painelPrincipal.add(painelData);

       /// /
        JPanel painelNivel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelNivel = new JLabel("Nível da Tarefa:");
        labelNivel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelNivel.setPreferredSize(new Dimension(150, 30));
        String[] niveis = {"1", "2", "3", "4", "5 (Crítico)"};
        JComboBox<String> comboNivel = new JComboBox<>(niveis);
        comboNivel.setPreferredSize(new Dimension(200, 30));
        painelNivel.add(labelNivel);
        painelNivel.add(comboNivel);
        painelPrincipal.add(painelNivel);

        frame.add(painelPrincipal, BorderLayout.CENTER);

       ///
        JPanel painelBotoes = new JPanel();
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));

        JButton btnCadastrar = new JButton("Cadastrar Tarefa");
        btnCadastrar.setPreferredSize(new Dimension(180, 40));
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setPreferredSize(new Dimension(150, 40));
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btnSair = new JButton("Sair");
        btnSair.setPreferredSize(new Dimension(100, 40));
        btnSair.setFont(new Font("Arial", Font.BOLD, 16));

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnCancelar);
        painelBotoes.add(btnSair);

        frame.add(painelBotoes, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}