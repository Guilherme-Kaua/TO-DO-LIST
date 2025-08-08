package Telas;

import CRUD.ManipuladorDeTarefas;
import Importantes.GeradorDeRelatorios;
import Importantes.PersistenciaTarefa;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.time.LocalDate;

public class JanelaPDF extends JFrame {
    private JTextField campoData;
    private ManipuladorDeTarefas manipuladorDeTarefas;
    private PersistenciaTarefa persistenciaTarefa;

    public JanelaPDF() throws FileNotFoundException {
        this.persistenciaTarefa = new PersistenciaTarefa();
        this.manipuladorDeTarefas = persistenciaTarefa.recuperarTarefas();
        configurarJanela();
        inicializarComponentes();
        setVisible(true);
    }
    private void configurarJanela() {
        setTitle("Criar PDF");
        setSize(400, 250);
        setLocationRelativeTo(null); // Centraliza a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicializarComponentes() {
        // Painel principal com layout em grade (2 colunas)
        JPanel painelCampos = new JPanel(new GridLayout(2, 2, 10, 10));


        JLabel labelData = new JLabel("Data:");
        campoData = new JTextField();
        painelCampos.add(labelData);
        painelCampos.add(campoData);

        JButton botaoEnviar = new JButton("Enviar");
        botaoEnviar.addActionListener(e -> enviar());

        // Layout final
        setLayout(new BorderLayout(10, 10));
        add(painelCampos, BorderLayout.CENTER);
        add(botaoEnviar, BorderLayout.SOUTH);
        getRootPane().setDefaultButton(botaoEnviar); // Enter para enviar
        ((JComponent) getContentPane()).setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    }
    private void enviar() {
        try {
            String[] data = campoData.getText().split("/");
            LocalDate datateste = LocalDate.of(
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[0])
            );
            GeradorDeRelatorios.obterTarefasDeUmDia(datateste,manipuladorDeTarefas);
            JOptionPane.showMessageDialog(this, "PDF criado!");
} catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro");
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        JanelaPDF ja = new JanelaPDF();
        ja.setVisible(true);}
}
