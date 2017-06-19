package com.HavanaClub.dao;

import com.HavanaClub.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 6/19/2017.
 */
public interface CityDao extends JpaRepository<City, Integer> {
}
