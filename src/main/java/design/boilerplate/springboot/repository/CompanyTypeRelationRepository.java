package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.model.CompanyTypeRelation;

public interface CompanyTypeRelationRepository extends CrudRepository<CompanyTypeRelation, Long> {
	
	CompanyTypeRelation findByCompanyId_id(Company companyId);

}
