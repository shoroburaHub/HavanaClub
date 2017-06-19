package com.HavanaClub.controller;

import com.HavanaClub.entity.City;
import com.HavanaClub.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 6/19/2017.
 */
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/city")
    public String city() {
        return "views-admin-city";
    }

    @PostMapping("/saveCity")
    public @ResponseBody List<City> saveCity(@RequestBody City city) {

        cityService.save(city);

        return cityService.findAll();
    }

    @GetMapping("/loadCities")
    public @ResponseBody List<City> loadCities(){
        return cityService.findAll();
    }

    @DeleteMapping("/deleteCity")
    public @ResponseBody List<City> deleteCity(@RequestBody String idCity){

        cityService.delete(Integer.valueOf(idCity));

        return cityService.findAll();
    }

}
