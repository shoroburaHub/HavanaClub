package com.HavanaClub.controller;

import com.HavanaClub.entity.User;
import com.HavanaClub.service.MailSenderService;
import com.HavanaClub.service.UserService;
import com.HavanaClub.validator.Validator;
import com.HavanaClub.validator.user.UserValidationMessages;
import com.HavanaClub.validator.userLoginValidation.UserLoginValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    @Qualifier("userLoginValidator")
    private Validator validator;

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("user", new User());
        return "views-user-signUp";
    }

    @PostMapping("/signUp")
    public String signUp(@ModelAttribute("user") User user, Model model) {


        String uuid = UUID.randomUUID().toString();

        user.setUuid(uuid);

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

            return "views-user-signUp";
        }

        String theme = "thank's for registration";
        String mailBody =
                "gl & hf       http://localhost:8080/confirm/" + uuid;

        mailSenderService.sendMail(theme, mailBody, user.getEmail());

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

    @GetMapping("/history")
    public String history(Principal principal, Model model){

        model.addAttribute("user", userService.findUserWithOrders(Integer.parseInt(principal.getName())));

        return "views-user-history";
    }


    @GetMapping("/confirm/{uuid}")
    public String confirm(@PathVariable String uuid) {

        User user = userService.findByUuid(uuid);
        user.setEnable(true);

        userService.update(user);

        return "redirect:/";
    }

}
