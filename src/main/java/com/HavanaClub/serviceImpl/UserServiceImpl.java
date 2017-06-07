package com.HavanaClub.serviceImpl;

import com.HavanaClub.dao.DrinkDao;
import com.HavanaClub.dao.UserDao;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Ingredient;
import com.HavanaClub.entity.Role;
import com.HavanaClub.entity.User;
import com.HavanaClub.service.UserService;
import com.HavanaClub.validator.Validator;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService{

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
        validator.validate(user);
        user.setRole(Role.ROLE_USER);
        user.setPassword(encoder.encode(user.getPassword()));
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
        return userDao.findByNameOrEmail(name);
    }

    @Override
    public User findUserWithDrinks(int id) {
        User user = userDao.findUserWithDrinks(id);

        User returnedUser = new User();
        returnedUser.setId(user.getId());
        returnedUser.setName(user.getName());

        for (int i = 0; i < user.getDrinks().size(); i++) {
            returnedUser.getDrinks().add(new Drink(user.getDrinks().get(i).getId(), user.getDrinks().get(i).getDrinkName(), user.getDrinks().get(i).getRecipe()));
        }

        int counter = 0;
        for (Drink drink : user.getDrinks()) {
            returnedUser.getDrinks().get(counter).setIngredients(drinkDao.drinksWithIngredients(drink.getId()).getIngredients());
            counter++;
        }

        return returnedUser;
    }

    @Override
    public User findByName(String name) {
        return userDao.findByName(name);
    }
}

