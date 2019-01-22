package be.vdab.proefpakket.restclients;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import be.vdab.proefpakket.exceptions.KanTemperatuurNietLezenException;

@Component
class OpenWeatherMapClient implements WeerClient {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OpenWeatherMapClient.class);
	private final String uriTemplate;
	private final RestTemplate restTemplate;
	
	OpenWeatherMapClient(@Value("${OpenWeatherMapURL}") String uriTemplate, RestTemplateBuilder restTemplateBuilder) {
		this.uriTemplate = uriTemplate;
		this.restTemplate = restTemplateBuilder.build();
	}
	
	@Override
	public BigDecimal getTemperatuur(String plaats) {
		try {
			return restTemplate.getForObject(uriTemplate, Weer.class, plaats).getMain().getTemp();
		} catch (Exception ex) {
			LOGGER.error("kan temperatuur niet lezen", ex);
			throw new KanTemperatuurNietLezenException();
		}
	}

	
}
