package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Country;
import increpe.order.mgmt.repository.CountryRepository;
import increpe.order.mgmt.security.dto.CountryDto;
import increpe.order.mgmt.security.mapper.AddressMapper;

@Service
public class CountryService {
	
	
	@Autowired
	CountryRepository countryRepository;

	
	public CountryDto createCountry(CountryDto countryDto) {
		
		Country country = convertCountryDtoToCountry(countryDto);
		
		return convertCountryToCountryDto(countryRepository.save(country));
	}

	
	public CountryDto getCountryById(Long id) {
		
		return convertCountryToCountryDto(countryRepository.findById(id).get());
	}

	
	public CountryDto getCountryByCountryName(String countryName) {
		
		return convertCountryToCountryDto(countryRepository.findByCountryName(countryName));
	}

	
	public CountryDto getCountryByCountryCode(String countryCode) {
		
		return convertCountryToCountryDto(countryRepository.findByCountryCode(countryCode));
	}

	
	public List<CountryDto> getCountryByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public CountryDto updateCountry(CountryDto countryDto) {
		
		if(countryRepository.existsById(countryDto.getId())) {
			
			Country country = convertCountryDtoToCountry(countryDto);
			
			return convertCountryToCountryDto(countryRepository.save(country));
		}else {
			
			return createCountry(countryDto);
		}
	}

	
	public boolean deleteCountry(CountryDto countryDto) {
		
		if(countryRepository.existsById(countryDto.getId())) {
			
			countryRepository.deleteById(countryDto.getId());
			
			return countryRepository.existsById(countryDto.getId());
		}else {
			return false;
		}
		
	}
	
	
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
