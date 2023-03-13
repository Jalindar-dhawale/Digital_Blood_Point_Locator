package com.bloodbank.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entities.District;
import com.bloodbank.entities.State;

@Repository
public interface DistrictDAO extends JpaRepository<District, Integer> {

	List<District> findAllByState(State state);

}
