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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {

    private final VizitkaRepository vizitkaRepository;
    public VizitkaController(VizitkaRepository vizitkaRepository){
        this.vizitkaRepository= vizitkaRepository;
    }


    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        //prázdné textové řetězce nahradit null hodnotou
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    //opraveno
    @GetMapping("/")
    public ModelAndView seznam() {
    //TODO načíst seznam osob
        return new ModelAndView("seznam")
                .addObject("vizitky", vizitkaRepository.findAll());
}


    @GetMapping("/nova")
    public ModelAndView nova() {
        return new ModelAndView("detail")
                .addObject("vizitka", new Vizitka());
    }

    @PostMapping("/nova")
    public String pridat(@ModelAttribute("vizitka") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "detail";
        }
        //uložit údaj o nové osobě
        vizitkaRepository.save(vizitka);
        return "redirect:/";
    }

    @GetMapping("/{id:[0-9]+}")
    public ModelAndView detail(@PathVariable long id) {
        //TODO načíst údaj o osobě
        Optional<Vizitka> osoba=vizitkaRepository.findById(id);
        if(osoba.isEmpty()){
            return new ModelAndView("redirect:/");
        }
        return new ModelAndView("detail")
                .addObject("osoba", osoba.get());
    }

    @PostMapping("/{id:[0-9]+}")
    public String ulozit(@ModelAttribute("osoba") @Valid Vizitka vizitka, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "detail";
        }
        //TODO uložit údaj o osobě
        vizitkaRepository.save(vizitka);
        return "redirect:/";
    }

    @PostMapping(value = "/{id:[0-9]+}", params = "akce=smazat")
    public String smazat(@PathVariable long id) {
        //TODO smazat údaj o osobě
        vizitkaRepository.deleteById(id);
        return "redirect:/";
    }

}


/* package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class VizitkaController {
    private final VizitkaRepository vizitkaRepository;


    @Autowired
    public VizitkaController (VizitkaRepository vizitkaRepository){
        this.vizitkaRepository = vizitkaRepository;
    }
    @InitBinder
    public void nullStringBinding(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        return new ModelAndView("seznam")
                .addObject("vizitka", vizitkaRepository.findAll());
    }

    @GetMapping("/{id}")
    public Object vizitka(@PathVariable int id) {
        Optional<Vizitka> optionalVizitka = vizitkaRepository.findById(id);
        if (optionalVizitka.isPresent()){
            return new ModelAndView("vizitka")
                    .addObject("vizitka", optionalVizitka.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
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

}
*/

