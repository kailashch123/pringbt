package com.kailash.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.kailash.exception.RecordNotFoundException;

@Repository("countryRepository")
public class CountryRepositoryImpl {

	public String getInfoByCapital(String capitalName) {
		RestTemplate restTemplate = new RestTemplate();
		String reqUrl = "https://restcountries.eu/rest/v2/capital/"+capitalName;
		String country = null;
		try {
			country = restTemplate.getForObject(reqUrl, String.class);
		} catch(Exception ex) {
			country = "Record not found";
		}
        return country;
	}

	public String getAllCountry() {
		RestTemplate restTemplate = new RestTemplate();
		String reqUrl = "https://restcountries.eu/rest/v2/name/india";
		String country = null;
		try {
			country = restTemplate.getForObject(reqUrl, String.class);
		} catch(Exception ex) {
			throw new RecordNotFoundException("Record not found");
		}
        return country;
	}
}
