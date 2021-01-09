package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.model.State;
import design.boilerplate.springboot.repository.CountryRepository;
import design.boilerplate.springboot.repository.StateRepository;
import design.boilerplate.springboot.security.dto.CountryDto;
import design.boilerplate.springboot.security.dto.StateDto;
import design.boilerplate.springboot.security.mapper.CityMapper;

@Service
public class StateServiceImpl implements StateService {
	

	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CountryService countryService;

	@Override
	public StateDto createState(StateDto stateDto) {
		
		State state = convertStateDtoToState(stateDto);
		
		Country countryId = countryService.getCountryByName(state.getCountryId().getCountryName());
		
		state.setCountryId(countryId);
		
		return convertStateToStateDto(stateRepository.save(state));
	}

	@Override
	public StateDto getStateById(Long id) {
		
		return convertStateToStateDto(stateRepository.findById(id).get());
	}

	@Override
	public StateDto getStateByStateName(String stateName) {
		
		return convertStateToStateDto(stateRepository.findByStateName(stateName));
	}

	@Override
	public StateDto getStateByStateCode(String stateCode) {
		
		return convertStateToStateDto(stateRepository.findByStateCode(stateCode));
	}

	@Override
	public List<StateDto> getStateByStatus(String status) {
		
		return null;
	}

	@Override
	public StateDto updateState(StateDto stateDto) {
		
		if(stateRepository.existsById(stateDto.getId())) {
			
			State state = convertStateDtoToState(stateDto);
			
			return convertStateToStateDto(stateRepository.save(state));
		}else {
			
			return createState(stateDto);
		}
	}

	@Override
	public boolean deleteState(StateDto stateDto) {
		
		if(stateRepository.existsById(stateDto.getId())) {
			
			stateRepository.deleteById(stateDto.getId());
			
			return stateRepository.existsById(stateDto.getId());
		} 
		
		return false;
	}
	
	@Override
	public State getStateByName(String stateName) {
		
		return stateRepository.findByStateName(stateName);
	}
	
	private StateDto convertStateToStateDto(State state) {
		
		return CityMapper.INSTANCE.convertToStateDto(state);
	}
	
	private State convertStateDtoToState(StateDto stateDto) {
		
		return CityMapper.INSTANCE.convertToState(stateDto);
	}

	

}
