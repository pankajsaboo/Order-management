package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import design.boilerplate.springboot.model.State;

public interface StateRepository extends CrudRepository<State, Long> {

	public State findByCountryId_id(Long id);
}
