package com.bloodbank.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entities.Country;

@Repository
public interface CountryDAO extends JpaRepository<Country, Integer> {

}
