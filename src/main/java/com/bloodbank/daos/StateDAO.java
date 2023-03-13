package com.bloodbank.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entities.Country;
import com.bloodbank.entities.State;

@Repository
public interface StateDAO extends JpaRepository<State, Integer> {

	List<State> findAllByCountry(Country country);

}
