package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.State;
import design.boilerplate.springboot.security.dto.StateDto;

@Service
public interface StateService {
	
	StateDto createState(StateDto stateDto);

	StateDto getStateById(Long id);
	
	StateDto getStateByStateName(String stateName);
	
	State getStateByName(String stateName);
	
	StateDto getStateByStateCode(String stateCode);
	
	List<StateDto> getStateByStatus(String status);
	
	StateDto updateState(StateDto stateDto);
	
	boolean deleteState(StateDto stateDto);

}
