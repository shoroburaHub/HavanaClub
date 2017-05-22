package com.HavanaClub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by admin on 5/22/2017.
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/signUp")
    public String signUp(){
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@RequestParam String name,
                         @RequestParam String email,
                         @RequestParam String password){

        System.out.println("name "+name);
        System.out.println("email "+email);
        System.out.println("password "+password);


        return "redirect:/";
    }
}
