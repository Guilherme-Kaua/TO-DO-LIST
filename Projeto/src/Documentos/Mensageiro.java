package Documentos;

import CRUD.ManipuladorDeTarefas;
import jakarta.mail.Session;

import jakarta.mail.Message;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

import java.time.LocalDate;
import java.util.Properties;
import java.io.File;


public class Mensageiro {
    public void enviarEmailComPdf(String email, LocalDate data, ManipuladorDeTarefas tarefas) throws Exception {
        // Configuração do servidor SMTP
        String host = "smtp.gmail.com";
        final String username = "testedeemailspdfs@gmail.com"; //email que manda o relatório
        final String password = "pccrajhfqiqepefp"; // Use uma senha de app

        // Destinatário
        String to = email;
        System.out.println("Enviando para: " + to);

        // Configuração das propriedades
        Properties props = new Properties();
        props.put("mail.smtp.ssl.trust", "*");
        props.put("mail.smtp.ssl.protocols", "TLSv1.2");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");


        // Cria a sessão
        Session session = Session.getInstance(props,
                new jakarta.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                }
        );

        try {
            // 📝 Gera o PDF com base na data e tarefas
            GeradorDePdf.obterTarefasDeUmDia(data, tarefas);

            // Cria a mensagem
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Relatório de tarefas - " + data);

            // Parte do texto
            MimeBodyPart textoParte = new MimeBodyPart();
            textoParte.setText("Olá! Segue em anexo o relatório das tarefas do dia " + data + ".");

            // Parte do anexo
            MimeBodyPart anexoParte = new MimeBodyPart();
            anexoParte.attachFile(new File("Relatorio.pdf")); // PDF gerado pela sua classe

            // Junta tudo
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(textoParte);
            multipart.addBodyPart(anexoParte);

            message.setContent(multipart);

            // Envia o e-mail
            Transport.send(message);

        } catch (Exception e) {
            throw new Exception("Falha ao enviar e-mail:");
        }
    }
}
