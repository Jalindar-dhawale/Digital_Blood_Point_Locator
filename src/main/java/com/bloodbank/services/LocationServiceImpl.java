package com.bloodbank.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bloodbank.daos.CityDAO;
import com.bloodbank.daos.CountryDAO;
import com.bloodbank.daos.DistrictDAO;
import com.bloodbank.daos.StateDAO;
import com.bloodbank.entities.City;
import com.bloodbank.entities.Country;
import com.bloodbank.entities.District;
import com.bloodbank.entities.State;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	private CountryDAO countryDAO;
	@Autowired
	private StateDAO stateDAO;
	@Autowired
	private DistrictDAO districtDAO;
	@Autowired
	private CityDAO cityDAO;

	@Override
	public List<Country> getCountries() {
		return countryDAO.findAll();

	}

	@Override
	public List<State> getStates(Integer countryId) {
		List<State> states = null;
		Optional<Country> country = countryDAO.findById(countryId);
		if (country.isPresent()) {
			states = stateDAO.findAllByCountry(country.get());
		}

		return states;
	}

	@Override
	public List<District> getDistricts(Integer stateId) {
		List<District> districts = null;
		Optional<State> state=stateDAO.findById(stateId);
		if(state.isPresent()) {
			return districtDAO.findAllByState(state.get());
		}
		return districts;
		
	}

	@Override
	public List<City> getCities(Integer distId) {
		List<City> cities = null;
		Optional<District> district=districtDAO.findById(distId);
		if(district.isPresent()) {
			return cityDAO.findAllByDistrict(district.get());
		}
		
		return cities;
	}
}
