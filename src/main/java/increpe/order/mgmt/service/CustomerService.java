package increpe.order.mgmt.service;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.CustomerSalesPersonRelation;
import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.repository.CustomerSalesPersonRelationRepository;
import increpe.order.mgmt.security.dto.AddressDto;
import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.dto.CompanyDto;
import increpe.order.mgmt.security.dto.CustomerDto;
import increpe.order.mgmt.security.dto.CustomerSalesPersonRelationDto;
import increpe.order.mgmt.security.dto.EmailsDto;
import increpe.order.mgmt.security.dto.PhonesDto;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.mapper.CompanyMapper;
import increpe.order.mgmt.security.service.UserService;

@Service
public class CustomerService {

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
	CustomerSalesPersonRelationRepository relationRepository;

	@Transactional
	public RegistrationResponse updateCustomerData(CustomerDto customerDto) {

		AuthenticatedUserDto userDto = userService.updateUserData(customerDto.getUserId());

		companyService.updateCompany(customerDto.getCompanyId());

		customerDto.setUserId(userDto);

		if (!Objects.isNull(customerDto.getAddressId())) {

			AddressDto aDto = customerDto.getAddressId();
			aDto.setUserId(userDto);

			addressService.updateAddress(aDto);
		}

		if (!Objects.isNull(customerDto.getEmailId())) {

			EmailsDto eDto = customerDto.getEmailId();
			eDto.setUserId(userDto);

			emailService.updateEmail(eDto);
		}

		if (!Objects.isNull(customerDto.getPhoneId())) {

			PhonesDto pDto = customerDto.getPhoneId();
			pDto.setUserId(userDto);

			phoneService.updatePhone(pDto);
		}

		return new RegistrationResponse("Customer Data updated successfully!");
	}

	public RegistrationResponse mapSalesPersonsToCustomer(List<CustomerSalesPersonRelationDto> relationDtoList) {

		List<CustomerSalesPersonRelation> relationList = CompanyMapper.INSTANCE
				.convertToCustomerSalesPersonRelationList(relationDtoList);

		relationRepository.saveAll(relationList);

		return new RegistrationResponse("Sales person(s) mapped successfully to customers!");
	}

	public List<CustomerSalesPersonRelationDto> getAllBySalesPerson(Long salesPersonId) {

		return CompanyMapper.INSTANCE
				.convertToCustomerSalesPersonRelationDtoList(relationRepository.findBySalesPersonId_id(salesPersonId));
	}

	public List<CustomerSalesPersonRelationDto> getAllByCustomerCompany(Long customerCompanyId) {

		return CompanyMapper.INSTANCE
				.convertToCustomerSalesPersonRelationDtoList(
						relationRepository.findByCustomerCompanyId_idAndStatus(customerCompanyId,"ACTIVE"));
	}
	
	@Transactional
	public RegistrationResponse updateRelationForCustomer(List<CustomerSalesPersonRelationDto> relationDtoList) {
		
		//CompanyDto customerDto = relationDtoList.get(0).getCustomerCompanyId();
		
		//Company customerCompanyId = companyService.convertToCompany(customerDto);
		
		//relationRepository.deleteByCustomerCompanyId(customerCompanyId);
		
		mapSalesPersonsToCustomer(relationDtoList);
		
		return new RegistrationResponse("Updated successfully!");
	}

}
