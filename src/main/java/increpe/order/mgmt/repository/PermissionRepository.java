package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Permission;
import increpe.order.mgmt.model.Roles;

public interface PermissionRepository extends CrudRepository<Permission, Long> {

	boolean existsByTitle(String title);

	Permission findByTitle(String permissionTitle);
}
