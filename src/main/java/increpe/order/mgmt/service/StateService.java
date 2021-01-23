package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Country;
import increpe.order.mgmt.model.State;
import increpe.order.mgmt.repository.StateRepository;
import increpe.order.mgmt.security.dto.StateDto;
import increpe.order.mgmt.security.mapper.AddressMapper;

@Service
public class StateService {
	

	@Autowired
	StateRepository stateRepository;
	
	@Autowired
	CountryService countryService;

	
	public StateDto createState(StateDto stateDto) {
		
		State state = convertStateDtoToState(stateDto);
		
		Country countryId = countryService.getCountryByName(state.getCountryId().getCountryName());
		
		state.setCountryId(countryId);
		
		return convertStateToStateDto(stateRepository.save(state));
	}

	
	public StateDto getStateById(Long id) {
		
		return convertStateToStateDto(stateRepository.findById(id).get());
	}

	
	public StateDto getStateByStateName(String stateName) {
		
		return convertStateToStateDto(stateRepository.findByStateName(stateName));
	}

	
	public StateDto getStateByStateCode(String stateCode) {
		
		return convertStateToStateDto(stateRepository.findByStateCode(stateCode));
	}

	
	public List<StateDto> getStateByStatus(String status) {
		
		return null;
	}

	
	public StateDto updateState(StateDto stateDto) {
		
		if(stateRepository.existsById(stateDto.getId())) {
			
			State state = convertStateDtoToState(stateDto);
			
			return convertStateToStateDto(stateRepository.save(state));
		}else {
			
			return createState(stateDto);
		}
	}

	
	public boolean deleteState(StateDto stateDto) {
		
		if(stateRepository.existsById(stateDto.getId())) {
			
			stateRepository.deleteById(stateDto.getId());
			
			return stateRepository.existsById(stateDto.getId());
		} 
		
		return false;
	}
	
	
	public State getStateByName(String stateName) {
		
		return stateRepository.findByStateName(stateName);
	}
	
	private StateDto convertStateToStateDto(State state) {
		
		return AddressMapper.INSTANCE.convertToStateDto(state);
	}
	
	private State convertStateDtoToState(StateDto stateDto) {
		
		return AddressMapper.INSTANCE.convertToState(stateDto);
	}

	

}
