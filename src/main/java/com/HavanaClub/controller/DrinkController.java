package com.HavanaClub.controller;

import com.HavanaClub.dto.DrinkDto;
import com.HavanaClub.dto.DtoUtilMapper;
import com.HavanaClub.editors.CountryEditor;
import com.HavanaClub.entity.Country;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.service.CountryService;
import com.HavanaClub.service.DrinkService;
import com.HavanaClub.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

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
    }

    @GetMapping("/drink")
    public String drink(Model model) {

        model.addAttribute("drinks", drinkService.drinkWithIngredientsParsed());
        model.addAttribute("countries", countryService.findAll());
        model.addAttribute("ingredients", ingredientService.findAll());
        model.addAttribute("drink", new Drink());

        return "views-admin-drink";
    }

    @PostMapping("/drink")
    public String drink(@ModelAttribute Drink drink,
                        @RequestParam ArrayList<Integer> ingredientsIds,
                        @RequestParam MultipartFile image) {

            drinkService.save(drink, ingredientsIds, image);

            return "redirect:/drink";
    }

    @GetMapping("/deleteDrink/{id}")
    public String deleteDrink(@PathVariable int id) {

        drinkService.delete(id);

        return "redirect:/drink";

    }

    @GetMapping("/updateDrink/{drink_id}")
    public String updateDrink(Model model,
                              @PathVariable int drink_id) {

        model.addAttribute("drink", drinkService.drinkWithIngredients(drink_id));



        return "views-admin-updateDrink";
    }

    /*update does't work for remove/add ingredient into/from drink*/
    @PostMapping("/updateDrink/{id}")
    public String updateDrink(@PathVariable int id,
                              @RequestParam String drinkName,
                              @RequestParam String recipe,
                              @RequestParam MultipartFile image,
                              @RequestParam ArrayList<Integer> ingredients){

        Drink drink = drinkService.drinkWithIngredients(id);
        drink.setDrinkName(drinkName);
        drink.setRecipe(recipe);

        drinkService.updateDrink(drink,image,ingredients);

        return "redirect:/drink";
    }

    @PostMapping("/searchDrink")
    public @ResponseBody List<DrinkDto> searchDrink(@RequestBody String search){
        return DtoUtilMapper.drinksToDrinksDtos(drinkService.searchDrinks(search));
    }

}
