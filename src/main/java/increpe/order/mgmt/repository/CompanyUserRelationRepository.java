package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.CompanyUserRelation;
import increpe.order.mgmt.model.User;

public interface CompanyUserRelationRepository extends CrudRepository<CompanyUserRelation, Long> {
	
	List<CompanyUserRelation> findByCompanyId_id(Long id);
	
	CompanyUserRelation findByUserId_id(Long id);
	
	CompanyUserRelation findByCompanyId_idAndUserId_UserTypeId_id(Long companyId, Long userTypeId);

}
