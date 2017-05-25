package com.HavanaClub.controller;

import com.HavanaClub.editors.CountryEditor;
import com.HavanaClub.editors.IngredientEditor;
import com.HavanaClub.entity.Country;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.service.CountryService;
import com.HavanaClub.service.DrinkService;
import com.HavanaClub.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
public class DrinkController {

    @Autowired
    private DrinkService drinkService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private IngredientService ingredientService;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.registerCustomEditor(Country.class, new CountryEditor());
        binder.registerCustomEditor(Ingredient.class, new IngredientEditor());
    }


    @GetMapping("/drink")
    public String drink(Model model) {
        model.addAttribute("drinks", drinkService.drinksWithIngredients());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("ingredients", ingredientService.findAll());
        model.addAttribute("drink", new Drink());
        return "drink";
    }

    @PostMapping("/drink")
    public String drink(@ModelAttribute Drink drink) {

        drinkService.save(drink);

        return "redirect:/drink";
    }

    @GetMapping("/deleteDrink/{id}")
    public String deleteDrink(@PathVariable int id) {

        drinkService.delete(id);

        return "redirect:/drink";

    }

    @GetMapping("/updateDrink/{id}")
    public String updateDrink(@PathVariable int id, Model model) {


        model.addAttribute("updateDrink", drinkService.drinksWithIngredients(id));

        return "updateDrink";
    }

    @GetMapping("/updateDrink/{drink_id}/{ingredient_id}")
    public String updateDrink(@PathVariable int drink_id,
                              @PathVariable int ingredient_id) {

        drinkService.updateDrink(drink_id, ingredient_id);

        return "redirect:/drink";

    }


}
