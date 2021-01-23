package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.security.dto.TraderDto;

@Service
public class SuperAdminService {
	
	@Autowired
	CompanyService companyService;

	
	public String createNewTraderAccount(TraderDto traderDto) {
		
		//Company company = CompanyMapper.INSTANCE.ConvertToCompany(traderDto);
		
		
		return null;
	}

	
	public List<TraderDto> findAllTraders() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String updateTraderAccount(TraderDto traderDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public String removeTraderAccount(Long traderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
