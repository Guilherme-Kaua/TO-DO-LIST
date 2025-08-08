package Telas;

import CRUD.ManipuladorDeEventos;
import Importantes.PersistenciaEvento;
import Principais.Evento;
import Principais.Tarefa;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JanelaEventos extends JFrame {
    // Componentes principais
    private JTabbedPane abas;
    private JPanel painelTodas;
    private JPanel painelMes;
    private JPanel painelDia;
    private JPanel painelSair;
    private JButton botaoVoltar;
    private DefaultTableModel tableModel;
    private JTable tabelaEventos;

    // Componentes do painel "Todas"
    private JButton botaoAdicionar;
    private JTextArea inputTitulo;
    private JTextArea inputDesc;
    private JTextArea inputData;
    private JButton botaoEditar;
    private JButton botaoExcluir;
    private JButton botaoSair;

    private PersistenciaEvento persistenciaEvento;
    private ManipuladorDeEventos manipuladorDeEventos;

    public JanelaEventos() throws FileNotFoundException {
        this.persistenciaEvento = new PersistenciaEvento();
        this.manipuladorDeEventos = persistenciaEvento.recuperarEventos();
        configurarJanela();
        inicializarComponentes();
        configurarLayout();
        adicionarEventos();
        carregarEventosNaTabela();
    }

    private void configurarJanela() {
        setTitle("Sistema de Eventos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        abas = new JTabbedPane();

        // Painel "Todas"
        botaoAdicionar = new JButton("+ Adicionar Evento");
        inputTitulo = new JTextArea();
        inputDesc = new JTextArea();
        inputData = new JTextArea();
        botaoEditar = new JButton("Editar Evento");
        botaoExcluir = new JButton("Excluir Evento");
        botaoVoltar= new JButton("Voltar");

        // Modelo da tabela para listagem
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Título");
        tableModel.addColumn("Descrição");
        tableModel.addColumn("Data");

        tabelaEventos = new JTable(tableModel);

        // Painel "Sair"
        botaoSair = new JButton("Sair");
    }
    private void salvarEventos() {
        try {

            persistenciaEvento.salvarEventos(this.manipuladorDeEventos);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar as tarefas: " + ex.getMessage(), "Erro de Persistência", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void configurarLayout() {
        // Configuração do painel "Todas"
        painelTodas = new JPanel(new BorderLayout());

        JPanel painelEvento = new JPanel(new GridLayout(5, 2, 10, 10));
        Border borda = BorderFactory.createLineBorder(Color.BLACK);

        inputTitulo.setBorder(borda);
        inputDesc.setBorder(borda);
        inputData.setBorder(borda);

        painelEvento.add(new JLabel("Titulo:"));
        painelEvento.add(inputTitulo);
        painelEvento.add(new JLabel("Descrição:"));
        painelEvento.add(inputDesc);
        painelEvento.add(new JLabel("Data do evento:"));
        painelEvento.add(inputData);

        JPanel botoes = new JPanel();
        botoes.add(botaoEditar);
        botoes.add(botaoExcluir);
        botoes.add(botaoVoltar);

        painelTodas.add(botaoAdicionar, BorderLayout.NORTH);
        painelTodas.add(painelEvento, BorderLayout.CENTER);
        painelTodas.add(botoes, BorderLayout.SOUTH);

        // Painéis vazios (podem ser implementados depois)
        painelMes = new JPanel();
        painelDia = new JPanel();

        // Painel "Sair"
        painelSair = new JPanel();
        painelSair.add(botaoSair);

        // Adicionando abas
        abas.addTab("Todas", painelTodas);
        abas.addTab("Listar Eventos", tabelaEventos);
        abas.addTab("Listar por mês", painelMes);
        abas.addTab("Listar por dia", painelDia);
        abas.addTab("Sair", painelSair);

        add(abas);
    }

    private void carregarEventosNaTabela() {

        tableModel.setRowCount(0); // Limpa a tabela para evitar duplicatas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (manipuladorDeEventos.getEventos() != null) {
            for (Evento evento : manipuladorDeEventos.getEventos()) {
                tableModel.addRow(new Object[]{
                        evento.getTitulo(),
                        evento.getDescricao(),
                        evento.getDataEvento().format(formatter),
                });
            }
        }
    }

    private void adicionarEventos() {
        botaoSair.addActionListener(e -> System.exit(0));

        botaoAdicionar.addActionListener(e -> {
            // Lógica para adicionar novo evento
            String titulo = inputTitulo.getText();
            String descricao = inputDesc.getText();
            String data = inputData.getText();

            if (titulo.isEmpty() || data.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Preencha pelo menos título e data!");
            } else {
                // Aqui você adicionaria o evento à lista
                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate deadline = LocalDate.parse(inputData.getText(), formatter);

                    Evento novoEvento = new Evento(
                            inputTitulo.getText(),
                            inputDesc.getText(),
                            deadline
                    );

                    manipuladorDeEventos.adicionarEvento(novoEvento);
                    salvarEventos();
                    carregarEventosNaTabela();


                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(this, "Evento adicionado com sucesso!");
                limparCampos();
            }
        });

        botaoEditar.addActionListener(e -> {
            // Lógica para editar evento
            JOptionPane.showMessageDialog(this, "Funcionalidade de edição em desenvolvimento");
        });

        botaoExcluir.addActionListener(e -> {
            // Lógica para excluir evento
            JOptionPane.showMessageDialog(this, "Funcionalidade de exclusão em desenvolvimento");
        });
        botaoVoltar.addActionListener(e-> {
            dispose();
            new Menu().setVisible(true);
        });
    }

    private void limparCampos() {
        inputTitulo.setText("");
        inputDesc.setText("");
        inputData.setText("");
    }

    // Getters para os campos (opcional)
    public String getTituloEvento() {
        return inputTitulo.getText();
    }

    public String getDescricaoEvento() {
        return inputDesc.getText();
    }

    public String getDataEvento() {
        return inputData.getText();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new JanelaEventos().setVisible(true);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}