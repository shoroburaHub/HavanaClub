package com.HavanaClub.controller;

import com.HavanaClub.entity.Country;
import com.HavanaClub.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public String country(Model model) {
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("country", new Country());
        return "views-admin-country";
    }

    @PostMapping("/country")
    public String country(@ModelAttribute Country country, Model model) {



        countryService.save(country);


        return "redirect:/country";
    }

    @GetMapping("/deleteCountry/{id}")
    public String delete(@PathVariable int id) {

        countryService.delete(id);

        return "redirect:/country";
    }

}
