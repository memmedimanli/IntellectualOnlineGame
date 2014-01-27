package net.iog.domain;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author memmedimanli
 */
public class RegisterEmail {

    public void sendRegistrationEmail(RegistrationForm register) {
        
        final String password = "7*M@i*7m";
        String from = "memmedimanli@gmail.com";
        String host = "smtp.gmail.com";
        
        Properties properties = new Properties();
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.user", from);
        properties.put("mail.smtp.password", password);
        properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(register.getEmail()));
            message.setSubject("Thank you " + register.getName().toUpperCase()
                    + " " + register.getSurname().toUpperCase() + " for Registration");
            message.setContent("Thank you " + register.getName() + " for Registration, "
                    + "Following are the details of your account,"
                    + "<br/>*************************************** "
                    + "<br/>Username : <b>" + register.getUsername() + "</b>"
                    + "<br/>Password : <b>" + register.getPassword() + "</b>"
                    + "<br/>Name : <b>" + register.getName() + " " + register.getSurname() + "</b>"
                    + "<br/>Click the link to activate your account : "
                    + "<a href='http://localhost:8080/IntellectualOnlineGame/confirm?username=" + register.getUsername()
                    + "&email=" + register.getEmail() + "'>Activate Account</a>"
                    + "<br/>*************************************** ", "text/html");
            
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, password);
            transport.sendMessage(message, message.getAllRecipients());
            
            transport.close();

            

            System.out.println("Email Send Successfully");



        } catch (MessagingException e) {
            System.out.println("Error while sending the Mail");
            throw new RuntimeException(e);
        }
    }
}
