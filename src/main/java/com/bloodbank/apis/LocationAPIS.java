package com.bloodbank.apis;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bloodbank.entities.City;
import com.bloodbank.entities.Country;
import com.bloodbank.entities.District;
import com.bloodbank.entities.State;
import com.bloodbank.exceptions.CustomException;
import com.bloodbank.services.LocationService;
import com.bloodbank.utils.Constants;

@RestController("location")
public class LocationAPIS {
	@Autowired
	private LocationService locationService;

	@GetMapping(path="/country", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Country> getCountry() throws Exception {
		List<Country> countries = locationService.getCountries();
		if (countries == null || countries.isEmpty()) {
			throw CustomException.build(Constants.SERVER_ERROR_MESSAGE).withStatus(HttpStatus.CONFLICT);
		}
		return countries;
	}

	@GetMapping(path="/state/{countryId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<State> getState(@PathVariable("countryId") Integer countryId) throws Exception {
		List<State> states = locationService.getStates(countryId);
		if (states == null || states.isEmpty()) {
			throw CustomException.build(Constants.ERROR_DATA_NOT_FOUND_FOR + " countryId = " + countryId)
					.withStatus(HttpStatus.CONFLICT);
		}
		return states;
	}

	@GetMapping(path="/dist/{stateId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<District> getDistrict(@PathVariable("stateId") Integer stateId) throws Exception {
		List<District> districts = locationService.getDistricts(stateId);
		if (districts == null || districts.isEmpty()) {
			throw CustomException.build(Constants.ERROR_DATA_NOT_FOUND_FOR + " stateId = " + stateId)
			.withStatus(HttpStatus.CONFLICT);
		}
		return districts;
	}

	@GetMapping(path="/city/{distId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<City> getCity(@PathVariable("distId") Integer distId) throws Exception {
		List<City> cities = locationService.getCities(distId);
		if (cities == null || cities.isEmpty()) {
			throw CustomException.build(Constants.ERROR_DATA_NOT_FOUND_FOR + " distId = " + distId)
			.withStatus(HttpStatus.CONFLICT);
		}
		return cities;
	}
}
