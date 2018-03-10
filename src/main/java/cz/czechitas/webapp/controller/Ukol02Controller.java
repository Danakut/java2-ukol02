package cz.czechitas.webapp.controller;

import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller

public class Ukol02Controller {

    private static final List<String> VYROKY = Arrays.asList(
            "Když jsem přijížděl domů, vjel jsem omylem do jiného dvora a naboural do stromu, protože ho doma na tomto místě nemám.",
            "To druhé auto do mne nabouralo bez jakéhokoliv předchozího varování.",
            "Myslel jsem, že mám stažené okénko. Zjistil jsem ale, že je zavřené, když jsem vystrčil ruku ven.",
            "Srazil jsem se se stojícím nákladním automobilem, když přijížděl z opačného směru.",
            "Ten dědula, kterého jsem porazil, by se na druhou stranu silnice stejně nedostal.",
            "Chodec do mne narazil a pak mi skočil pod auto.",
            "Ten chodec váhal, kterým směrem se má vydat, tak jsem ho přejel."
    );

    
    @RequestMapping("/index.html")
    public ModelAndView zobrazHod() {
        ModelAndView drzakNaDataAJmenoStranky;
        drzakNaDataAJmenoStranky = new ModelAndView("Ukol02-template");

        Random generatorNahodnychCisel = new Random();
        int cisloObrazku = generatorNahodnychCisel.nextInt(8);
        
        drzakNaDataAJmenoStranky.addObject("obrazek", cisloObrazku);
       
        return drzakNaDataAJmenoStranky;
    }
}
