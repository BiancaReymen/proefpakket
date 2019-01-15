package be.vdab.proefpakket.web;

import javax.validation.constraints.NotNull;

import be.vdab.proefpakket.constraints.OndernemingsNr;

public class OndernemingsNrForm {

	@NotNull
	@OndernemingsNr
	private Long ondernemingsNr;

	public Long getOndernemingsNr() {
		return ondernemingsNr;
	}

	public void setOndernemingsNr(Long ondernemingsNr) {
		this.ondernemingsNr = ondernemingsNr;
	}
	
	
	
}
