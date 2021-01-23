package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.UserWorkAreaRelation;
import increpe.order.mgmt.repository.UserWorkAreaRelationRepository;
import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.dto.CompanyUserRelationDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.mapper.UserMapper;
import increpe.order.mgmt.security.service.UserService;

@Service
public class TraderService {
	
	@Autowired
	AddressService addressService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	CompanyService companyService;
	
	@Autowired
	PhoneService phoneService;
	
	@Autowired 
	RegistrationService registrationService;
	
	@Autowired
	CompanyUserRelationService relationService;
	
	@Autowired
	UserWorkAreaRelationRepository mappingRelationRepository;
	
	
	public RegistrationResponse createNewSalesPersonAccount(RegistrationRequest registrationRequest) {
		
		return registrationService.registerSalesPerson(registrationRequest);
	}

	
	public List<CompanyUserRelationDto> getAllSalesPersonAccountList(Long id) {
		
		return relationService.getRelationByCompany(id);
	}

	
	public SalesPersonDto updateSalesPersonDatails(SalesPersonDto salesPersonDto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public boolean deleteSalesPersonAccount(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public AuthenticatedUserDto convertSalesPersonDtoToAuthenticatedUserDto(SalesPersonDto salesPersonDto) {
		
		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(salesPersonDto);
	}

	
	public List<UserWorkAreaRelation> getMapping(Long id) {
		
		return mappingRelationRepository.findByUserId_id(id);
	}

}
