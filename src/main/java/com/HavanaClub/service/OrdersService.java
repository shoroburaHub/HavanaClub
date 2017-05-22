package com.HavanaClub.service;

import com.HavanaClub.entity.Orders;

import java.util.List;

public interface OrdersService {

	void save(int userId, List<Integer> drinksIds);

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	void update(Orders orders);

	
}
