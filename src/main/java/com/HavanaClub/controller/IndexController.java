package com.HavanaClub.controller;

import com.HavanaClub.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {
    @Autowired
    private DrinkService drinkService;


    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("drinks", drinkService.drinkWithIngredients());
        return "views-base-index";
    }

    @PostMapping("/")
    public String indexAfterLogin(Model model) {
        model.addAttribute("drinks", drinkService.drinkWithIngredients());
        return "views-base-index";
    }

}
