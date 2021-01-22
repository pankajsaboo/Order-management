package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.security.dto.TraderDto;
import design.boilerplate.springboot.security.mapper.CompanyMapper;

@Service
public class SuperAdminServiceImpl implements SuperAdminService {
	
	@Autowired
	CompanyService companyService;

	@Override
	public String createNewTraderAccount(TraderDto traderDto) {
		
		//Company company = CompanyMapper.INSTANCE.ConvertToCompany(traderDto);
		
		
		return null;
	}

	@Override
	public List<TraderDto> findAllTraders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateTraderAccount(TraderDto traderDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeTraderAccount(Long traderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
