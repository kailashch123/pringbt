package com.kailash.controller;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.kailash.repository.CountryRepositoryImpl;
import com.kailash.service.CountryService;

@RunWith(MockitoJUnitRunner.class)
public class CountryControllerTest {

	@Mock
	CountryRepositoryImpl countryRepository;

	@InjectMocks
	CountryService countryService;

	@Test
	public void testGetAllCountry() {
		when(countryRepository.getAllCountry()).thenReturn("\"name\":\"India\",\"topLevelDomain\":[\".in\"],\"alpha2Code\":\"IN\",\"alpha3Code\":\"IND\",\"callingCodes\":[\"91\"],\"capital\":\"New Delhi\",\"altSpellings\":[\"IN\",\"Bhārat\",\"Republic of India\",\"Bharat Ganrajya\"],\"region\":\"Asia\",\"subregion\":\"Southern Asia\",\"population\":1295210000,\"latlng\":[20.0,77.0],\"demonym\":\"Indian\",\"area\":3287590.0,\"gini\":33.4,\"timezones\":[\"UTC+05:30\"],\"borders\":[\"AFG\",\"BGD\",\"BTN\",\"MMR\",\"CHN\",\"NPL\",\"PAK\",\"LKA\"],\"nativeName\":\"भारत\",\"numericCode\":\"356\",\"currencies\":[{\"code\":\"INR\",\"name\":\"Indian rupee\",\"symbol\":\"₹\"}],\"languages\":[{\"iso639_1\":\"hi\",\"iso639_2\":\"hin\",\"name\":\"Hindi\",\"nativeName\":\"हिन्दी\"},{\"iso639_1\":\"en\",\"iso639_2\":\"eng\",\"name\":\"English\",\"nativeName\":\"English\"}],\"translations\":{\"de\":\"Indien\",\"es\":\"India\",\"fr\":\"Inde\",\"ja\":\"インド\",\"it\":\"India\",\"br\":\"Índia\",\"pt\":\"Índia\",\"nl\":\"India\",\"hr\":\"Indija\",\"fa\":\"هند\"},\"flag\":\"https://restcountries.eu/data/ind.svg\",\"regionalBlocs\":[{\"acronym\":\"SAARC\",\"name\":\"South Asian Association for Regional Cooperation\",\"otherAcronyms\":[],\"otherNames\":[]}],\"cioc\":\"IND\"");
		assertTrue(countryService.getAllCountry().indexOf("India") > -1);
	}
	
	@Test
	public void testGetInfoByCapitalFavour() {
		when(countryRepository.getInfoByCapital("Delhi")).thenReturn("[{\"name\":\"India\",\"topLevelDomain\":[\".in\"],\"alpha2Code\":\"IN\",\"alpha3Code\":\"IND\",\"callingCodes\":[\"91\"],\"capital\":\"New Delhi\",\"altSpellings\":[\"IN\",\"Bhārat\",\"Republic of India\",\"Bharat Ganrajya\"],\"region\":\"Asia\",\"subregion\":\"Southern Asia\",\"population\":1295210000,\"latlng\":[20.0,77.0],\"demonym\":\"Indian\",\"area\":3287590.0,\"gini\":33.4,\"timezones\":[\"UTC+05:30\"],\"borders\":[\"AFG\",\"BGD\",\"BTN\",\"MMR\",\"CHN\",\"NPL\",\"PAK\",\"LKA\"],\"nativeName\":\"भारत\",\"numericCode\":\"356\",\"currencies\":[{\"code\":\"INR\",\"name\":\"Indian rupee\",\"symbol\":\"₹\"}],\"languages\":[{\"iso639_1\":\"hi\",\"iso639_2\":\"hin\",\"name\":\"Hindi\",\"nativeName\":\"हिन्दी\"},{\"iso639_1\":\"en\",\"iso639_2\":\"eng\",\"name\":\"English\",\"nativeName\":\"English\"}],\"translations\":{\"de\":\"Indien\",\"es\":\"India\",\"fr\":\"Inde\",\"ja\":\"インド\",\"it\":\"India\",\"br\":\"Índia\",\"pt\":\"Índia\",\"nl\":\"India\",\"hr\":\"Indija\",\"fa\":\"هند\"},\"flag\":\"https://restcountries.eu/data/ind.svg\",\"regionalBlocs\":[{\"acronym\":\"SAARC\",\"name\":\"South Asian Association for Regional Cooperation\",\"otherAcronyms\":[],\"otherNames\":[]}],\"cioc\":\"IND\"}]");
		assertTrue(countryService.getCountryInfoByCapital("Delhi").indexOf("Bharat Ganrajya") > -1);
	}
	
	@Test
	public void testGetInfoByCapitalUnFavour() {
		when(countryRepository.getInfoByCapital("Abcd")).thenReturn("Record not found");
		assertTrue(countryService.getCountryInfoByCapital("Abcd").indexOf("Record not found") > -1);
	}

}
