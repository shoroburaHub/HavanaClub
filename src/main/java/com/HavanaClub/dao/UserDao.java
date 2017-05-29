package com.HavanaClub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.HavanaClub.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

	
	@Query("select u from User u left join fetch u.drinks where u.id=:id")
	User findUserWithDrinks(@Param("id") int id);
	
	@Query("select u from User u left join fetch u.orders o left join fetch o.drinks where u.id=:id")
	User findUserWithOrders(@Param("id") int id);

	User findByName(String name);
	User findByEmail(String email);

}
