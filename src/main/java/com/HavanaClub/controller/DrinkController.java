package com.HavanaClub.controller;

import com.HavanaClub.dto.*;
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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

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
        binder.registerCustomEditor(CountryDto.class, new CountryEditor());
        binder.registerCustomEditor(IngredientDto.class, new IngredientEditor());
    }


    @GetMapping("/drink")
    public String drink(Model model) {

//        List<Drink> drinks = drinkService.findAll();

//        List<DrinkDto> drinkDtos = new ArrayList<>();
//
//        for (Drink drink : drinks) {
//
////            DrinkDto drinkDto = new DrinkDto();
////            drinkDto.setId(drink.getId());
////            drinkDto.setName(drink.getName());
//
//            drinkDtos.add(DtoUtilMapper.drinkToDrinkDto(drink));
//
//        }

        model.addAttribute("drinksDtos", DtoUtilMapper.drinksToDrinksDtos(drinkService.findAll()));
        model.addAttribute("countriesDtos", DtoUtilMapper.countriesToCountriesDtos(countryService.findAll()));
        model.addAttribute("ingredientsDtos", DtoUtilMapper.ingredientsToingredientsDtos(ingredientService.findAll()));
        model.addAttribute("drinkDtoCreate", new DrinkDtoCreate());

        return "drink";
    }

    @PostMapping("/drink")
    public String drink(@ModelAttribute DrinkDtoCreate drinkDtoCreate, BindingResult result) {

        if(result.hasErrors()){
            return "drink";
        }


//        System.out.println(drinkDtoCreate);

        drinkService.save(drinkDtoCreate);

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
