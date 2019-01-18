package be.vdab.proefpakket.restservices;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import be.vdab.proefpakket.entities.Gemeente;
import be.vdab.proefpakket.exceptions.GemeenteNietGevondenException;

@RestController
@RequestMapping("/gemeenten")
class GemeenteRestController {
	
	@GetMapping("{gemeente}")
	Gemeente read(@PathVariable Optional<Gemeente> gemeente) {
		if (gemeente.isPresent()) {
			return gemeente.get();
		}
		throw new GemeenteNietGevondenException();
	}
	@ExceptionHandler(GemeenteNietGevondenException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	void gemeenteNietGevonden() {
		
	}

}
