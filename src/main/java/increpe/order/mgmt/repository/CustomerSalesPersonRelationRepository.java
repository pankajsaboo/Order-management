package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.CustomerSalesPersonRelation;
import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.security.dto.CustomerSalesPersonRelationDto;

public interface CustomerSalesPersonRelationRepository extends CrudRepository<CustomerSalesPersonRelation, Long> {
	
	List<CustomerSalesPersonRelation> findByCustomerCompanyId_idAndStatus(Long customerCompanyId, String status);

	List<CustomerSalesPersonRelation> findBySalesPersonId_id(Long salesPersonId);
	
	void deleteBySalesPersonId(SalesPerson salesPerson);
	
	void deleteByCustomerCompanyId(Company company);
	
	void deleteByCustomerCompanyIdAndSalesPersonId(Company company, SalesPerson salesPerson);
}
