package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Menu;

public interface MenuRepository extends CrudRepository<Menu, Long> {
	
	Menu findByParentMenuId_id(Long id);

}
