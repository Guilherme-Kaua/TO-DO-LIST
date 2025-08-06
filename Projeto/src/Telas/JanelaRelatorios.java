package Telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaRelatorios extends JFrame {

    private JLabel labelTitulo;
    private JButton botaoPdf;
    private JButton botaoEmail;
    private JButton botaoPlanilha;
    private JPanel painelBotoes;

    public JanelaRelatorios() {
        configurarJanela();
        inicializarComponentes();
        configurarLayout();
        configurarEventos();
    }

    private void configurarJanela() {
        setTitle("Relatórios");
        setSize(550, 400);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void inicializarComponentes() {

        labelTitulo = new JLabel("Relatórios", SwingConstants.CENTER);
        labelTitulo.setFont(new Font("Rockwell", Font.PLAIN, 44));


        botaoPdf = new JButton("Exportar relatório no formato PDF");
        botaoPdf.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoPdf.setFocusPainted(false);

        botaoEmail = new JButton("Enviar as tarefas por e-mail");
        botaoEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoEmail.setFocusPainted(false);

        botaoPlanilha = new JButton("Exportar o relatório para uma planilha");
        botaoPlanilha.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoPlanilha.setFocusPainted(false);


        painelBotoes = new JPanel();
    }

    private void configurarLayout() {

        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBorder(new EmptyBorder(50, 0, 50, 0));


        botaoPdf.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoPlanilha.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoEmail.setAlignmentX(Component.CENTER_ALIGNMENT);


        painelBotoes.add(botaoPdf);
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(botaoPlanilha);
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(botaoEmail);


        add(labelTitulo, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);
    }

    private void configurarEventos() {
        // Evento do botão PDF
        botaoPdf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Exportando para PDF...");
                // Aqui você implementaria a lógica de exportação para PDF
            }
        });

        // Evento do botão Planilha
        botaoPlanilha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Exportando para planilha...");
                // Aqui você implementaria a lógica de exportação para Excel/CSV
            }
        });

        // Evento do botão Email
        botaoEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Preparando envio por e-mail...");
                // Aqui você implementaria a lógica de envio por e-mail
            }
        });
    }

    // Métodos para acessar os botões (opcional)
    public JButton getBotaoPdf() {
        return botaoPdf;
    }

    public JButton getBotaoPlanilha() {
        return botaoPlanilha;
    }

    public JButton getBotaoEmail() {
        return botaoEmail;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JanelaRelatorios().setVisible(true);
            }
        });
    }
}