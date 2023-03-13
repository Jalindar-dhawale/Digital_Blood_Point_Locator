package com.bloodbank.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bloodbank.entities.City;
import com.bloodbank.entities.District;

@Repository
public interface CityDAO extends JpaRepository<City, Integer>{

	List<City> findAllByDistrict(District district);

}
