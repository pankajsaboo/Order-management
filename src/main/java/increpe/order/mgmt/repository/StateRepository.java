package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.City;
import increpe.order.mgmt.model.State;

public interface StateRepository extends CrudRepository<State, Long> {

	// public 

	public State findByCountryId_id(Long id);

	public State findByStateCode(String stateCode);

	public State findByStateName(String stateName);

	public boolean existsByStateName(String stateName);
}
