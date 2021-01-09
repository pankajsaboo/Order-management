package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.security.dto.CountryDto;

public interface CountryService {
	
	CountryDto createCountry(CountryDto countryDto);

	CountryDto getCountryById(Long id);
	
	CountryDto getCountryByCountryName(String countryName);
	
	Country getCountryByName(String countryName);
	
	CountryDto getCountryByCountryCode(String countryCode);
	
	List<CountryDto> getCountryByStatus(String status);
	
	CountryDto updateCountry(CountryDto countryDto);
	
	boolean deleteCountry(CountryDto countryDto);

}
