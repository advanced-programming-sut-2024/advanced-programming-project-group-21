package controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GmailSenderTest {

    private GmailSender gmailSender;
    private final String emailTo = "test@example.com";
    private final int code = 123456;

    @BeforeEach
    public void setUp() {
        gmailSender = new GmailSender(emailTo, code);
    }

    @Test
    public void testRun() throws AddressException {
        try (MockedStatic<GmailSender> mockedGmailSender = mockStatic(GmailSender.class)) {
            Session mockSession = mock(Session.class);
            MimeMessage mockMessage = mock(MimeMessage.class);

            mockedGmailSender.when(GmailSender::getEmailSession).thenReturn(mockSession);
            mockedGmailSender.when(() -> new MimeMessage(mockSession)).thenReturn(mockMessage);

            assertDoesNotThrow(() -> gmailSender.run());

            verify(mockMessage).setFrom(new InternetAddress("ApProjectTest@gmail.com"));
            verify(mockMessage).setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTo));
            verify(mockMessage).setSubject("2FA Authentication Code");
            verify(mockMessage).setText("Welcome ,Your code is : " + code);
            verify(mockMessage).saveChanges();
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testRun_ExceptionHandling() throws MessagingException {
        try (MockedStatic<GmailSender> mockedGmailSender = mockStatic(GmailSender.class)) {
            Session mockSession = mock(Session.class);
            MimeMessage mockMessage = mock(MimeMessage.class);

            mockedGmailSender.when(GmailSender::getEmailSession).thenReturn(mockSession);
            mockedGmailSender.when(() -> new MimeMessage(mockSession)).thenReturn(mockMessage);
            doThrow(new MessagingException("Test Exception")).when(mockMessage).saveChanges();

            assertDoesNotThrow(() -> gmailSender.run());
        }
    }

    @Test
    public void testGetEmailSession() {
        try (MockedStatic<GmailSender> mockedGmailSender = mockStatic(GmailSender.class)) {
            Properties mockProperties = mock(Properties.class);
            mockedGmailSender.when(GmailSender::getGmailProperties).thenReturn(mockProperties);

            Authenticator mockAuthenticator = mock(Authenticator.class);
            mockedGmailSender.when(() -> new Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("ApProjectTest@gmail.com", "fjwadaklzmfhbuxf");
                }
            }).thenReturn(mockAuthenticator);

            Session session = GmailSender.getEmailSession();
            assertNotNull(session);
        }
    }

    @Test
    public void testGetGmailProperties() {
        Properties properties = GmailSender.getGmailProperties();
        assertNotNull(properties);
        Assertions.assertEquals("true", properties.getProperty("mail.smtp.auth"));
        Assertions.assertEquals("true", properties.getProperty("mail.smtp.starttls.enable"));
        Assertions.assertEquals("smtp.gmail.com", properties.getProperty("mail.smtp.host"));
        Assertions.assertEquals("587", properties.getProperty("mail.smtp.port"));
        Assertions.assertEquals("smtp.gmail.com", properties.getProperty("mail.smtp.ssl.trust"));
    }
}
