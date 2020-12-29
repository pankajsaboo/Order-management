package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.City;

public interface CityRepository extends CrudRepository<City, Long> {

	public City findByStateId_id(Long id);
}
