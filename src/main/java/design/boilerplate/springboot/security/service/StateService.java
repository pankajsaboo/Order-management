package design.boilerplate.springboot.security.service;

import org.springframework.stereotype.Service;

import design.boilerplate.springboot.security.dto.StateDto;

@Service
public interface StateService {

	StateDto getStateById(Long id);
	
	StateDto createState(StateDto stateDto);

}
