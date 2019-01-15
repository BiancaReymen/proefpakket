package be.vdab.proefpakket.services;

import java.util.List;

import be.vdab.proefpakket.entities.Brouwer;

public interface BrouwerService {
	List<Brouwer> findByNaamStartingWithOrderByNaam(String beginNaam);
}
