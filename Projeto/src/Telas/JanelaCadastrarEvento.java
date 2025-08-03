package Telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastrarEvento {
    public static void main(String[] args) {
        JFrame janelaCadastro = new JFrame("Eventos");

        janelaCadastro.setSize(550, 400);
        janelaCadastro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janelaCadastro.setLocationRelativeTo(null);
        janelaCadastro.setResizable(false);
        janelaCadastro.setLayout(null);

        JLabel labelTituloCadastrar = new JLabel("Cadastrar Eventos", SwingConstants.CENTER);
        labelTituloCadastrar.setFont(new Font("Rockwell", Font.PLAIN, 25));
        labelTituloCadastrar.setBounds(150, 30, 250, 60);
        janelaCadastro.add(labelTituloCadastrar);

        JSeparator linhaSeparador = new JSeparator();

        linhaSeparador.setBounds(0, 90, 550, 10);
        linhaSeparador.setForeground(Color.BLACK);
        janelaCadastro.add(linhaSeparador);


        JLabel labelNomeCadastro = new JLabel("Titulo:");
        labelNomeCadastro.setFont(new Font("tahoma", Font.PLAIN, 22));
        labelNomeCadastro.setBounds(100, 120, 100, 30);
        janelaCadastro.add(labelNomeCadastro);

        JTextField jtNome = new JTextField();
        jtNome.setBounds(200, 120, 250, 30);
        janelaCadastro.add(jtNome);
        //
        JLabel labelDesc = new JLabel("Descrição:");
        labelDesc.setFont(new Font("tahoma", Font.PLAIN, 21));
        labelDesc.setBounds(70, 170, 100, 30);
        janelaCadastro.add(labelDesc);

        JLabel labelData = new JLabel("Data:");
        labelData.setFont(new Font("tahoma", Font.PLAIN, 22));
        labelData.setBounds(100, 220, 100, 30);
        janelaCadastro.add(labelData);

        JTextField campoTexto = new JTextField();
        campoTexto.setBounds(200, 220, 200, 30); // Posiciona ao lado da label
        campoTexto.setFont(new Font("tahoma", Font.PLAIN, 20)); // Opcional: define a fonte do texto interno
        janelaCadastro.add(campoTexto);


        JTextField jtEmail = new JTextField();
        jtEmail.setBounds(200, 170, 250, 30);
        janelaCadastro.add(jtEmail);

        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(230, 260, 130, 30);
        janelaCadastro.add(botaoCadastrar);


        jtNome.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                jtEmail.requestFocus();
            }
        });

        janelaCadastro.setVisible(true);
    }
}
