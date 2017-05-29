package com.HavanaClub.serviceImpl;

import java.util.List;

import com.HavanaClub.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.HavanaClub.dao.UserDao;
import com.HavanaClub.entity.User;
import com.HavanaClub.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Autowired
	@Qualifier("userValidator")
	private Validator validator;

	public void save(User user) throws Exception {

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
	public User findByName(String name) {
		return userDao.findByName(name);
	}

}
