package increpe.order.mgmt.repository;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.Phone;

public interface PhoneRepository extends CrudRepository<Phone, Long> {

	Phone findByUserId_id(Long id);
}
