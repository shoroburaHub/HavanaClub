package com.HavanaClub.controller;

import com.HavanaClub.entity.User;
import com.HavanaClub.service.UserService;
import com.HavanaClub.validator.Validator;
import com.HavanaClub.validator.user.UserValidationMessages;
import com.HavanaClub.validator.userLoginValidation.UserLoginValidationMessages;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    @Qualifier("userLoginValidator")
    private Validator validator;

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "views-user-signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute User user, Model model) {

        try {
            userService.save(user);
        } catch (Exception e) {
            if(e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.USERNAME_ALREADY_EXIST)){
                model.addAttribute("usernameException", e.getMessage());
            }else if(e.getMessage().equals(UserValidationMessages.EMPTY_EMAIL_FIELD)||
                    e.getMessage().equals(UserValidationMessages.EMAIL_ALREADY_EXIST)||
                    e.getMessage().equals(UserValidationMessages.WRONG_EMAIL)){
                model.addAttribute("emailException", e.getMessage());
            }else if(e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)){
                model.addAttribute("passwordException", e.getMessage());
            }

            System.out.println("user = " + user);
            return "views-user-signUp";
        }
        return "redirect:/";
    }


    @GetMapping("/profile")
    public String profile(Principal principal, Model model){

        model.addAttribute("userBasket", userService.findUserWithDrinks(Integer.parseInt(principal.getName())));
        return "views-user-profile";
    }

    @PostMapping("/failureLogin")
    public String failureLogin(Model model, @RequestParam String username,
                               @RequestParam String password){

        try {
            validator.validate(new User(username,password));
        } catch (Exception e) {
            if(e.getMessage().equals(UserLoginValidationMessages.EMPTY_USERNAME_FIELD)||
                    e.getMessage().equals(UserLoginValidationMessages.EMPTY_PASSWORD_FIELD)||
                    e.getMessage().equals(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD)){
                model.addAttribute("exception", e.getMessage());
            }
        }
        model.addAttribute("user", new User());

        return "views-user-signUp";
    }

}
