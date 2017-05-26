package com.HavanaClub.dto;

import com.HavanaClub.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 5/26/2017.
 */
public class DtoUtilMapper {

    public static UserDto userToUserDto(User user){

        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

    public static List<UserDto> usersToUsersDtos(List<User> users){

        List<UserDto> usersDtos = new ArrayList<>();

        for (User user : users) {

            usersDtos.add(userToUserDto(user));

        }

        return usersDtos;

    }


}
