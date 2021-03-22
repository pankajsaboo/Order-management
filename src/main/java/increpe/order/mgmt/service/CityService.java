package increpe.order.mgmt.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.City;
import increpe.order.mgmt.model.State;
import increpe.order.mgmt.repository.CityRepository;
import increpe.order.mgmt.security.dto.CityDto;
import increpe.order.mgmt.security.dto.StateDto;
import increpe.order.mgmt.security.mapper.AddressMapper;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepository;
	
	@Autowired
	StateService stateService;

	
	public CityDto createCity(CityDto cityDto) {
		
		City city = convertCityDtoToCity(cityDto);
		
		State stateId = stateService.getStateByName(cityDto.getState().getStateName());
		
		city.setStateId(stateId);
		
		return convertCityToCityDto(cityRepository.save(city));
	}

	
	public CityDto getCityById(Long id) {
		
		return convertCityToCityDto(cityRepository.findById(id).get());
	}

	
	public CityDto getCityByCityName(String cityName) {

		return convertCityToCityDto(cityRepository.findByCityName(cityName));
	}
	
	
	public CityDto getCityByCityCode(String cityCode) {
		
		return convertCityToCityDto(cityRepository.findByCityCode(cityCode));
	}

	
	public List<CityDto> getCityByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public CityDto updateCity(CityDto cityDto) {
		
		if(cityRepository.existsById(cityDto.getId())) {
			
			City city = convertCityDtoToCity(cityDto);
			
			return convertCityToCityDto(cityRepository.save(city));
			
		}
			
		return createCity(cityDto);

	}

	
	public boolean deleteCity(CityDto cityDto) {
		
		if(cityRepository.existsById(cityDto.getId())) {
		
			cityRepository.deleteById(cityDto.getId());
			
			return cityRepository.existsById(cityDto.getId());
		}
		
		return false;
	}
	
	
	public City getCityByName(String cityName) {
		
		City storedCity = cityRepository.findByCityName(cityName.trim().toUpperCase());
		
		if(Objects.isNull(storedCity)) {
			
			City city = new City();
			
			State state = new State();
			
			state.setId(1L);
			city.setCityName(cityName.trim().toUpperCase());
			city.setStateId(state);
			
			return city;
		}
		
		return storedCity;
	}
	
	private CityDto convertCityToCityDto(City city) {
		return AddressMapper.INSTANCE.convertToCityDto(city);
	}
	
	private City convertCityDtoToCity(CityDto cityDto) {
		return AddressMapper.INSTANCE.convertToCity(cityDto);
	}

}
