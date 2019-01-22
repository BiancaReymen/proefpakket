package be.vdab.proefpakket.services;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import be.vdab.proefpakket.restclients.WeerClient;

@Service
public class DefaultWeerService implements WeerService {
	
	private final WeerClient weerClient;
	
	DefaultWeerService (WeerClient weerClient) {
		this.weerClient = weerClient;
	}
	
	
	@Override
	public BigDecimal getTemperatuur(String plaats) {
		return weerClient.getTemperatuur(plaats);
		
	}

}
