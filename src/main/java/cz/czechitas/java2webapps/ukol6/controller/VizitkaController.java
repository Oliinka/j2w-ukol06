package cz.czechitas.java2webapps.ukol6.controller;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.service.VizitkaService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final VizitkaService service;

    public VizitkaController(VizitkaService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView result = new ModelAndView("seznam");
        result.addObject("seznam", service.getAll());
        return result;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView result = new ModelAndView("detail");
        result.addObject("vizitka", service.getById(id));
        result.addObject("index", id);
        return result;
    }
    @GetMapping("/nova")
    public ModelAndView nova() {
        return new ModelAndView("nova");
    }
    @PostMapping("/nova")
    public String createVizitka(Vizitka vizitka) { service.append(vizitka); return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        service.deleteById(id);
        return "redirect:/";
    }

}