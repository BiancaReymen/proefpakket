package be.vdab.proefpakket.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.proefpakket.entities.Brouwer;

public interface BrouwerRepository extends JpaRepository<Brouwer, Long>{
	List<Brouwer> findByNaamStartingWithOrderByNaam(String beginNaam);

}
