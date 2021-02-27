package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
	
	List<Activity> findBySalesPersonId_id(Long salesPersonId);

}
