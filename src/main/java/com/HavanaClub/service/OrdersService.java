package com.HavanaClub.service;

import com.HavanaClub.entity.Orders;

import java.security.Principal;
import java.util.List;

public interface OrdersService {

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	void update(Orders orders);

	void addIntoBasket(Principal principal, int id);

	void deleteFromBasket(int userId, int drinkId);

	void buy(int userId);
}
