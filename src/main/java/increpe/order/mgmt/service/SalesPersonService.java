package increpe.order.mgmt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.model.SalesPersonWorkAreaRelation;
import increpe.order.mgmt.model.WorkAreaMaster;
import increpe.order.mgmt.repository.SalesPersonRepository;
import increpe.order.mgmt.repository.SalesPersonWorkAreaRelationRepository;
import increpe.order.mgmt.security.dto.AddressDto;
import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.dto.CompanyDto;
import increpe.order.mgmt.security.dto.CompanyTypeRelationDto;
import increpe.order.mgmt.security.dto.CustomerDto;
import increpe.order.mgmt.security.dto.EmailsDto;
import increpe.order.mgmt.security.dto.PhonesDto;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.dto.WorkAreaMasterDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.security.service.UserService;
import increpe.order.mgmt.security.utils.SecurityConstants;

@Service
public class SalesPersonService {

	@Autowired
	SalesPersonRepository salesPersonRepository;

	@Autowired
	SalesPersonWorkAreaRelationRepository relationRepository;
	
	@Autowired
	CompanyUserRelationService companyUserRelationService;

	@Autowired
	UserService userService;

	@Autowired
	AddressService addressService;

	@Autowired
	EmailService emailService;

	@Autowired
	PhoneService phoneService;

	@Autowired
	CompanyService companyService;
	
	@Autowired
	TraderService traderService;

	public SalesPerson creatSalesPersonAccount(SalesPersonDto salesPersonDto) {

		SalesPerson salesPerson = CompanyMapper.INSTANCE.convertToSalesPerson(salesPersonDto);

		return salesPersonRepository.save(salesPerson);
	}

	public void mapWorkAreaToSalesPerson(List<WorkAreaMasterDto> workAreaMasterDtoList, SalesPerson salePerson) {

		List<WorkAreaMaster> masterList = CompanyMapper.INSTANCE.convertToWorkAreaMasterList(workAreaMasterDtoList);

		for (Iterator<WorkAreaMaster> iterator = masterList.iterator(); iterator.hasNext();) {
			WorkAreaMaster workAreaMaster = (WorkAreaMaster) iterator.next();

			SalesPersonWorkAreaRelation relation = new SalesPersonWorkAreaRelation();

			relation.setSalesPersonId(salePerson);

			relation.setWorkAreaMasterId(workAreaMaster);

			relationRepository.save(relation);
		}
	}

	public SalesPersonDto getSalesPersonByUserId(Long id) {

		List<SalesPersonWorkAreaRelation> relationList = relationRepository.findBySalesPersonId_UserId_id(id);

		SalesPerson salesPerson = new SalesPerson();
		
		SalesPersonDto spDto = new SalesPersonDto();

		if (relationList.isEmpty()) {
			
			salesPerson = salesPersonRepository.findByUserId_id(id);
			spDto = CompanyMapper.INSTANCE.convertToSalesPersonDto(salesPerson);
			
		} else {

			salesPerson = relationList.get(0).getSalesPersonId();

			List<WorkAreaMaster> workAreaList = new ArrayList<>();

			for (Iterator<SalesPersonWorkAreaRelation> iterator = relationList.iterator(); iterator.hasNext();) {

				SalesPersonWorkAreaRelation salesPersonWorkAreaRelation = (SalesPersonWorkAreaRelation) iterator.next();

				workAreaList.add(salesPersonWorkAreaRelation.getWorkAreaMasterId());
			}

			spDto = CompanyMapper.INSTANCE.convertToSalesPersonDto(salesPerson);

			List<WorkAreaMasterDto> workAreaDtoList = CompanyMapper.INSTANCE
					.convertToWorkAreaMasterDtoList(workAreaList);

			spDto.setWorkAreaMasterList(workAreaDtoList);
		}

		getIfExists(spDto);

		return spDto;

	}
	
