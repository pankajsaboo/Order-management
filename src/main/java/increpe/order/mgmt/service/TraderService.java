package increpe.order.mgmt.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.CompanyUserRelation;
import increpe.order.mgmt.model.SellerBuyerRelation;
import increpe.order.mgmt.model.SalesPersonWorkAreaRelation;
import increpe.order.mgmt.repository.SellerBuyerRelationRepository;
import increpe.order.mgmt.repository.ExpensesSummary;
import increpe.order.mgmt.repository.SalesPersonWorkAreaRelationRepository;
import increpe.order.mgmt.security.dto.AddressDto;
import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.dto.CompanyDto;
import increpe.order.mgmt.security.dto.CompanyTypeRelationDto;
import increpe.order.mgmt.security.dto.CompanyUserRelationDto;
import increpe.order.mgmt.security.dto.CustomerDto;
import increpe.order.mgmt.security.dto.EmailsDto;
import increpe.order.mgmt.security.dto.ExpenseReportDto;
import increpe.order.mgmt.security.dto.PhonesDto;
import increpe.order.mgmt.security.dto.ProductMasterDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.mapper.UserMapper;
import increpe.order.mgmt.security.service.UserService;
import increpe.order.mgmt.security.utils.SecurityConstants;
import increpe.order.mgmt.sp.dto.ExpensesDto;

@Service
public class TraderService {

	@Autowired
	RegistrationService registrationService;

	@Autowired
	CompanyUserRelationService relationService;

	@Autowired
	CompanyService companyService;

	@Autowired
	SalesPersonService salesPersonService;

	@Autowired
	AddressService addressService;

	@Autowired
	EmailService emailService;

	@Autowired
	PhoneService phoneService;

	@Autowired
	UserService userService;

	@Autowired
	ProductService productService;

	@Autowired
	SellerBuyerRelationRepository sellerBuyerRelationRepository;

	@Autowired
	CompanyUserRelationService companyUserRelationService;
	
	@Autowired
	ExpensesService expenseService;

	public RegistrationResponse createNewCustomer(RegistrationRequest request) {

		Company customerId = registrationService.registerCustomer(request);

		SellerBuyerRelation relation = new SellerBuyerRelation();

		relation.setBuyerCompanyId(customerId);

		relation.setSellerCompanyId(SecurityConstants.getAuthenticatedCompany());

		relation.setStatus("ACTIVE");

		sellerBuyerRelationRepository.save(relation);

		return new RegistrationResponse("Customer Registered successfully!");
	}

	public RegistrationResponse createNewProduct(ProductMasterDto productDto) {

		ProductMasterDto dto = productService.createProduct(productDto);

		if (!Objects.isNull(dto.getId())) {
			return new RegistrationResponse("Product Added successfully!");
		}

		return new RegistrationResponse("Something went wrong!");
	}

	public RegistrationResponse updateProduct(ProductMasterDto productDto) {

		ProductMasterDto dto = productService.createProduct(productDto);

		if (!Objects.isNull(dto.getId())) {
			return new RegistrationResponse("Product Updated successfully!");
		}

		return new RegistrationResponse("Something went wrong!");
	}

	public List<SalesPersonDto> getAllSalesPersonByCompanyId(Long id) {
		
		List<Long> userIdList = getAllUserIdByCompanyId(id);

		List<SalesPersonDto> salesPersonDtoList = salesPersonService.getAllByCompany(userIdList);

		for (Iterator<SalesPersonDto> iterator = salesPersonDtoList.iterator(); iterator.hasNext();) {

			SalesPersonDto salesPersonDto = (SalesPersonDto) iterator.next();
			salesPersonService.getIfExists(salesPersonDto);
		}

		return salesPersonDtoList;
	}

	public List<Long> getAllUserIdByCompanyId(Long id) {

		List<CompanyUserRelationDto> relationList = relationService.getRelationByCompany(id);

		List<Long> userIdList = new ArrayList<>();

		for (Iterator<CompanyUserRelationDto> iterator = relationList.iterator(); iterator.hasNext();) {

			CompanyUserRelationDto companyUserRelationDto = (CompanyUserRelationDto) iterator.next();

			userIdList.add(companyUserRelationDto.getUserId().getId());
		}
		
		return userIdList;

	}

	public List<CustomerDto> getAllCustomersByCompany(Long id) {

		List<SellerBuyerRelation> relationList = sellerBuyerRelationRepository.findBySellerCompanyId_id(id);

		List<CustomerDto> customerCompanyList = new ArrayList<>();

		for (Iterator<SellerBuyerRelation> iterator = relationList.iterator(); iterator.hasNext();) {

			SellerBuyerRelation sellerBuyerRelation = (SellerBuyerRelation) iterator.next();

			CompanyDto customerCompany = companyService.convertToCompanyDto(sellerBuyerRelation.getBuyerCompanyId());

			AuthenticatedUserDto customerAdmin = companyUserRelationService
					.getRelationByCompanyAndUserType(customerCompany.getId(), 2L).getUserId();

			CustomerDto cDto = new CustomerDto();

			cDto.setCompanyId(customerCompany);
			cDto.setUserId(customerAdmin);

			getIfExist(cDto);

			customerCompanyList.add(cDto);
		}

		return customerCompanyList;
	}
	
	public List<ExpenseReportDto> getExpenseReportByCompanyId(Long companyId) {
		
		List<ExpenseReportDto> reportList = new ArrayList<>();
		
		List<SalesPersonDto> salesPersonList = getAllSalesPersonByCompanyId(companyId);
		
		for (Iterator<SalesPersonDto> iterator = salesPersonList.iterator(); iterator.hasNext();) {
			
			SalesPersonDto salesPersonDto = (SalesPersonDto) iterator.next();
			
			List<ExpensesSummary> summaryList = expenseService.getExpenseSummary(salesPersonDto.getId());
			
			if(summaryList.size() > 0) {
				
				summaryList.forEach((element) ->{
					reportList.add(new ExpenseReportDto(salesPersonDto, element.getMonthYear(), element.getMonthlySummary()));
				});
			}
		}
		
		return reportList;
	}

	private void getIfExist(CustomerDto customerDto) {

		Long userId = customerDto.getUserId().getId();

		PhonesDto pDto = phoneService.getPhoneByUserId(userId);

		EmailsDto eDto = emailService.getEmailByUserId(userId);

		AddressDto aDto = addressService.getAddressByUserId(userId);

		if (!Objects.isNull(pDto)) {
			customerDto.setPhoneId(pDto);
		}

		if (!Objects.isNull(eDto)) {
			customerDto.setEmailId(eDto);
		}

		if (!Objects.isNull(aDto)) {
			customerDto.setAddressId(aDto);
		}
	}

}
