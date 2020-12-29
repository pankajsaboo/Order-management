package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.API;

public interface ApiRepository extends CrudRepository<API, Long> {

}
