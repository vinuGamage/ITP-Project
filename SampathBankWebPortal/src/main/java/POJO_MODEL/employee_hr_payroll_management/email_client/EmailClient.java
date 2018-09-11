package POJO_MODEL.employee_hr_payroll_management.email_client;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailClient {
	public static void sendMail(String receiver, String user, String pass) {
		   final String username = "itpCompanySampath@gmail.com";
		    final String password = "itp2018g310";

			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");

			Session session = Session.getInstance(props,
			  new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			  });

			try {

				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username)); // same email id
				message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receiver));// whome u have to send mails that person id
				message.setSubject("Login Credentials for Your Online Account.");
				message.setText("Username : " + user + "\n" + "Password : " + pass);

				Transport.send(message);

				System.out.println("Done");

			} catch (MessagingException e) {
				throw new RuntimeException(e);
			}
	}
}