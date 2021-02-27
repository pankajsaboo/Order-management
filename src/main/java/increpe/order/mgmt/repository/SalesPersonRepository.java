package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.SalesPerson;

public interface SalesPersonRepository extends CrudRepository<SalesPerson, Long>{

	 SalesPerson findByUserId_id(Long id);
	 
	 boolean existsByEmployeeId(String empId);
}
