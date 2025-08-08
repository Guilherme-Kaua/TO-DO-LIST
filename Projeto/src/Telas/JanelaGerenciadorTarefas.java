package Telas;

import CRUD.ManipuladorDeTarefas;
import Importantes.PersistenciaTarefa;
import Principais.Tarefa;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class JanelaGerenciadorTarefas extends JFrame {

    // --- Componentes da Interface Gráfica ---
    private JTabbedPane abas;
    private DefaultTableModel tableModel;
    private JTable tabelaTarefas;

    // --- Componentes do Formulário de Cadastro ---
    private JTextField campoNome;
    private JTextArea areaDescricao;
    private JTextField campoData;
    private JComboBox<String> comboNivel;

    // --- Lógica e Persistência de Dados ---
    private ManipuladorDeTarefas manipuladorDeTarefas;
    private final PersistenciaTarefa persistenciaTarefa;

    /**
     * Construtor principal da janela.
     */
    public JanelaGerenciadorTarefas() throws FileNotFoundException {
        // 1. Inicializa a persistência e carrega os dados existentes
        this.persistenciaTarefa = new PersistenciaTarefa();
        this.manipuladorDeTarefas = persistenciaTarefa.recuperarTarefas(); // Carrega tarefas salvas

        // 2. Configura a janela e seus componentes
        configurarJanela();
        inicializarComponentes();
        configurarAbas();

        // 3. Popula a tabela com os dados carregados
        carregarTarefasNaTabela();
    }

    /**
     * Define as propriedades principais da janela (JFrame).
     */
    private void configurarJanela() {
        setTitle("Gerenciador de Tarefas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
    }

    /**
     * Inicializa os componentes Swing que serão usados na interface.
     */
    private void inicializarComponentes() {
        abas = new JTabbedPane();

        // Modelo da tabela para listagem
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Título");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Data");
        tableModel.addColumn("Nível");

        tabelaTarefas = new JTable(tableModel);

        // Componentes do formulário (inicializados nos métodos de criação das abas)
        campoNome = new JTextField(20);
        areaDescricao = new JTextArea(5, 20);
        campoData = new JTextField(20);
        String[] niveis = {"1", "2", "3", "4", "5 (Crítico)"};
        comboNivel = new JComboBox<>(niveis);
    }

    /**
     * Adiciona as abas (tabs) ao painel principal.
     */
    private void configurarAbas() {
        abas.addTab("Cadastrar", criarAbaCadastrar());
        abas.addTab("Listar", criarAbaListar());
        abas.addTab("Excluir", criarAbaExcluir());
        add(abas, BorderLayout.CENTER);
    }

    // --- Métodos de Criação das Abas ---

    private JPanel criarAbaCadastrar() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelTitulo = new JLabel("Cadastrar Nova Tarefa", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 30));
        painel.add(labelTitulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Título
        gbc.gridx = 0; gbc.gridy = 0;
        formulario.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        formulario.add(campoNome, gbc);

        // Descrição
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.NORTHWEST;
        formulario.add(new JLabel("Descrição:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.fill = GridBagConstraints.BOTH; gbc.weighty = 1.0;
        areaDescricao.setLineWrap(true);
        formulario.add(new JScrollPane(areaDescricao), gbc);

        // Data
        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.WEST; gbc.weighty = 0;
        formulario.add(new JLabel("Data (dd/mm/aaaa):"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.fill = GridBagConstraints.HORIZONTAL;
        formulario.add(campoData, gbc);

        // Nível
        gbc.gridx = 0; gbc.gridy = 3;
        formulario.add(new JLabel("Nível:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.fill = GridBagConstraints.HORIZONTAL;
        formulario.add(comboNivel, gbc);

        painel.add(formulario, BorderLayout.CENTER);

        // Botões
        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnCadastrar = new JButton("Cadastrar");
        JButton btnLimpar = new JButton("Limpar");
        JButton btnVoltar = new JButton("Voltar");
        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnVoltar);
        painel.add(painelBotoes, BorderLayout.SOUTH);

        // --- Configuração de Eventos dos Botões da Aba ---
        btnCadastrar.addActionListener(e -> cadastrarNovaTarefa());
        btnLimpar.addActionListener(e -> limparFormulario());
        btnVoltar.addActionListener(e -> voltarAoMenu());

        return painel;
    }

    private JPanel criarAbaListar() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelTitulo = new JLabel("Listar Tarefas", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 30));
        painel.add(labelTitulo, BorderLayout.NORTH);

        painel.add(new JScrollPane(tabelaTarefas), BorderLayout.CENTER);

        JButton btnAtualizar = new JButton("Atualizar Lista do Arquivo");
        btnAtualizar.addActionListener(e -> {
            try {
                this.manipuladorDeTarefas = persistenciaTarefa.recuperarTarefas();
                carregarTarefasNaTabela();
                JOptionPane.showMessageDialog(this, "Lista de tarefas atualizada!", "Informação", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(this, "Arquivo de dados não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
        painel.add(btnAtualizar, BorderLayout.SOUTH);

        return painel;
    }

    private JPanel criarAbaExcluir() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel labelTitulo = new JLabel("Excluir Tarefa", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 30));
        painel.add(labelTitulo, BorderLayout.NORTH);

        JPanel painelInfo = new JPanel();
        painelInfo.setLayout(new BoxLayout(painelInfo, BoxLayout.Y_AXIS));
        painelInfo.add(new JLabel("Para excluir uma tarefa:"));
        painelInfo.add(new JLabel("1. Vá para a aba 'Listar'."));
        painelInfo.add(new JLabel("2. Clique na linha da tarefa que deseja remover."));
        painelInfo.add(new JLabel("3. Clique no botão 'Excluir Tarefa Selecionada' abaixo."));
        painel.add(painelInfo, BorderLayout.CENTER);

        JButton btnExcluir = new JButton("Excluir Tarefa Selecionada");
        btnExcluir.addActionListener(e -> excluirTarefaSelecionada());
        painel.add(btnExcluir, BorderLayout.SOUTH);

        return painel;
    }


    // --- Métodos de Persistência e Manipulação de Dados ---

    private void salvarTarefas() {
        try {
            persistenciaTarefa.salvarTarefas(this.manipuladorDeTarefas);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar as tarefas: " + ex.getMessage(), "Erro de Persistência", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregarTarefasNaTabela() {
        tableModel.setRowCount(0); // Limpa a tabela para evitar duplicatas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (manipuladorDeTarefas.getTarefas() != null) {
            for (Tarefa tarefa : manipuladorDeTarefas.getTarefas()) {
                tableModel.addRow(new Object[]{
                        tarefa.getTitulo(),
                        tarefa.getDescricao(),
                        tarefa.getDeadline().format(formatter),
                        tarefa.getNivel()
                });
            }
        }
    }

    // --- Métodos de Ações de Eventos ---

    private void cadastrarNovaTarefa() {
        if (campoNome.getText().trim().isEmpty() || campoData.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha pelo menos o título e a data!", "Campos obrigatórios", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate deadline = LocalDate.parse(campoData.getText(), formatter);

            Tarefa novaTarefa = new Tarefa(
                    campoNome.getText(),
                    areaDescricao.getText(),
                    deadline,
                    comboNivel.getSelectedIndex() + 1
            );

            manipuladorDeTarefas.adicionarTarefa(novaTarefa);
            salvarTarefas();
            carregarTarefasNaTabela();

            JOptionPane.showMessageDialog(this, "Tarefa cadastrada com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            limparFormulario();

        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(this, "Formato de data inválido. Use dd/mm/aaaa.", "Erro de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar tarefa: " + ex.getMessage(), "Erro Inesperado", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void excluirTarefaSelecionada() {
        int selectedRow = tabelaTarefas.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Selecione uma tarefa na aba 'Listar' primeiro!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
                this,
                "Tem certeza que deseja excluir esta tarefa?",
                "Confirmar Exclusão",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Remove da lista de dados e do modelo da tabela
            manipuladorDeTarefas.getTarefas().remove(selectedRow);
            tableModel.removeRow(selectedRow);

            // Salva o estado atual sem a tarefa
            salvarTarefas();

            JOptionPane.showMessageDialog(this, "Tarefa excluída com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void limparFormulario() {
        campoNome.setText("");
        areaDescricao.setText("");
        campoData.setText("");
        comboNivel.setSelectedIndex(0);
    }

    private void voltarAoMenu() {
        // Garante que tudo seja salvo antes de sair
        dispose();
        new Menu().setVisible(true);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new JanelaGerenciadorTarefas().setVisible(true);
            } catch (FileNotFoundException e) {
                JOptionPane.showMessageDialog(null, "Erro crítico ao carregar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                throw new RuntimeException(e);
            }
        });
    }
}