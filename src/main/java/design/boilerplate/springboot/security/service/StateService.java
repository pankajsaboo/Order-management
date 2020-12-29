package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.State;
import design.boilerplate.springboot.repository.StateRepository;
import design.boilerplate.springboot.security.dto.CountryDto;
import design.boilerplate.springboot.security.dto.StateDto;

@Service
public interface StateService {

	StateDto getStateById(Long id);

}
