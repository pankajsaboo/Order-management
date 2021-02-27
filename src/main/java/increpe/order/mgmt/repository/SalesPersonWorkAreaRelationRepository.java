package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.model.SalesPersonWorkAreaRelation;

public interface SalesPersonWorkAreaRelationRepository extends CrudRepository<SalesPersonWorkAreaRelation, Long>{
	
	List<SalesPersonWorkAreaRelation> findBySalesPersonId_id(Long id);
	
	List<SalesPersonWorkAreaRelation> findBySalesPersonId_UserId_id(Long id);
	
	List<SalesPersonWorkAreaRelation> findBySalesPersonId_UserId_idIn(List<Long> idList);
	
	void deleteBySalesPersonId(SalesPerson salesPerson);

}
