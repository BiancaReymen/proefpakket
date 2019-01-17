package be.vdab.proefpakket.valueobjects;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.SafeHtml;

import be.vdab.proefpakket.entities.Bestelling;
import be.vdab.proefpakket.entities.Gemeente;

@Embeddable
public class Adres implements Serializable {
	private final static long serialVersionUID = 1L;
	
	@NotBlank(groups = Bestelling.Stap2.class)
	@SafeHtml(groups = Bestelling.Stap2.class)
	private String straat;
	@NotBlank(groups = Bestelling.Stap2.class)
	@SafeHtml(groups = Bestelling.Stap2.class)
	private String huisNr;
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "gemeenteid")
	@NotNull(groups = Bestelling.Stap2.class)
	private Gemeente gemeente;
	
	
	public void setStraat(String straat) {
		this.straat = straat;
	}
	public void setHuisNr(String huisNr) {
		this.huisNr = huisNr;
	}
	public void setGemeente(Gemeente gemeente) {
		this.gemeente = gemeente;
	}
	public String getStraat() {
		return straat;
	}
	public String getHuisNr() {
		return huisNr;
	}
	public Gemeente getGemeente() {
		return gemeente;
	}
	
	

}
