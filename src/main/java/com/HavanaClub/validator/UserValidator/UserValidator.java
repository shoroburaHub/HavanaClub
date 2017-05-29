package com.HavanaClub.validator.UserValidator;

import com.HavanaClub.dao.UserDao;
import com.HavanaClub.entity.User;
import com.HavanaClub.service.UserService;
import com.HavanaClub.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by admin on 5/29/2017.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public void validate(Object o) throws Exception {

        User user = (User) o;

        if(user.getName().isEmpty()){
            throw new UserException(UserValidatorMessages.EMPTY_USERNAME_FIELD);
        }else if(userService.findByName(user.getName()) != null){
            throw new UserException(UserValidatorMessages.USERNAME_ALREADY_EXIST);
        }

    }
}
