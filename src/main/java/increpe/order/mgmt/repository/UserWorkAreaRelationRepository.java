package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.UserWorkAreaRelation;

public interface UserWorkAreaRelationRepository extends CrudRepository<UserWorkAreaRelation, Long>{

	List<UserWorkAreaRelation> findByUserId_id(Long id);
}
