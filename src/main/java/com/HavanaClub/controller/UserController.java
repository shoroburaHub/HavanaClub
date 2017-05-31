package com.HavanaClub.controller;

import com.HavanaClub.entity.User;
import com.HavanaClub.service.UserService;
import com.HavanaClub.validator.user.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

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
            }else if(e.getMessage().equals(UserValidationMessages.EMPTY_PASSWORD_FIELD)||
                    e.getMessage().equals(UserValidationMessages.TOO_SHORT_PASSWORD)){
                model.addAttribute("passwordException", e.getMessage());
            }
            return "views-user-signUp";
        }
        return "redirect:/";
    }

}
