package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.repository.CountryRepository;
import design.boilerplate.springboot.security.dto.CountryDto;

@Service
public interface CountryService {
	
	public CountryDto getCountryById(Long id);

}
