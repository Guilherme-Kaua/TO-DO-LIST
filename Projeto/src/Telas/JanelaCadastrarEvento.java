package Telas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JanelaCadastrarEvento extends JFrame {
    private JLabel labelTituloCadastrar;
    private JSeparator linhaSeparador;
    private JLabel labelNomeCadastro;
    private JTextField jtNome;
    private JLabel labelDesc;
    private JTextField jtEmail;
    private JLabel labelData;
    private JTextField campoTexto;
    private JButton botaoCadastrar;


    public JanelaCadastrarEvento() {
        configurarJanela();
        inicializarComponentes();
        adicionarComponentes();
        configurarEventos();
    }

    private void configurarJanela() {

        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
    }

    private void inicializarComponentes() {
        this.labelTituloCadastrar = new JLabel("Cadastrar Eventos", SwingConstants.CENTER);
        this.labelTituloCadastrar.setFont(new Font("Rockwell", Font.PLAIN, 25));
        this.labelTituloCadastrar.setBounds(150, 30, 250, 60);


        this.linhaSeparador = new JSeparator();
        this.linhaSeparador.setBounds(0, 90, 550, 10);
        this.linhaSeparador.setForeground(Color.BLACK);


        this.labelNomeCadastro = new JLabel("Titulo:");
        this.labelNomeCadastro.setFont(new Font("tahoma", Font.PLAIN, 22));
        this.labelNomeCadastro.setBounds(100, 120, 100, 30);

        this.jtNome = new JTextField();
        this.jtNome.setBounds(200, 120, 250, 30);

        //
        this.labelDesc = new JLabel("Descrição:");
        this.labelDesc.setFont(new Font("tahoma", Font.PLAIN, 21));
        this.labelDesc.setBounds(70, 170, 100, 30);


        this.labelData = new JLabel("Data:");
        this.labelData.setFont(new Font("tahoma", Font.PLAIN, 22));
        this.labelData.setBounds(100, 220, 100, 30);


        this.campoTexto = new JTextField();
        this.campoTexto.setBounds(200, 220, 200, 30); // Posiciona ao lado da label
        this.campoTexto.setFont(new Font("tahoma", Font.PLAIN, 20)); // Opcional: define a fonte do texto interno


        this.jtEmail = new JTextField();
        this.jtEmail.setBounds(200, 170, 250, 30);


        this.botaoCadastrar = new JButton("Cadastrar");
        this.botaoCadastrar.setBounds(230, 260, 130, 30);

    }

    private void adicionarComponentes() {
        add(labelTituloCadastrar);
        add(linhaSeparador);
        add(labelNomeCadastro);
        add(jtNome);
        add(labelDesc);
        add(jtEmail);
        add(labelData);
        add(campoTexto);
        add(botaoCadastrar);
    }

    private void configurarEventos() {
        jtNome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtEmail.requestFocus();
            }
        });


    }


}

