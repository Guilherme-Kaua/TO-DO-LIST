package Telas;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Importantes.*;

public class JanelaRelatorios extends JFrame {

    private JLabel labelTitulo;
    private JButton botaoPdf;
    private JButton botaoEmail;
    private JButton botaoPlanilha;
    private JPanel painelBotoes;
    private JButton botaoVoltar;
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

        botaoVoltar= new JButton("Voltar");
        botaoVoltar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        botaoVoltar.setFocusPainted(false);

        painelBotoes = new JPanel();
    }

    private void configurarLayout() {

        painelBotoes.setLayout(new BoxLayout(painelBotoes, BoxLayout.Y_AXIS));
        painelBotoes.setBorder(new EmptyBorder(50, 0, 50, 0));


        botaoPdf.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoPlanilha.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoEmail.setAlignmentX(Component.CENTER_ALIGNMENT);
        botaoVoltar.setAlignmentX(Component.CENTER_ALIGNMENT);

        painelBotoes.add(botaoPdf);
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(botaoPlanilha);
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(botaoEmail);
        painelBotoes.add(Box.createVerticalStrut(20));
        painelBotoes.add(botaoVoltar);

        add(labelTitulo, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);

    }

    private void configurarEventos() {
        // Principais.Evento do botão PDF
        botaoPdf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Exportando para PDF...");

            }
        });

        // Principais.Evento do botão Planilha
        botaoPlanilha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Exportando para planilha...");
                // Aqui você implementaria a lógica de exportação para Excel/CSV
            }
        });

        // Principais.Evento do botão Email
        botaoEmail.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Preparando envio por e-mail...");
                //Mensageiro.enviarEmailComPdf()
            }
        });
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Menu().setVisible(true);
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