package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Company;

public interface CompanyRepository extends CrudRepository<Company, Long> {
	
	boolean existsByCompanyName(String companyName);

	Company findByCompanyName(String companyName);

}
