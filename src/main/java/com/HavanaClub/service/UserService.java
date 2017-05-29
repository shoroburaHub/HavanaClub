package com.HavanaClub.service;

import java.util.List;

import com.HavanaClub.entity.User;

public interface UserService {

	void save(User user) throws Exception;

	List<User> findAll();

	User findOne(int id);

	void delete(int id);

	void update(User user);

	User findUserWithOrders(int id);

	User findByName(String name);

}
