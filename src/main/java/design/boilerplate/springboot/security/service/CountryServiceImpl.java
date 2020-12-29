package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.repository.CountryRepository;
import design.boilerplate.springboot.security.dto.CountryDto;

@Service
public class CountryServiceImpl implements CountryService {
	
	
	@Autowired
	CountryRepository countryRepository;

	@Override
	public CountryDto getCountryById(Long id) {
		CountryDto countryDto = new CountryDto();
		
		Country country = countryRepository.findById(id).get();
		BeanUtils.copyProperties(country, countryDto);
		
		return countryDto;
	}

}
