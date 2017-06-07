package com.HavanaClub.serviceImpl;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HavanaClub.dao.DrinkDao;
import com.HavanaClub.dao.OrdersDao;
import com.HavanaClub.dao.UserDao;
import com.HavanaClub.entity.Drink;
import com.HavanaClub.entity.Orders;
import com.HavanaClub.entity.User;
import com.HavanaClub.service.OrdersService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private DrinkDao drinkDao;
	@Autowired
	private UserDao userDao;

	public List<Orders> findAll() {
		return ordersDao.findAll();
	}

	public Orders findOne(int id) {
		return ordersDao.findOne(id);
	}

	public void delete(int id) {
		ordersDao.delete(id);
	}

	public void update(Orders orders) {
		ordersDao.save(orders);
	}


	@Override
	public void addIntoBasket(Principal principal, int id) {

		User user = userDao.findUserWithDrinks(Integer.parseInt(principal.getName()));

		Drink drink = drinkDao.findOne(id);

		user.getDrinks().add(drink);

		userDao.save(user);

	}

	@Override
	@Transactional
	public void deleteFromBasket(int userId, int drinkId) {

		User user = userDao.findUserWithDrinks(userId);

		Drink drink = drinkDao.drinksWithUsers(drinkId);

		user.getDrinks().remove(drink);

		userDao.save(user);

	}

	@Override
	@Transactional
	public void buy(int userId) {

		Orders orders = new Orders(LocalDateTime.now());

		ordersDao.saveAndFlush(orders);

		User user = userDao.findUserWithDrinks(userId);

		orders.setUser(user);

		for (Drink drink : user.getDrinks()) {

			orders.getDrinks().add(drink);

			ordersDao.save(orders);

		}

		user.getDrinks().clear();
		userDao.save(user);

	}
}
