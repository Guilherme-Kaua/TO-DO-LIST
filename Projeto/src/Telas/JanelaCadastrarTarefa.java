package Telas;

import javax.swing.*;
import java.awt.*;

public class JanelaCadastrarTarefa extends JFrame {

    private JLabel labelTitulo;
    private JLabel labelNome;
    private JTextField jtCampoNome;
    private JLabel labelData;
    private JTextField campoData;
    private JLabel labelNivel;
    private JComboBox<String> comboNivel;
    private JButton btnCadastrar;
    private JButton btnCancelar;
    private JButton btnSair;

    public JanelaCadastrarTarefa() {
        configurarJanela();
        inicializarComponentes();
        adicionarComponentes();
        configurarEventos();
    }

    private void configurarJanela() {
        setTitle("Cadastro de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 400);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {

        labelTitulo = new JLabel("Cadastrar Tarefas", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 44));


        labelNome = new JLabel("Nome:");
        labelNome.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelNome.setPreferredSize(new Dimension(150, 30));
        jtCampoNome = new JTextField(20);
        jtCampoNome.setPreferredSize(new Dimension(200, 30));


        labelData = new JLabel("Data Limite (d/m/a):");
        labelData.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelData.setPreferredSize(new Dimension(200, 30));
        campoData = new JTextField(20);
        campoData.setPreferredSize(new Dimension(200, 30));


        labelNivel = new JLabel("Nível da Tarefa:");
        labelNivel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        labelNivel.setPreferredSize(new Dimension(150, 30));
        String[] niveis = {"1", "2", "3", "4", "5 (Crítico)"};
        comboNivel = new JComboBox<>(niveis);
        comboNivel.setPreferredSize(new Dimension(200, 30));


        btnCadastrar = new JButton("Cadastrar Tarefa");
        btnCadastrar.setPreferredSize(new Dimension(180, 40));
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 16));

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setPreferredSize(new Dimension(150, 40));
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));

        btnSair = new JButton("Sair");
        btnSair.setPreferredSize(new Dimension(100, 40));
        btnSair.setFont(new Font("Arial", Font.BOLD, 16));
    }

    private void adicionarComponentes() {

        JPanel painelTitulo = new JPanel();
        painelTitulo.add(labelTitulo);
        add(painelTitulo, BorderLayout.NORTH);


        JPanel painelPrincipal = new JPanel(new GridLayout(3, 1, 10, 20));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));


        JPanel painelNome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelNome.add(labelNome);
        painelNome.add(jtCampoNome);
        painelPrincipal.add(painelNome);


        JPanel painelData = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelData.add(labelData);
        painelData.add(campoData);
        painelPrincipal.add(painelData);


        JPanel painelNivel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelNivel.add(labelNivel);
        painelNivel.add(comboNivel);
        painelPrincipal.add(painelNivel);

        add(painelPrincipal, BorderLayout.CENTER);


        JPanel painelBotoes = new JPanel();
        painelBotoes.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnCancelar);
        painelBotoes.add(btnSair);

        add(painelBotoes, BorderLayout.SOUTH);
    }

    private void configurarEventos() {

        btnSair.addActionListener(e -> System.exit(0));


        btnCancelar.addActionListener(e -> {
            jtCampoNome.setText("");
            campoData.setText("");
            comboNivel.setSelectedIndex(0);
        });


    }

    public JTextField getJtCampoNome() {
        return jtCampoNome;
    }

    public JTextField getCampoData() {
        return campoData;
    }

    public JComboBox<String> getComboNivel() {
        return comboNivel;
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JanelaCadastrarTarefa().setVisible(true));
    }
}