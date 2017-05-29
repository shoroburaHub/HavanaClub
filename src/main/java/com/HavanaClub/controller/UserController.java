package com.HavanaClub.controller;

import com.HavanaClub.entity.User;
import com.HavanaClub.service.UserService;
import com.HavanaClub.validator.UserValidator.UserValidatorMessages;
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
        return "signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute User user, Model model) {

        try {
            userService.save(user);
        } catch (Exception e) {

            if (e.getMessage().equals(UserValidatorMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserValidatorMessages.USERNAME_ALREADY_EXIST)) {

                model.addAttribute("usernameException", e.getMessage());

            }

            return "signUp";

        }

        return "redirect:/";
    }

}
