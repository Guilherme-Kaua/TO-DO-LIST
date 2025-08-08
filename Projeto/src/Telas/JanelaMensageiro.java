package Telas;

import CRUD.ManipuladorDeTarefas;
import Importantes.Mensageiro;
import Importantes.Persistencia;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JanelaMensageiro extends JFrame {
    private JTextField campoEmail;
    private JTextField campoData;
    private Mensageiro mensageiro;
    private ManipuladorDeTarefas manipuladorDeTarefas;
    private Persistencia persistencia;
    public JanelaMensageiro() throws FileNotFoundException {
        this.persistencia= new Persistencia();
        this.manipuladorDeTarefas= persistencia.recuperarTarefas();
        this.mensageiro= new Mensageiro();
        configurarJanela();
        inicializarComponentes();
        setVisible(true);
    }

    private void configurarJanela() {
        setTitle("Enviar Email");
        setSize(400, 250);
        setLocationRelativeTo(null); // Centraliza a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    private void inicializarComponentes() {
        // Painel principal com layout em grade (2 colunas)
        JPanel painelCampos = new JPanel(new GridLayout(2, 2, 10, 10));

        // Email
        JLabel labelEmail = new JLabel("Email:");
        campoEmail = new JTextField();
        painelCampos.add(labelEmail);
        painelCampos.add(campoEmail);

        // Data
        JLabel labelData = new JLabel("Data:");
        campoData = new JTextField();
        painelCampos.add(labelData);
        painelCampos.add(campoData);

        // Botão
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
            String email = campoEmail.getText().trim();
            String[] data = campoData.getText().split("/");
            LocalDate datateste = LocalDate.of(
                    Integer.parseInt(data[2]),
                    Integer.parseInt(data[1]),
                    Integer.parseInt(data[0])
            );

            if (email.isEmpty() ){
                throw new Exception("Preencha todos os campos.");
            }

            ManipuladorDeTarefas ManipuladorDeTarefas = null;
            mensageiro.enviarEmailComPdf(email,datateste,manipuladorDeTarefas);

            // Aqui ficaria a lógica de envio do email
            JOptionPane.showMessageDialog(this, "Email enviado com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
       JanelaMensageiro ja = new JanelaMensageiro();
       ja.setVisible(true);
    }
}
