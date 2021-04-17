package increpe.order.mgmt.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import increpe.order.mgmt.model.SellerBuyerRelation;

public interface SellerBuyerRelationRepository extends PagingAndSortingRepository<SellerBuyerRelation, Long>{

	List<SellerBuyerRelation> findBySellerCompanyId_id(Long sellerCompanyId);
	
	List<SellerBuyerRelation> findBySellerCompanyId_id(Long sellerCompanyId, Pageable pageable);
	
	SellerBuyerRelation findBySellerCompanyId_idAndBuyerCompanyId_id(Long sellerCompanyId, Long buyerCompanyId);
}
