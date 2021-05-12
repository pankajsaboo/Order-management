package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.CustomerSalesPersonRelation;
import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.security.dto.CustomerSalesPersonRelationDto;

public interface CustomerSalesPersonRelationRepository extends CrudRepository<CustomerSalesPersonRelation, Long> {
	
	List<CustomerSalesPersonRelation> findByCustomerCompanyId_id(Long customerCompanyId);

	List<CustomerSalesPersonRelation> findBySalesPersonId_idAndStatus(Long salesPersonId, String status);
	
	void deleteBySalesPersonId(SalesPerson salesPerson);
	
	void deleteByCustomerCompanyId(Company company);
	
	void deleteByCustomerCompanyIdAndSalesPersonId(Company company, SalesPerson salesPerson);
}
