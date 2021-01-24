package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.UserType;

public interface UserTypeRepository extends CrudRepository<UserType, Long> {
	
	UserType findByUserTypeName(String userTypeName);

	List<UserType> findByStatus(String status);

	boolean existsByUserTypeName(String userTypeName);

}
