package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.repository.CountryRepository;
import design.boilerplate.springboot.security.dto.CountryDto;
import design.boilerplate.springboot.security.mapper.AddressMapper;

@Service
public class CountryServiceImpl implements CountryService {
	
	
	@Autowired
	CountryRepository countryRepository;

	@Override
	public CountryDto createCountry(CountryDto countryDto) {
		
		Country country = convertCountryDtoToCountry(countryDto);
		
		return convertCountryToCountryDto(countryRepository.save(country));
	}

	@Override
	public CountryDto getCountryById(Long id) {
		
		return convertCountryToCountryDto(countryRepository.findById(id).get());
	}

	@Override
	public CountryDto getCountryByCountryName(String countryName) {
		
		return convertCountryToCountryDto(countryRepository.findByCountryName(countryName));
	}

	@Override
	public CountryDto getCountryByCountryCode(String countryCode) {
		
		return convertCountryToCountryDto(countryRepository.findByCountryCode(countryCode));
	}

	@Override
	public List<CountryDto> getCountryByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CountryDto updateCountry(CountryDto countryDto) {
		
		if(countryRepository.existsById(countryDto.getId())) {
			
			Country country = convertCountryDtoToCountry(countryDto);
			
			return convertCountryToCountryDto(countryRepository.save(country));
		}else {
			
			return createCountry(countryDto);
		}
	}

	@Override
	public boolean deleteCountry(CountryDto countryDto) {
		
		if(countryRepository.existsById(countryDto.getId())) {
			
			countryRepository.deleteById(countryDto.getId());
			
			return countryRepository.existsById(countryDto.getId());
		}else {
			return false;
		}
		
	}
	
	@Override
	public Country getCountryByName(String countryName) {
		
		return countryRepository.findByCountryName(countryName);
	}

	
	private CountryDto convertCountryToCountryDto(Country country) {
		
		return AddressMapper.INSTANCE.convertToCountryDto(country);
	}
	
	private Country convertCountryDtoToCountry(CountryDto countryDto) {
		
		return AddressMapper.INSTANCE.convertToCountry(countryDto);
	}

	
	

}
