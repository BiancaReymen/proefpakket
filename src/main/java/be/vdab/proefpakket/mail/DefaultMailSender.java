package be.vdab.proefpakket.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import be.vdab.proefpakket.exceptions.KanMailNietZendenException;

@Component
public class DefaultMailSender implements MailSender {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DefaultMailSender.class);
	private final JavaMailSender sender;
	
	DefaultMailSender(JavaMailSender sender) {
		this.sender = sender;
		
	}
	@Override
	public void proefpakket(String emailadres, String brouwerNaam) {
		try {
			//zonder HTML opmaak
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emailadres);
			message.setSubject("Proefpakket " + brouwerNaam);
			message.setText("Bedankt voor uw interesse. U ontvangt uw proefpakket van " + brouwerNaam + " binnenkort.");
			sender.send(message);
		}catch (MailException ex) {
			LOGGER.error("Kan mail nieuwe bestelling niet versturen", ex);
			throw new KanMailNietZendenException();
			
		}
	}

}
