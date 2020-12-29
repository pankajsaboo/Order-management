package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.CompanyType;

public interface CompanyTypeRepository extends CrudRepository<CompanyType, Long>{
}
