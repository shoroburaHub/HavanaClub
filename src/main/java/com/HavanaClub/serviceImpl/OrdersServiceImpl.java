package com.HavanaClub.serviceImpl;

import java.time.LocalDate;
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

@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersDao ordersDao;
	@Autowired
	private DrinkDao drinkDao;
	@Autowired
	private UserDao userDao;

	public void save(int userId, List<Integer> drinksIds) {
		Orders orders = new Orders(LocalDate.now());
		ordersDao.saveAndFlush(orders);
		
		List<Drink> drinks = new ArrayList<Drink>();
		
		for(Integer id : drinksIds){
			drinks.add(drinkDao.findOne(id));
		}
		
		orders.setDrinks(new HashSet<Drink>(drinks));

		User user = userDao.findOne(userId);
		
		orders.setUser(user);
		
		ordersDao.save(orders);
	}

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

}
