package com.HavanaClub.controller;

import com.HavanaClub.dto.DrinkDto;
import com.HavanaClub.dto.DtoUtilMapper;
import com.HavanaClub.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by admin on 6/24/2017.
 */
@Controller
public class FilterController {

    @Autowired
    private DrinkService drinkService;

    @PostMapping("/filterAlcohol")
    public @ResponseBody
    List<DrinkDto> filterAlcohol(@RequestBody String alcoValue){

//        System.out.println("alcoValue = " + alcoValue);
//
//        if(alcoValue.equals("alco")){
//            System.out.println("alco");
//        }else if(alcoValue.equals("notAlco")){
//            System.out.println("notAlco");
//        }

        return DtoUtilMapper.drinksToDrinksDtos(drinkService.filterByAlcohol(alcoValue));
    }

}
