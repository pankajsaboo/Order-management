package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.CompanyTypeRelation;

public interface CompanyTypeRelationRepository extends CrudRepository<CompanyTypeRelation, Long> {
	
	CompanyTypeRelation findByCompanyId_id(Company companyId);

}
