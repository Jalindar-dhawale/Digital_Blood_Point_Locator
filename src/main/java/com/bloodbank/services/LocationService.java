package com.bloodbank.services;

import java.util.List;

import com.bloodbank.entities.City;
import com.bloodbank.entities.Country;
import com.bloodbank.entities.District;
import com.bloodbank.entities.State;

public interface LocationService {
	
	public List<Country> getCountries();
	public List<State> getStates(Integer countryId);
	public List<District> getDistricts(Integer stateId) ;
	public List<City> getCities(Integer distId);

}
