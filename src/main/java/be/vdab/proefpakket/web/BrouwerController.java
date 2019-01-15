package be.vdab.proefpakket.web;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import be.vdab.proefpakket.entities.Brouwer;
import be.vdab.proefpakket.services.BrouwerService;

@Component
@RequestMapping("brouwers")
public class BrouwerController {
	
	private final BrouwerService brouwerService;
	
	private static final String VIEW = "brouwers/brouwer";
	private static final String REDIRECT_BIJ_BROUWER_NIET_GEVONDEN = "redirect:/";
	
	BrouwerController(BrouwerService brouwerService) {
		this.brouwerService = brouwerService;
	}
	
	@GetMapping("{brouwer}")
	ModelAndView read(@PathVariable Optional<Brouwer> brouwer, RedirectAttributes redirectAttributes) {
		if (brouwer.isPresent()) {
			System.out.println("er is een brouwer gevonden");
			return new ModelAndView(VIEW)
					.addObject(brouwer.get());
		}
		redirectAttributes.addAttribute("fout", "Brouwer niet gevonden");
		return new ModelAndView(REDIRECT_BIJ_BROUWER_NIET_GEVONDEN);
	}
	
	private static final String ONDERNEMINGSNR_VIEW = "brouwers/ondernemingsnr";
	private static final String REDIRECT_NA_ONDERNEMINGSNR = "redirect:/brouwers/{id}";
	
	@GetMapping("{brouwer}/ondernemingsnr")
	ModelAndView ondernemingsNr(@PathVariable Optional<Brouwer> brouwer, RedirectAttributes redirectAttributes) {
		System.out.println("Bianca in controller");
		if (brouwer.isPresent()) {
			OndernemingsNrForm form = new OndernemingsNrForm();
			form.setOndernemingsNr(brouwer.get().getOndernemingsNr());
			return new ModelAndView (ONDERNEMINGSNR_VIEW)
					.addObject(brouwer.get())
					.addObject(form);
			
		}
		redirectAttributes.addAttribute("fout", "Brouwer niet gevonden");
		return new ModelAndView(REDIRECT_BIJ_BROUWER_NIET_GEVONDEN);
	}
	@PostMapping("{brouwer}/ondernemingsnr")
	ModelAndView ondernemingsNr(@PathVariable Optional<Brouwer> brouwer, @Valid OndernemingsNrForm form,
								BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (brouwer.isPresent()) {
			if (bindingResult.hasErrors()) {
				return new ModelAndView (ONDERNEMINGSNR_VIEW).addObject(brouwer.get());
			}
			brouwer.get().setOndernemingsNr(form.getOndernemingsNr());
			brouwerService.update(brouwer.get());
			redirectAttributes.addAttribute("id", brouwer.get().getId());
			return new ModelAndView(REDIRECT_NA_ONDERNEMINGSNR);	
		}
		redirectAttributes.addAttribute("fout", "Brouwer niet gevonden");
		return new ModelAndView(REDIRECT_BIJ_BROUWER_NIET_GEVONDEN);
	}
}	
