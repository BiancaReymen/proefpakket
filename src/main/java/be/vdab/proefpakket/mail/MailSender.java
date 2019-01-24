package be.vdab.proefpakket.mail;

import be.vdab.proefpakket.entities.Bestelling;

public interface MailSender {
	
	void proefpakket(String emailadres, String brouwerNaam);

}
