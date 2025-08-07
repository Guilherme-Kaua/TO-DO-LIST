package Telas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaLogin extends JFrame {

    private JLabel labelloginTitulo;
    private JSeparator separador;
    private JLabel labelNomeUsuario;
    private JTextField jtNome;
    private JLabel labelEmail;
    private JTextField jtEmail;
    private JButton botaoLogin;
    private JButton botaoCadastrar;

    public JanelaLogin() {
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

        labelloginTitulo = new JLabel("Login", SwingConstants.CENTER);
        labelloginTitulo.setFont(new Font("Rockwell", Font.PLAIN, 44));
        labelloginTitulo.setBounds(150, 30, 250, 60);


        separador = new JSeparator();
        separador.setBounds(0, 90, 550, 10);
        separador.setForeground(Color.BLACK);


        labelNomeUsuario = new JLabel("Nome:");
        labelNomeUsuario.setFont(new Font("tahoma", Font.PLAIN, 22));
        labelNomeUsuario.setBounds(100, 120, 100, 30);

        jtNome = new JTextField();
        jtNome.setBounds(200, 120, 250, 30);


        labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("tahoma", Font.PLAIN, 22));
        labelEmail.setBounds(100, 170, 100, 30);

        jtEmail = new JTextField();
        jtEmail.setBounds(200, 170, 250, 30);


        botaoLogin = new JButton("Login");
        botaoLogin.setBounds(150, 246, 130, 30);

        botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(300, 246, 130, 30);
    }

    private void adicionarComponentes() {
        add(labelloginTitulo);
        add(separador);
        add(labelNomeUsuario);
        add(jtNome);
        add(labelEmail);
        add(jtEmail);
        add(botaoLogin);
        add(botaoCadastrar);
    }

    private void configurarEventos() {

        jtNome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtEmail.requestFocus();
            }
        });

        botaoLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = jtNome.getText();
                String email = jtEmail.getText();

                if(nome.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
                } else {
                  //Login
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    dispose();
                    new Menu().setVisible(true);

                }
            }
        });


        botaoCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Redirecionando para cadastro...");
                dispose();
                new JanelaCadastro().setVisible(true);
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
                new JanelaLogin().setVisible(true);
            }
        });
    }
}