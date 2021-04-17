package increpe.order.mgmt.service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import increpe.order.mgmt.model.Company;
import increpe.order.mgmt.model.CompanyUserRelation;
import increpe.order.mgmt.model.SellerBuyerRelation;
import increpe.order.mgmt.model.SalesPersonWorkAreaRelation;
import increpe.order.mgmt.repository.SellerBuyerRelationRepository;
import increpe.order.mgmt.repository.ExpensesSummary;
import increpe.order.mgmt.repository.SalesPersonWorkAreaRelationRepository;
import increpe.order.mgmt.security.dto.AddressDto;
import increpe.order.mgmt.security.dto.AddressTypeDto;
import increpe.order.mgmt.security.dto.AttendanceReportDto;
import increpe.order.mgmt.security.dto.AuthenticatedUserDto;
import increpe.order.mgmt.security.dto.CityDto;
import increpe.order.mgmt.security.dto.CompanyDto;
import increpe.order.mgmt.security.dto.CompanyTypeDto;
import increpe.order.mgmt.security.dto.CompanyTypeRelationDto;
import increpe.order.mgmt.security.dto.CompanyUserRelationDto;
import increpe.order.mgmt.security.dto.CustomerDto;
import increpe.order.mgmt.security.dto.EmailTypeDto;
import increpe.order.mgmt.security.dto.EmailsDto;
import increpe.order.mgmt.security.dto.ExpenseReportDto;
import increpe.order.mgmt.security.dto.PhoneTypeDto;
import increpe.order.mgmt.security.dto.PhonesDto;
import increpe.order.mgmt.security.dto.ProductMasterDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.RolesDto;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.dto.UserTypeDto;
import increpe.order.mgmt.security.mapper.UserMapper;
import increpe.order.mgmt.security.service.UserService;
import increpe.order.mgmt.security.utils.SecurityConstants;
import increpe.order.mgmt.sp.dto.ActivityDto;
import increpe.order.mgmt.sp.dto.AttendanceDto;
import increpe.order.mgmt.sp.dto.ExpensesDto;
import increpe.order.mgmt.sp.dto.TourDto;
import increpe.order.mgmt.sp.dto.VisitsDto;

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

	@Autowired
	AttendanceService attendanceService;

	@Autowired
	ActivityService activityService;

	@Autowired
	VisitsService visitService;

	@Autowired
	TourService tourService;

	public RegistrationResponse createNewCustomer(RegistrationRequest request) {

		Company customerId = registrationService.registerCustomer(request);

		SellerBuyerRelation relation = new SellerBuyerRelation();

		relation.setBuyerCompanyId(customerId);

		relation.setSellerCompanyId(SecurityConstants.getAuthenticatedCompany());

		relation.setStatus("ACTIVE");

		sellerBuyerRelationRepository.save(relation);

		return new RegistrationResponse("Customer Registered successfully!");
	}
	
	public RegistrationResponse importNewCustomerData(MultipartFile inputFile) {
		
		try {
			
			BufferedReader fileReader = new BufferedReader(new InputStreamReader(inputFile.getInputStream(), "UTF-8"));
			
			CSVParser csvParser = new CSVParser(fileReader,
		            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			
			for (Iterator<CSVRecord> iterator = csvRecords.iterator(); iterator.hasNext();) {
				
				CSVRecord record = (CSVRecord) iterator.next();
				
				System.out.println(record.toMap().toString());
				
				RegistrationRequest req = buildRequestObjectForImport(record);
				
				if(!Objects.isNull(req)) {
					createNewCustomer(req);	
				}
			}
			
		} catch (Exception e) {
			
			System.out.println("Exception Occured in Import: "+e);
		}
		
		return new RegistrationResponse("Customer data imported successfully!");
	}
	
	public RegistrationRequest buildRequestObjectForImport(CSVRecord record) {
		
		
		RegistrationRequest importRequest = new RegistrationRequest();
		
		CityDto cDto = new CityDto();
		cDto.setCityName(record.get("city"));
		
		AddressTypeDto adDto = new AddressTypeDto();
		adDto.setId(1L);
		
		AddressDto aDto = new AddressDto();
		aDto.setCity(cDto);
		aDto.setAddressType(adDto);
		aDto.setAddressLine1(record.get("address"));	
		aDto.setAddressLine2(record.get("pincode"));
		aDto.setAddressLine3(record.get("zone"));
		
		EmailTypeDto etDto = new EmailTypeDto();
		etDto.setEmailTypeName("OFFICE");
		
		EmailsDto eDto = new EmailsDto();
		eDto.setEmailId(record.get("email"));
		eDto.setEmailTypeId(etDto);
		eDto.setStatus("ACTIVE");
		
		PhoneTypeDto ptDto = new PhoneTypeDto();
		ptDto.setPhoneTypeName("OFFICE");
		
		PhonesDto pDto = new PhonesDto();
		pDto.setPhone(record.get("phone"));
		pDto.setPhoneTypeId(ptDto);
		pDto.setStatus("ACTIVE");
		
		UserTypeDto utDto = new UserTypeDto();
		utDto.setId(1L);
		
		RolesDto rDto = new RolesDto();
		rDto.setId(1L);
		
		String username = UUID.randomUUID().toString();
		String password = UUID.randomUUID().toString();
		
		AuthenticatedUserDto auDto = new AuthenticatedUserDto();
		auDto.setName(record.get("customerName"));
		auDto.setUserRole(rDto);
		auDto.setUserTypeId(utDto);
		auDto.setUsername(username);
		auDto.setPassword(password);
		
		CompanyDto coDto = new CompanyDto();
		coDto.setCompanyName(record.get("companyName"));
		if(record.get("gst") != "") coDto.setGstNumber(record.get("gst"));		
		
		CompanyTypeDto cotDto = new CompanyTypeDto();
		cotDto.setId(1L);
		
		CompanyTypeRelationDto ctrDto = new CompanyTypeRelationDto();
		ctrDto.setCompanyId(coDto);
		ctrDto.setCompanyTypeId(cotDto);
		ctrDto.setStatus("ACTIVE");
		
		importRequest.setAddressId(aDto);
		importRequest.setCompanyTypeRelationId(ctrDto);
		importRequest.setUserId(auDto);
		importRequest.setEmailId(eDto);
		importRequest.setPhoneId(pDto);
		
		return importRequest;
		
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
	
	public List<SalesPersonDto> getAllSalesPersonByCompanyId(Long id, Pageable pageable) {

		List<Long> userIdList = getAllUserIdByCompanyId(id, pageable);

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
	
	public List<Long> getAllUserIdByCompanyId(Long id, Pageable pageable) {

		List<CompanyUserRelationDto> relationList = relationService.getRelationByCompany(id, pageable);

		List<Long> userIdList = new ArrayList<>();

		for (Iterator<CompanyUserRelationDto> iterator = relationList.iterator(); iterator.hasNext();) {

			CompanyUserRelationDto companyUserRelationDto = (CompanyUserRelationDto) iterator.next();

			userIdList.add(companyUserRelationDto.getUserId().getId());
		}

		return userIdList;

	}
	
	public CustomerDto getSingleCustomer(Long customerId, Long traderId) {
		
		SellerBuyerRelation relation = sellerBuyerRelationRepository.findBySellerCompanyId_idAndBuyerCompanyId_id(traderId, customerId);
		
		return prepareSingleCustomerDtoForTrader(relation);
		
	}
	
	private CustomerDto prepareSingleCustomerDtoForTrader(SellerBuyerRelation relation) {
		
		CustomerDto cDto = new CustomerDto();
		
		CompanyDto customerCompany = companyService.convertToCompanyDto(relation.getBuyerCompanyId());
		
		CompanyUserRelationDto relDto = companyUserRelationService
				.getRelationByCompanyAndUserType(customerCompany.getId(), 1L);
		
		if (Objects.nonNull(relDto)) {
			
			cDto.setCompanyId(customerCompany);
			cDto.setUserId(relDto.getUserId());

			getIfExist(cDto);
		}
		
		return cDto;
	}

	public List<CustomerDto> getAllCustomersByCompany(Long id) {

		List<SellerBuyerRelation> relationList = sellerBuyerRelationRepository.findBySellerCompanyId_id(id);

		List<CustomerDto> customerCompanyList = new ArrayList<>();

		for (Iterator<SellerBuyerRelation> iterator = relationList.iterator(); iterator.hasNext();) {

			SellerBuyerRelation sellerBuyerRelation = (SellerBuyerRelation) iterator.next();
			
			customerCompanyList.add(prepareSingleCustomerDtoForTrader(sellerBuyerRelation));

//			CompanyDto customerCompany = companyService.convertToCompanyDto(sellerBuyerRelation.getBuyerCompanyId());
//
//			 CompanyUserRelationDto relDto = companyUserRelationService
//					.getRelationByCompanyAndUserType(customerCompany.getId(), 1L);
//
//			if (Objects.nonNull(relDto)) {
//				
//				CustomerDto cDto = new CustomerDto();
//
//				cDto.setCompanyId(customerCompany);
//				cDto.setUserId(relDto.getUserId());
//
//				getIfExist(cDto);
//
//				customerCompanyList.add(cDto);
//			}
		}

		return customerCompanyList;
	}
	
	public List<CustomerDto> getAllCustomersByCompany(Long id, Pageable pageable) {

		List<SellerBuyerRelation> relationList = sellerBuyerRelationRepository.findBySellerCompanyId_id(id, pageable);

		List<CustomerDto> customerCompanyList = new ArrayList<>();

		for (Iterator<SellerBuyerRelation> iterator = relationList.iterator(); iterator.hasNext();) {

			SellerBuyerRelation sellerBuyerRelation = (SellerBuyerRelation) iterator.next();

			CompanyDto customerCompany = companyService.convertToCompanyDto(sellerBuyerRelation.getBuyerCompanyId());

			 CompanyUserRelationDto relDto = companyUserRelationService
					.getRelationByCompanyAndUserType(customerCompany.getId(), 1L);

			if (Objects.nonNull(relDto)) {
				
				CustomerDto cDto = new CustomerDto();

				cDto.setCompanyId(customerCompany);
				cDto.setUserId(relDto.getUserId());

				getIfExist(cDto);

				customerCompanyList.add(cDto);
			}
		}

		return customerCompanyList;
	}

	public List<ExpenseReportDto> getExpenseReportByCompanyId(Long companyId) {

		List<ExpenseReportDto> reportList = new ArrayList<>();

		List<SalesPersonDto> salesPersonList = getAllSalesPersonByCompanyId(companyId);

		for (Iterator<SalesPersonDto> iterator = salesPersonList.iterator(); iterator.hasNext();) {

			SalesPersonDto salesPersonDto = (SalesPersonDto) iterator.next();

			List<ExpensesSummary> summaryList = expenseService.getExpenseSummary(salesPersonDto.getId());

			if (summaryList.size() > 0) {

				summaryList.forEach((element) -> {
					reportList.add(
							new ExpenseReportDto(salesPersonDto, element.getMonthYear(), element.getMonthlySummary()));
				});
			}
		}

		return reportList;
	}

	public List<AttendanceReportDto> getAttendanceReportForCompanyByMonthYear(Long companyId, String monthYear) {

		List<SalesPersonDto> salesPersonList = getAllSalesPersonByCompanyId(companyId);

		List<AttendanceReportDto> reportList = new ArrayList<>();

		for (Iterator<SalesPersonDto> iterator = salesPersonList.iterator(); iterator.hasNext();) {

			SalesPersonDto salesPersonDto = (SalesPersonDto) iterator.next();

			List<AttendanceDto> attendanceList = attendanceService.getAttendanceByMonth(monthYear,
					salesPersonDto.getId());

			if (attendanceList.size() > 0) {
				reportList.add(new AttendanceReportDto(salesPersonDto, attendanceList));
			}
		}

		return reportList;
	}

	public List<AttendanceDto> getDailyAttendanceByCompanyId(Long companyId, String date) {

		List<SalesPersonDto> salesPersonList = getAllSalesPersonByCompanyId(companyId);

		List<AttendanceDto> dailyAttendanceList = new ArrayList<>();

		for (Iterator<SalesPersonDto> iterator = salesPersonList.iterator(); iterator.hasNext();) {

			SalesPersonDto salesPersonDto = (SalesPersonDto) iterator.next();

			AttendanceDto dto = attendanceService.getDailyAttendanceBySalesPerson(date, salesPersonDto.getId());

			if (Objects.nonNull(dto)) {
				dailyAttendanceList.add(dto);
			}
		}

		return dailyAttendanceList;
	}

	public List<ActivityDto> getActivityReports(Long companyId) {

		List<SalesPersonDto> salesPersonList = getAllSalesPersonByCompanyId(companyId);

		List<ActivityDto> activityReportList = new ArrayList<>();

		for (Iterator<SalesPersonDto> iterator = salesPersonList.iterator(); iterator.hasNext();) {

			SalesPersonDto salesPersonDto = (SalesPersonDto) iterator.next();

			List<ActivityDto> dtoList = activityService.getAllActivitiesForSalesPerson(salesPersonDto.getId());

			if (dtoList.size() > 0) {
				activityReportList.addAll(dtoList);
			}
		}

		return activityReportList;

	}

	public List<VisitsDto> getVisitReports(Long companyId) {

		List<SalesPersonDto> salesPersonList = getAllSalesPersonByCompanyId(companyId);

		List<VisitsDto> visitReportList = new ArrayList<>();

		for (Iterator<SalesPersonDto> iterator = salesPersonList.iterator(); iterator.hasNext();) {

			SalesPersonDto salesPersonDto = (SalesPersonDto) iterator.next();

			List<VisitsDto> dtoList = visitService.getAllVisitsForSalesPerson(salesPersonDto.getId());

			if (dtoList.size() > 0) {
				visitReportList.addAll(dtoList);
			}
		}

		return visitReportList;

	}

	public List<TourDto> getTourReports(Long companyId) {

		List<SalesPersonDto> salesPersonList = getAllSalesPersonByCompanyId(companyId);

		List<TourDto> tourReportList = new ArrayList<>();

		for (Iterator<SalesPersonDto> iterator = salesPersonList.iterator(); iterator.hasNext();) {

			SalesPersonDto salesPersonDto = (SalesPersonDto) iterator.next();

			List<TourDto> dtoList = tourService.getTourListBySalesPersonId(salesPersonDto.getId());

			if (dtoList.size() > 0) {
				tourReportList.addAll(dtoList);
			}
		}

		return tourReportList;

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
