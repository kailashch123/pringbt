package com.kailash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.kailash.exception.RecordNotFoundException;
import com.kailash.service.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {
	
	@Autowired
	private CountryService countryService;
	
	@GetMapping
	public String getAllCountry() {
		String info = countryService.getAllCountry();
		if((info == null) || info.isEmpty()) {
			throw new RecordNotFoundException("No record found.");
		} else {
			return info;
		}
	}
	
	@GetMapping(value="/{capitalName}")
	public String getCountryByName(@PathVariable String capitalName) {
		String info = countryService.getCountryInfoByCapital(capitalName);
		if((info == null) || info.isEmpty()) {
			throw new RecordNotFoundException("No record found for capital:"+capitalName);
		} else {
			return info;
		}
	}
	
}
