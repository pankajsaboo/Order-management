package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.City;
import design.boilerplate.springboot.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityRepository cityReository;

	@Override
	public City getCityById(Long id) {
		
		return cityReository.findById(id).get();
		
	}

}
