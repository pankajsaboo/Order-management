package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import increpe.order.mgmt.model.SellerBuyerRelation;

public interface SellerBuyerRelationRepository extends CrudRepository<SellerBuyerRelation, Long>{

	List<SellerBuyerRelation> findBySellerCompanyId_id(Long sellerCompanyId);
}
