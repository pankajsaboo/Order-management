package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Emails;

public interface EmailsRepository extends CrudRepository<Emails, Long> {
	
	boolean existsByEmailId(String emailId);
	
	Emails findByUserId_id(Long userId);

}
