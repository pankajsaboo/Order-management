package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.City;
import design.boilerplate.springboot.model.State;
import design.boilerplate.springboot.repository.CityRepository;
import design.boilerplate.springboot.repository.StateRepository;
import design.boilerplate.springboot.security.dto.CityDto;
import design.boilerplate.springboot.security.mapper.AddressMapper;

@Service
public class CityServiceImpl implements CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	StateService stateService;

	@Override
	public CityDto createCity(CityDto cityDto) {
		
		City city = convertCityDtoToCity(cityDto);
		
		State stateId = stateService.getStateByName(cityDto.getState().getStateName());
		
		city.setStateId(stateId);
		
		return convertCityToCityDto(cityRepository.save(city));
	}

	@Override
	public CityDto getCityById(Long id) {
		
		return convertCityToCityDto(cityRepository.findById(id).get());
	}

	@Override
	public CityDto getCityByCityName(String cityName) {

		return convertCityToCityDto(cityRepository.findByCityName(cityName));
	}
	
	@Override
	public CityDto getCityByCityCode(String cityCode) {
		
		return convertCityToCityDto(cityRepository.findByCityCode(cityCode));
	}

	@Override
	public List<CityDto> getCityByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CityDto updateCity(CityDto cityDto) {
		
		if(cityRepository.existsById(cityDto.getId())) {
			
			City city = convertCityDtoToCity(cityDto);
			
			return convertCityToCityDto(cityRepository.save(city));
			
		}
			
		return createCity(cityDto);

	}

	@Override
	public boolean deleteCity(CityDto cityDto) {
		
		if(cityRepository.existsById(cityDto.getId())) {
		
			cityRepository.deleteById(cityDto.getId());
			
			return cityRepository.existsById(cityDto.getId());
		}
		
		return false;
	}
	
	@Override
	public City getCityByName(String cityName) {
		
		return cityRepository.findByCityName(cityName);
	}
	
	private CityDto convertCityToCityDto(City city) {
		return AddressMapper.INSTANCE.convertToCityDto(city);
	}
	
	private City convertCityDtoToCity(CityDto cityDto) {
		return AddressMapper.INSTANCE.convertToCity(cityDto);
	}

}
