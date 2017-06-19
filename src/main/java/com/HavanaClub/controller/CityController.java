package com.HavanaClub.controller;

import com.HavanaClub.entity.City;
import com.HavanaClub.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by admin on 6/19/2017.
 */
@RestController("/city")
public class CityController {

    @GetMapping
    public int loadCities(){
        return 200;
    }


}
