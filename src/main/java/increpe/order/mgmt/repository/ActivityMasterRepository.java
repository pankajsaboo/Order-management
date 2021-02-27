package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.ActivityMaster;

public interface ActivityMasterRepository extends CrudRepository<ActivityMaster, Long> {

	List<ActivityMaster> findByCompanyId_id(Long companyId);
}
