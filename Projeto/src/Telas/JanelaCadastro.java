package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastro extends JFrame {

    private JLabel labelTituloCadastrar;
    private JSeparator linhaSeparador;
    private JLabel labelNomeCadastro;
    private JTextField jtNome;
    private JLabel labelEmail;
    private JTextField jtEmail;
    private JButton botaoCadastrar;

    public JanelaCadastro() {
        configurarJanela();
        inicializarComponentes();
        adicionarComponentes();
        configurarEventos();
    }

    private void configurarJanela() {
        setTitle("Lista de Tarefas");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

    private void inicializarComponentes() {

        labelTituloCadastrar = new JLabel("Cadastrar", SwingConstants.CENTER);
        labelTituloCadastrar.setFont(new Font("Rockwell", Font.PLAIN, 44));
        labelTituloCadastrar.setBounds(150, 30, 250, 60);


        linhaSeparador = new JSeparator();
        linhaSeparador.setBounds(0, 90, 550, 10);
        linhaSeparador.setForeground(Color.BLACK);


        labelNomeCadastro = new JLabel("Nome:");
        labelNomeCadastro.setFont(new Font("tahoma", Font.PLAIN, 22));
        labelNomeCadastro.setBounds(100, 120, 100, 30);

        jtNome = new JTextField();
        jtNome.setBounds(200, 120, 250, 30);


        labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("tahoma", Font.PLAIN, 22));
        labelEmail.setBounds(100, 170, 100, 30);

        jtEmail = new JTextField();
        jtEmail.setBounds(200, 170, 250, 30);


        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(230, 246, 130, 30);
    }

    private void adicionarComponentes() {
        add(labelTituloCadastrar);
        add(linhaSeparador);
        add(labelNomeCadastro);
        add(jtNome);
        add(labelEmail);
        add(jtEmail);
        add(botaoCadastrar);
    }

    private void configurarEventos() {
       //apertar enter muda o campo
        jtNome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtEmail.requestFocus();
            }
        });


        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para cadastrar o usuário
                String nome = jtNome.getText();
                String email = jtEmail.getText();


                if(nome.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                    // Aqui você poderia chamar um método para salvar os dados
                }
                dispose();
                new JanelaLogin().setVisible(true);
            }
        });
    }


    public String getNome() {
        return jtNome.getText();
    }

    public String getEmail() {
        return jtEmail.getText();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadastro().setVisible(true);
            }
        });
    }
}