package Telas;

import javax.swing.*;
import java.awt.*;

public class JanelaCadastrarTarefa {

    public static void main(String[] args) {
        JFrame janelaCadastrarTarefa = new JFrame("Cadastro de Tarefas");
        janelaCadastrarTarefa.setSize(550, 400);
        janelaCadastrarTarefa.setResizable(false);
        janelaCadastrarTarefa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaCadastrarTarefa.setLocationRelativeTo(null);
        janelaCadastrarTarefa.setLayout(new BorderLayout());

        // ---
        // Painel do Título
        // ---
        JLabel labelTitulo = new JLabel("Cadastrar Tarefas", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 44));

        JPanel painelTitulo = new JPanel();
        painelTitulo.setPreferredSize(new Dimension(550, 100));
        painelTitulo.add(labelTitulo);
        janelaCadastrarTarefa.add(painelTitulo, BorderLayout.NORTH);

        // ---
        // Painel de Conteúdo Principal (Usando GridBagLayout)
        // ---
        JPanel painelConteudoPrincipal = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 0, 10, 0); // Espaçamento entre os componentes (top, left, bottom, right)
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza os componentes na célula
        gbc.fill = GridBagConstraints.HORIZONTAL; // Preenche a largura disponível para o painel na grade

        // ---
        // Painel do Nome
        // ---
        JPanel painelNome = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centraliza os componentes
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setFont(new Font("tahoma", Font.PLAIN, 25));
        // Ajuste a largura preferencial do label para ter espaço suficiente
        labelNome.setPreferredSize(new Dimension(150, 30));
        painelNome.add(labelNome);

        JTextField JTnome = new JTextField();
        JTnome.setPreferredSize(new Dimension(200, 30));
        painelNome.add(JTnome);

        gbc.gridx = 0; // Coluna 0
        gbc.gridy = 0; // Linha 0
        painelConteudoPrincipal.add(painelNome, gbc);

        // ---
        // Painel da Data Limite
        // ---
        JPanel painelData = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centraliza os componentes
        JLabel labelData = new JLabel("Data Limite(d/m/a):");
        labelData.setFont(new Font("tahoma", Font.PLAIN, 25));
        // Ajuste a largura preferencial do label
        labelData.setPreferredSize(new Dimension(250, 30));
        painelData.add(labelData);

        JTextField jtdata = new JTextField();
        jtdata.setPreferredSize(new Dimension(200, 30));
        painelData.add(jtdata);

        gbc.gridy = 1; // Linha 1 (abaixo do painelNome)
        painelConteudoPrincipal.add(painelData, gbc);

        // ---
        // Painel para o Nível da Tarefa
        // ---
        JPanel painelNivel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centraliza os componentes
        JLabel labelNivel = new JLabel("Nível da Tarefa:");
        labelNivel.setFont(new Font("tahoma", Font.PLAIN, 25));
        // Ajuste a largura preferencial do label
        labelNivel.setPreferredSize(new Dimension(200, 30));
        painelNivel.add(labelNivel);

        String[] niveis = {"1", "2", "3", "4", "5 (Crítico)"};
        JComboBox<String> jcNivel = new JComboBox<>(niveis);
        jcNivel.setPreferredSize(new Dimension(200, 30));
        painelNivel.add(jcNivel);

        gbc.gridy = 2; // Linha 2 (abaixo do painelData)
        painelConteudoPrincipal.add(painelNivel, gbc);

        // Adiciona o painel de conteúdo principal ao centro do JFrame
        janelaCadastrarTarefa.add(painelConteudoPrincipal, BorderLayout.CENTER);

        // ---
        // Painel para os Botões
        // ---
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20)); // Centraliza e adiciona espaçamento

        JButton btnCadastrar = new JButton("Cadastrar Tarefa");
        btnCadastrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnCadastrar.setPreferredSize(new Dimension(180, 40));
        painelBotoes.add(btnCadastrar);

        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 16));
        btnCancelar.setPreferredSize(new Dimension(150, 40));
        painelBotoes.add(btnCancelar);

        JButton btnSair = new JButton("Sair");
        btnSair.setFont(new Font("Arial", Font.BOLD, 16));
        btnSair.setPreferredSize(new Dimension(100, 40));
        painelBotoes.add(btnSair);

        janelaCadastrarTarefa.add(painelBotoes, BorderLayout.SOUTH); // Adiciona o painel de botões na parte inferior

        janelaCadastrarTarefa.setVisible(true);
    }
}