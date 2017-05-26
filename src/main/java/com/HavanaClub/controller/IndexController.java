package com.HavanaClub.controller;

import com.HavanaClub.dto.DtoUtilMapper;
import com.HavanaClub.dto.UserDto;
import com.HavanaClub.entity.User;
import com.HavanaClub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
//        List<User> users = userService.findAll();
//
//        List<UserDto>  userDtos = new ArrayList<>();
//
//        for (User user : users) {
//
//            UserDto userDto = new UserDto();
//            userDto.setName(user.getName());
//            userDto.setEmail(user.getEmail());
//
//            userDtos.add(DtoUtilMapper.userToUserDto(user));
//
//        }

        model.addAttribute("userDtos", DtoUtilMapper.usersToUsersDtos(userService.findAll()));

        return "index";
    }


}
