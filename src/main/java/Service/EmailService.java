package Service;

public interface EmailService {
    void sendHtmlContent(String toEmail, String subject, String htmlBody);
}
