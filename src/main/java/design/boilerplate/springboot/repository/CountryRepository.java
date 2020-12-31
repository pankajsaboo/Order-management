package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	
	Country findByCountryName(String countryName);
	
}
