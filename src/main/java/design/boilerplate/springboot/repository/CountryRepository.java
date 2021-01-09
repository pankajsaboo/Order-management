package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {
	
	public Country findByCountryCode(String countryCode);

	public Country findByCountryName(String countryName);

	public boolean existsByCountryName(String countryName);
	
}
