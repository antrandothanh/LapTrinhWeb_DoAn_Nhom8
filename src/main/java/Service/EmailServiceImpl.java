package Service;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;


public class EmailServiceImpl implements EmailService {
    private static final String FROM = "hunggsamm@gmail.com";
    private static final String PASS = "rdrefbgglnvojtmw";

    @Override
    public void sendHtmlContent(String toEmail, String subject, String htmlBody) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");             //cổng kết nối an toàn
        props.put("mail.smtp.auth", "true");            //xác thực email trước khi gửi
        props.put("mail.smtp.starttls.enable", "true"); //thiết lập kết nối bảo mật

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(FROM, PASS);
            }
        });

        try {
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(FROM));
            emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            emailMessage.setSubject(subject);

            MimeBodyPart mimeBodyPart = new MimeBodyPart();
            // Create MimeBodyPart with UTF-8 encoding
            mimeBodyPart.setContent(htmlBody, "text/html; charset=UTF-8");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(mimeBodyPart);
            emailMessage.setContent(multipart);

            Transport transport = session.getTransport();
            transport.connect();
            transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        EmailService emailService = new EmailServiceImpl();
        emailService.sendHtmlContent("21110194@student.hcmute.edu.vn","hihi","ok");
    }
}

