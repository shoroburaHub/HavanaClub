package com.HavanaClub.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.HavanaClub.entity.User;

public interface UserDao extends JpaRepository<User, Integer> {

//	@Query("select u from User u where u.name=:param1 and u.email=:param2")
//	User findUserByNameEmail(@Param("param1")String name, @Param("param2")String email);
	
	User findByNameAndEmail(String name, String email);
	
	@Query("select u from User u left join fetch u.drinks where u.id=:id")
	User findUserWithDrinks(@Param("id") int id);
	
	@Query("select u from User u left join fetch u.orders o left join fetch o.drinks where u.id=:id")
	User findUserWithOrders(@Param("id") int id);
	
	
}
