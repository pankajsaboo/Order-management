package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.ApiRolesRelation;

public interface ApiRolesRepository extends CrudRepository<ApiRolesRelation, Long> {

}
