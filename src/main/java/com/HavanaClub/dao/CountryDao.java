package com.HavanaClub.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.HavanaClub.entity.Country;

public interface CountryDao extends JpaRepository<Country, Integer> {

}
