package design.boilerplate.springboot.repository;

import org.springframework.data.repository.CrudRepository;

import design.boilerplate.springboot.model.SellerBuyerRelation;

public interface SellerBuyerRelationRepository extends CrudRepository<SellerBuyerRelation, Long>{

}
