package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.City;
import design.boilerplate.springboot.security.dto.CityDto;

public interface CityService {
	
	CityDto createCity(CityDto cityDto);
	
	CityDto getCityById(Long id);
	
	CityDto getCityByCityName(String cityName);
	
	City getCityByName(String cityName);
	
	CityDto getCityByCityCode(String cityCode);
	
	List<CityDto> getCityByStatus(String status);
	
	CityDto updateCity(CityDto cityDto);
	
	boolean deleteCity(CityDto cityDto);

}
