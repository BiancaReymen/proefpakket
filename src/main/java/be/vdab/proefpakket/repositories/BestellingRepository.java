package be.vdab.proefpakket.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import be.vdab.proefpakket.entities.Bestelling;

public interface BestellingRepository extends JpaRepository <Bestelling, Long>{

}
