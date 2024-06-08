package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;

import jakarta.validation.Valid;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {

    private final VizitkaRepository vizitkaRepository;

    public VizitkaController(VizitkaRepository vizitkaRepository) {
        this.vizitkaRepository = vizitkaRepository;
    }

    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        // prázdné textové řetězce nahradit null hodnotou
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznam")
                .addObject("vizitka", vizitkaRepository.findAll());
    }

    @GetMapping("/nova")
    public ModelAndView nova() {
        return new ModelAndView("formular")
                .addObject("vizitka", new Vizitka());
    }

    @PostMapping("/nova")
    public String pridat(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        vizitkaRepository.save(vizitka);
        return "redirect:/";}


    @GetMapping("/vizitka/{id}")
    public ModelAndView detail(@PathVariable long id) {
        Optional<Vizitka> vizitka = vizitkaRepository.findById(id);
        if (vizitka.isEmpty()) {
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("vizitka")
                .addObject("vizitka", vizitka.get());
    }

    @PostMapping("/{id}")
    public String ulozit(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formular";
        }
        vizitkaRepository.save(vizitka);
        return "redirect:/";
    }
    @PostMapping(value = "/{id}", params = "akce=smazat")
    public String smazat(@PathVariable long id) {
        vizitkaRepository.deleteById(id);
        return "redirect:/";
    }
}
