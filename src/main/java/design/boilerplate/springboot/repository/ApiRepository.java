package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Api;

public interface ApiRepository extends CrudRepository<Api, Long> {

	Api findByApiName(String ApiName);

	boolean existsByApiName(String apiName);

}
