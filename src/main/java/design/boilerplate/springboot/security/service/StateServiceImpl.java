package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.model.State;
import design.boilerplate.springboot.repository.CountryRepository;
import design.boilerplate.springboot.repository.StateRepository;
import design.boilerplate.springboot.security.dto.CountryDto;
import design.boilerplate.springboot.security.dto.StateDto;

@Service
public class StateServiceImpl implements StateService {
	

	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CountryRepository countryRepository;

	@Override
	public StateDto getStateById(Long id) {
		
		StateDto stateDto = new StateDto();
		
		State state = stateRepository.findById(id).get();
		
		CountryDto countryDto = new CountryDto();
		
		BeanUtils.copyProperties(state.getCountryId(), countryDto);
		
		BeanUtils.copyProperties(state, stateDto);
		
		stateDto.setCountry(countryDto);
		
		return stateDto;
	}

	@Override
	public StateDto createState(StateDto stateDto) {
		
		State state = new State();
		
		Country country = countryRepository.findByCountryName(stateDto.getCountry().getCountryName());
		
		BeanUtils.copyProperties(stateDto, state);
		
		state.setCountryId(country);
		
		stateRepository.save(state);
		
		return getStateById(state.getId());
	}
	

}
