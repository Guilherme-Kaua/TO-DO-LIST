package Telas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaGerenciadorTarefas extends JFrame {
    private JTabbedPane abas;


    private DefaultTableModel tableModel;
    private JTable tabelaTarefas;


    private JTextField campoNome;
    private JTextArea areaDescricao;
    private JTextField campoData;
    private JComboBox<String> comboNivel;

    public JanelaGerenciadorTarefas() {
        configurarJanela();
        inicializarComponentes();
        configurarAbas();
        configurarEventos();
    }

    private void configurarJanela() {
        setTitle("Gerenciador de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {
        abas = new JTabbedPane();

        // Modelo da tabela para listagem
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nome");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Data");
        tableModel.addColumn("Nível");

        tabelaTarefas = new JTable(tableModel);
    }

    private void configurarAbas() {

        JPanel painelCadastrar = criarAbaCadastrar();


        JPanel painelListar = criarAbaListar();


        JPanel painelEditar = criarAbaEditar();


        JPanel painelExcluir = criarAbaExcluir();


        abas.addTab("Cadastrar", painelCadastrar);
        abas.addTab("Listar", painelListar);
        abas.addTab("Editar", painelEditar);
        abas.addTab("Excluir", painelExcluir);

        add(abas, BorderLayout.CENTER);
    }

    private JPanel criarAbaCadastrar() {
        JPanel painel = new JPanel(new BorderLayout());


        JLabel labelTitulo = new JLabel("Cadastrar Tarefas", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 30));
        painel.add(labelTitulo, BorderLayout.NORTH);


        JPanel formulario = new JPanel();
        formulario.setLayout(new BoxLayout(formulario, BoxLayout.Y_AXIS));
        formulario.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));


        JPanel painelNome = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
        campoNome = new JTextField(20);
        campoNome.setPreferredSize(new Dimension(200, 30));
        painelNome.add(labelNome);
        painelNome.add(campoNome);


        JPanel painelDescricao = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelDescricao = new JLabel("Descrição:");
        labelDescricao.setFont(new Font("Tahoma", Font.PLAIN, 16));
        areaDescricao = new JTextArea(5, 20);
        areaDescricao.setLineWrap(true);
        JScrollPane scrollDescricao = new JScrollPane(areaDescricao);
        scrollDescricao.setPreferredSize(new Dimension(300, 100));
        painelDescricao.add(labelDescricao);
        painelDescricao.add(scrollDescricao);


        JPanel painelData = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelData = new JLabel("Data (d/m/a):");
        labelData.setFont(new Font("Tahoma", Font.PLAIN, 16));
        campoData = new JTextField(20);
        campoData.setPreferredSize(new Dimension(200, 30));
        painelData.add(labelData);
        painelData.add(campoData);


        JPanel painelNivel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelNivel = new JLabel("Nível:");
        labelNivel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        String[] niveis = {"1", "2", "3", "4", "5 (Crítico)"};
        comboNivel = new JComboBox<>(niveis);
        comboNivel.setPreferredSize(new Dimension(200, 30));
        painelNivel.add(labelNivel);
        painelNivel.add(comboNivel);


        JPanel painelBotoes = new JPanel();
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnLimpar = new JButton("Limpar");
        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnLimpar);


        formulario.add(painelNome);
        formulario.add(Box.createVerticalStrut(10));
        formulario.add(painelDescricao);
        formulario.add(Box.createVerticalStrut(10));
        formulario.add(painelData);
        formulario.add(Box.createVerticalStrut(10));
        formulario.add(painelNivel);

        painel.add(formulario, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarAbaListar() {
        JPanel painel = new JPanel(new BorderLayout());


        JLabel labelTitulo = new JLabel("Listar Tarefas", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 30));
        painel.add(labelTitulo, BorderLayout.NORTH);


        JScrollPane scrollPane = new JScrollPane(tabelaTarefas);
        painel.add(scrollPane, BorderLayout.CENTER);


        JButton btnAtualizar = new JButton("Atualizar Lista");
        painel.add(btnAtualizar, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarAbaEditar() {
        JPanel painel = new JPanel(new BorderLayout());


        JLabel labelTitulo = new JLabel("Editar Tarefa", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 30));
        painel.add(labelTitulo, BorderLayout.NORTH);


        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));


        JPanel painelSelecao = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelSelecionar = new JLabel("Selecione a tarefa:");
        labelSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JComboBox<String> comboEditar = new JComboBox<>();
        comboEditar.setPreferredSize(new Dimension(300, 30));
        painelSelecao.add(labelSelecionar);
        painelSelecao.add(comboEditar);


        JPanel painelBotoes = new JPanel();
        JButton btnCarregar = new JButton("Carregar Dados");
        JButton btnSalvar = new JButton("Salvar Alterações");
        painelBotoes.add(btnCarregar);
        painelBotoes.add(btnSalvar);

        painelPrincipal.add(painelSelecao);
        painel.add(painelPrincipal, BorderLayout.CENTER);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarAbaExcluir() {
        JPanel painel = new JPanel(new BorderLayout());


        JLabel labelTitulo = new JLabel("Excluir Tarefa", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 30));
        painel.add(labelTitulo, BorderLayout.NORTH);


        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BoxLayout(painelPrincipal, BoxLayout.Y_AXIS));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));


        JPanel painelSelecao = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel labelSelecionar = new JLabel("Selecione a tarefa:");
        labelSelecionar.setFont(new Font("Tahoma", Font.PLAIN, 16));
        JComboBox<String> comboExcluir = new JComboBox<>();
        comboExcluir.setPreferredSize(new Dimension(300, 30));
        painelSelecao.add(labelSelecionar);
        painelSelecao.add(comboExcluir);


        JButton btnExcluir = new JButton("Excluir Tarefa");

        painelPrincipal.add(painelSelecao);
        painel.add(painelPrincipal, BorderLayout.CENTER);
        painel.add(btnExcluir, BorderLayout.SOUTH);

        return painel;
    }

    private void configurarEventos() {

        JPanel painelCadastrar = (JPanel) abas.getComponentAt(0);
        JButton btnCadastrar = (JButton) ((JPanel)painelCadastrar.getComponent(2)).getComponent(0);
        JButton btnLimpar = (JButton) ((JPanel)painelCadastrar.getComponent(2)).getComponent(1);

        JPanel painelListar = (JPanel) abas.getComponentAt(1);
        JButton btnAtualizar = (JButton) painelListar.getComponent(2);

        JPanel painelEditar = (JPanel) abas.getComponentAt(2);
        JButton btnCarregar = (JButton) ((JPanel)painelEditar.getComponent(2)).getComponent(0);
        JButton btnSalvar = (JButton) ((JPanel)painelEditar.getComponent(2)).getComponent(1);

        JPanel painelExcluir = (JPanel) abas.getComponentAt(3);
        JButton btnExcluir = (JButton) painelExcluir.getComponent(2);


        btnCadastrar.addActionListener(e -> {
            if (campoNome.getText().trim().isEmpty() || campoData.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Preencha pelo menos o nome e a data!",
                        "Campos obrigatórios",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            tableModel.addRow(new Object[]{
                    campoNome.getText(),
                    areaDescricao.getText(),
                    campoData.getText(),
                    comboNivel.getSelectedItem()
            });

            JOptionPane.showMessageDialog(this,
                    "Tarefa cadastrada com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);

            campoNome.setText("");
            areaDescricao.setText("");
            campoData.setText("");
            comboNivel.setSelectedIndex(0);
        });

        btnLimpar.addActionListener(e -> {
            campoNome.setText("");
            areaDescricao.setText("");
            campoData.setText("");
            comboNivel.setSelectedIndex(0);
        });

        btnAtualizar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Lista de tarefas atualizada!",
                    "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        btnCarregar.addActionListener(e -> {
            if (tabelaTarefas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this,
                        "Selecione uma tarefa na aba Listar primeiro!",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            JOptionPane.showMessageDialog(this,
                    "Dados da tarefa carregados para edição!",
                    "Informação",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        btnSalvar.addActionListener(e -> {
            JOptionPane.showMessageDialog(this,
                    "Alterações salvas com sucesso!",
                    "Sucesso",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        btnExcluir.addActionListener(e -> {
            if (tabelaTarefas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(this,
                        "Selecione uma tarefa na aba Listar primeiro!",
                        "Aviso",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(
                    this,
                    "Tem certeza que deseja excluir esta tarefa?",
                    "Confirmar Exclusão",
                    JOptionPane.YES_NO_OPTION);

            if (confirmacao == JOptionPane.YES_OPTION) {
                tableModel.removeRow(tabelaTarefas.getSelectedRow());
                JOptionPane.showMessageDialog(this,
                        "Tarefa excluída com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JanelaGerenciadorTarefas janela = new JanelaGerenciadorTarefas();
            janela.setVisible(true);
        });
    }
}