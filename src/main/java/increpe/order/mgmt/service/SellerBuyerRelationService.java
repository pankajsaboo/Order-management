package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.repository.SellerBuyerRelationRepository;
import increpe.order.mgmt.security.dto.CompanyDto;

@Service
public class SellerBuyerRelationService {
	
	@Autowired
	SellerBuyerRelationRepository sellerBuyerRelationRepository;
	
	@Autowired
	CompanyService companyService;
	

}
