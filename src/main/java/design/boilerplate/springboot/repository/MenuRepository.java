package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {
	
	Menu findByParentMenuId_id(Long id);

}
