package Telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastro {
    public static void main(String[] args) {
        JFrame janelaCadastro = new JFrame("Lista de Tarefas");

        janelaCadastro.setSize(550, 400);
        janelaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaCadastro.setLocationRelativeTo(null);
        janelaCadastro.setResizable(false);
        janelaCadastro.setLayout(null);

        JLabel labelTituloCadastrar = new JLabel("Cadastrar", SwingConstants.CENTER);
        labelTituloCadastrar.setFont(new Font("Rockwell", Font.PLAIN, 44));
        labelTituloCadastrar.setBounds(150, 30, 250, 60);
        janelaCadastro.add(labelTituloCadastrar);

        JSeparator linhaSeparador = new JSeparator();

        linhaSeparador.setBounds(0, 90, 550, 10); // Posicionado abaixo do título
        linhaSeparador.setForeground(Color.BLACK);
        janelaCadastro.add(linhaSeparador);


        JLabel labelNomeCadastro = new JLabel("Nome:");
        labelNomeCadastro.setFont(new Font("tahoma", Font.PLAIN, 22));
        labelNomeCadastro.setBounds(100, 120, 100, 30);
        janelaCadastro.add(labelNomeCadastro);

        JTextField jtNome = new JTextField();
        jtNome.setBounds(200, 120, 250, 30);
        janelaCadastro.add(jtNome);
        //
        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setFont(new Font("tahoma", Font.PLAIN, 22));
        labelEmail.setBounds(100, 170, 100, 30);
        janelaCadastro.add(labelEmail);

        JTextField jtEmail = new JTextField();
        jtEmail.setBounds(200, 170, 250, 30);
        janelaCadastro.add(jtEmail);

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(230, 246, 130, 30);
        janelaCadastro.add(botaoCadastrar);


        jtNome.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jtEmail.requestFocus();
            }
        });

        janelaCadastro.setVisible(true);
    }
}

