package increpe.order.mgmt.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Visits;

public interface VisitsRepository extends CrudRepository<Visits, Long> {
	
	List<Visits> findByCustomerSalesPersonRelationId_id(Long relationId);
	
	List<Visits> findByCustomerSalesPersonRelationId_SalesPersonId_id(Long salesPersonId);
	
	List<Visits> findByVisitDateAndCustomerSalesPersonRelationId_SalesPersonId_id(LocalDate visitDate, Long salesPersonId);

}
