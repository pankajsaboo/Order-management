package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Tour;

public interface TourRepository extends CrudRepository<Tour, Long> {

	List<Tour> findBySalesPersonId_id(Long salesPersonId);
}
