package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.City;
import design.boilerplate.springboot.model.State;

public interface StateRepository extends CrudRepository<State, Long> {

	// public 

	public State findByCountryId_id(Long id);

	public State findByStateCode(String stateCode);

	public State findByStateName(String stateName);

	public boolean existsByStateName(String stateName);
}
