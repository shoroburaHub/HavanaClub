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
@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/city")
    public List<City> saveCity(@RequestBody City city) {

        cityService.save(city);

        return cityService.findAll();
    }

    @GetMapping("/city")
    public List<City> loadCities(){
        return cityService.findAll();
    }

    @DeleteMapping("/city")
    public List<City> deleteCity(@RequestBody String idCity){

        cityService.delete(Integer.valueOf(idCity));

        return cityService.findAll();
    }

}
