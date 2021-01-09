package design.boilerplate.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.CompanyType;

public interface CompanyTypeRepository extends CrudRepository<CompanyType, Long> {

	CompanyType findByCompanyTypeName(String companyTypeName);

	List<CompanyType> findByStatus(String status);

	boolean existsByCompanyTypeName(String companyTypeName);
}
