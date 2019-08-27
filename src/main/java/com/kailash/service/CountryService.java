package com.kailash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kailash.repository.CountryRepositoryImpl;

@Service("countryService")
public class CountryService {
	
	@Autowired
	private CountryRepositoryImpl countryRepository;
	
	public String getCountryInfoByCapital(String capitalName) {
		return countryRepository.getInfoByCapital(capitalName);
	}

	public String getAllCountry() {
		return countryRepository.getAllCountry();
	}
}
