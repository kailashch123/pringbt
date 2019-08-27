package com.kailash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kailash.exception.RecordNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

	@GetMapping(value="/{calitalName}")
	public String getCountryByName(@PathVariable String calitalName) {
		RestTemplate restTemplate = new RestTemplate();
		String reqUrl = "https://restcountries.eu/rest/v2/capital/"+calitalName;
		String country = null;
		try {
			country = restTemplate.getForObject(reqUrl, String.class);
		} catch(Exception ex) {
			throw new RecordNotFoundException("Record not found. calitalName-"+calitalName);
		}
        return country;
	}
	
}
