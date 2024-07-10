package controller;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class GmailSender implements Runnable {
    private static final String EMAIL_FROM = "ApProjectTest@gmail.com";
    private static String EMAIL_TO;
    private static final String APP_PASSWORD = "fjwadaklzmfhbuxf";
    private static int code;

    public GmailSender(String EMAIL_TO, int code) {
        GmailSender.EMAIL_TO = EMAIL_TO;
        GmailSender.code = code;
    }

    private static Session getEmailSession() {
        return Session.getInstance(getGmailProperties(), new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_FROM, APP_PASSWORD);
            }
        });
    }

    private static Properties getGmailProperties() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        return prop;
    }

    @Override
    public void run() {
        try {
            Message message = new MimeMessage(getEmailSession());
            message.setFrom(new InternetAddress(EMAIL_FROM));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(EMAIL_TO));
            message.setSubject("2FA Authentication Code");
            message.setText("Welcome ,Your code is : " + code);
            Transport.send(message);
            System.out.println("email sent successfully");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
