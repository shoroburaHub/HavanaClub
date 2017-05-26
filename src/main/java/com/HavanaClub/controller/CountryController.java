package com.HavanaClub.controller;

import com.HavanaClub.entity.Country;
import com.HavanaClub.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/country")
    public String country(Model model) {
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("country", new Country());
        return "country";
    }

    @PostMapping("/country")
    public String country(@ModelAttribute Country country) {

        countryService.save(country);

        return "redirect:/country";
    }

    @GetMapping("/deleteCountry/{id}")
    public String delete(@PathVariable int id) {

        countryService.delete(id);

        return "redirect:/country";
    }

}