	public CustomerDto getCustomerDetailsForSalesPerson(Long customerId) {
		
		CompanyDto customerCompany = companyService.convertToCompanyDto(companyService.getCompany(customerId));
		
		AuthenticatedUserDto customerAdmin = companyUserRelationService
				.getRelationByCompanyAndUserType(customerId, 2L).getUserId();
		
		PhonesDto pDto = phoneService.getPhoneByUserId(customerAdmin.getId());

		EmailsDto eDto = emailService.getEmailByUserId(customerAdmin.getId());

		AddressDto aDto = addressService.getAddressByUserId(customerAdmin.getId());
		
		CustomerDto customerDto = new CustomerDto();
		
		customerDto.setCompanyId(customerCompany);
		
		if (!Objects.isNull(pDto)) {
			customerDto.setPhoneId(pDto);
		}

		if (!Objects.isNull(eDto)) {
			customerDto.setEmailId(eDto);
		}

		if (!Objects.isNull(aDto)) {
			customerDto.setAddressId(aDto);
		}
		
		return customerDto;
	}

	public List<SalesPersonDto> getAllByCompany(List<Long> userIdList) {

		List<SalesPersonWorkAreaRelation> relationList = relationRepository.findBySalesPersonId_UserId_idIn(userIdList);

		List<SalesPersonDto> salesPersonDtoList = new ArrayList<>();

		for (Iterator<SalesPersonWorkAreaRelation> iterator = relationList.iterator(); iterator.hasNext();) {

			SalesPersonWorkAreaRelation salesPersonWorkAreaRelation = (SalesPersonWorkAreaRelation) iterator.next();

			SalesPersonDto dto = getSalesPersonByUserId(salesPersonWorkAreaRelation.getSalesPersonId().getUserId().getId());

			salesPersonDtoList.add(dto);
		}

		TreeSet<SalesPersonDto> filteredDtoList = salesPersonDtoList.stream().collect(Collectors
				.toCollection(() -> new TreeSet<SalesPersonDto>((sp1, sp2) -> sp1.getId().compareTo(sp2.getId()))));

		return new ArrayList<>(filteredDtoList);
	}

	public void getIfExists(SalesPersonDto salesPersonDto) {

		CompanyTypeRelationDto relationsDto = new CompanyTypeRelationDto();

		Company c = SecurityConstants.getAuthenticatedCompany();

		relationsDto.setCompanyId(companyService.convertToCompanyDto(c));

		Long userId = salesPersonDto.getUserId().getId();

		PhonesDto pDto = phoneService.getPhoneByUserId(userId);

		EmailsDto eDto = emailService.getEmailByUserId(userId);

		AddressDto aDto = addressService.getAddressByUserId(userId);

		if (!Objects.isNull(pDto)) {
			salesPersonDto.setPhoneId(pDto);
		}

		if (!Objects.isNull(eDto)) {
			salesPersonDto.setEmailId(eDto);
		}

		if (!Objects.isNull(aDto)) {
			salesPersonDto.setAddressId(aDto);
		}

		salesPersonDto.setCompanyTypeRelationId(relationsDto);
	}

	@Transactional
	public RegistrationResponse updateSalesPersonData(SalesPersonDto salesPersonDto, boolean isTrader) {

		AuthenticatedUserDto userDto = userService.updateUserData(salesPersonDto.getUserId());

		salesPersonDto.setUserId(userDto);

		if (!Objects.isNull(salesPersonDto.getAddressId())) {

			AddressDto aDto = salesPersonDto.getAddressId();
			aDto.setUserId(userDto);

			addressService.updateAddress(aDto);
		}

		if (!Objects.isNull(salesPersonDto.getEmailId())) {

			EmailsDto eDto = salesPersonDto.getEmailId();
			eDto.setUserId(userDto);

			emailService.updateEmail(eDto);
		}

		if (!Objects.isNull(salesPersonDto.getPhoneId())) {

			PhonesDto pDto = salesPersonDto.getPhoneId();
			pDto.setUserId(userDto);

			phoneService.updatePhone(pDto);
		}

		// Optimization required here...

		if(isTrader) {
			SalesPerson salesPerson = CompanyMapper.INSTANCE.convertToSalesPerson(salesPersonDto);

			deleteSalesPerSonWorkAreaMappings(salesPerson);

			mapWorkAreaToSalesPerson(salesPersonDto.getWorkAreaMasterList(), salesPerson);
		}

		return new RegistrationResponse("Sales Person Data updated successfully!");
	}

	public void deleteSalesPerSonWorkAreaMappings(SalesPerson salesPerson) {
		relationRepository.deleteBySalesPersonId(salesPerson);
	}

}
