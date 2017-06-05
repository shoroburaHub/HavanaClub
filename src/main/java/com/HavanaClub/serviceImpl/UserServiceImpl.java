package com.HavanaClub.serviceImpl;

import com.HavanaClub.dao.DrinkDao;
import com.HavanaClub.dao.UserDao;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Role;
import com.HavanaClub.entity.User;
import com.HavanaClub.service.UserService;
import com.HavanaClub.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private DrinkDao drinkDao;
    @Autowired
    @Qualifier("userValidator")
    private Validator validator;
    @Autowired
    private BCryptPasswordEncoder encoder;

    public void save(User user) throws Exception {
        user.setRole(Role.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
        validator.validate(user);
        userDao.save(user);
    }

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User findOne(int id) {
        return userDao.findOne(id);
    }

    public void delete(int id) {
        userDao.delete(id);
    }

    public void update(User user) {
        userDao.save(user);
    }

    public User findUserWithOrders(int id) {
        return userDao.findUserWithOrders(id);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        return userDao.findByName(name);
    }

    @Override
    public void like(Principal principal, int drinkId) {

        User user = userDao.findUserWithDrinks(Integer.parseInt(principal.getName()));

        Drink drink = drinkDao.findOne(drinkId);


        user.getDrinks().add(drink);

        userDao.save(user);

    }

    @Override
    public User findUserWithDrinks(int id) {
        return userDao.findUserWithDrinks(id);
    }
}
