package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.State;
import design.boilerplate.springboot.repository.StateRepository;
import design.boilerplate.springboot.security.dto.CountryDto;
import design.boilerplate.springboot.security.dto.StateDto;

@Service
public class StateServiceImpl implements StateService {
	

	@Autowired
	StateRepository stateRepository;

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

}
