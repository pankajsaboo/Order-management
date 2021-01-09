package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.CompanyProduct;

public interface CompanyProductRepository extends CrudRepository<CompanyProduct, Long> {

}
