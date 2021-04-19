package increpe.order.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.repository.WorkAreaMasterRepository;
import increpe.order.mgmt.security.dto.AttendanceReportDto;
import increpe.order.mgmt.security.dto.CompanyProductDto;
import increpe.order.mgmt.security.dto.CustomerDto;
import increpe.order.mgmt.security.dto.CustomerSalesPersonRelationDto;
import increpe.order.mgmt.security.dto.ExpenseReportDto;
import increpe.order.mgmt.security.dto.HolidayMasterDto;
import increpe.order.mgmt.security.dto.ProductMasterDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.RequestObject;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.dto.WorkAreaMasterDto;
import increpe.order.mgmt.service.ActivityService;
import increpe.order.mgmt.service.AttendanceService;
import increpe.order.mgmt.service.CompanyProductRelationService;
import increpe.order.mgmt.service.CustomerService;
import increpe.order.mgmt.service.ExpensesService;
import increpe.order.mgmt.service.ProductService;
import increpe.order.mgmt.service.RegistrationService;
import increpe.order.mgmt.service.SalesPersonService;
import increpe.order.mgmt.service.TraderService;
import increpe.order.mgmt.service.WorkAreaMasterService;
import increpe.order.mgmt.sp.dto.ActivityDto;
import increpe.order.mgmt.sp.dto.ActivityMasterDto;
import increpe.order.mgmt.sp.dto.AttendanceDto;
import increpe.order.mgmt.sp.dto.ExpensesDto;
import increpe.order.mgmt.sp.dto.TourDto;
import increpe.order.mgmt.sp.dto.VisitsDto;

@CrossOrigin
@RestController
@RequestMapping("/trader")
public class TraderController {

	@Autowired
	TraderService traderService;

	@Autowired
	WorkAreaMasterService masterService;

	@Autowired
	ProductService productService;

	@Autowired
	RegistrationService registrationService;

	@Autowired
	CompanyProductRelationService companyProductService;

	@Autowired
	SalesPersonService salesPersonService;

	@Autowired
	CustomerService customerService;

	@Autowired
	ActivityService activityService;

	@Autowired
	ExpensesService expenseService;

	@Autowired
	AttendanceService attendanceService;

	@Autowired
	WorkAreaMasterService workMasterService;

	@PostMapping("/employee/add")
	public ResponseEntity<RegistrationResponse> addNewSalesPersonAccont(@RequestBody SalesPersonDto request) {

		return ResponseEntity.ok(registrationService.registerSalesPerson(request));
	}

	@PostMapping("/employee")
	public ResponseEntity<List<SalesPersonDto>> getSalesPersonAccount(@RequestBody RequestObject req) {

		return ResponseEntity.ok(traderService.getAllSalesPersonByCompanyId(req.getId()));
	}

	@DeleteMapping("/employee/delete")
	public ResponseEntity<String> deleteEmployee(@RequestBody SalesPerson salesPerson) {

		return ResponseEntity.ok("Method not implemented!");
	}

	@PutMapping("/employee/update")
	public ResponseEntity<RegistrationResponse> updateSalesPersonAccount(@RequestBody SalesPersonDto request) {

		return ResponseEntity.ok(salesPersonService.updateSalesPersonData(request, true));
	}

	@PostMapping("/product/add")
	public ResponseEntity<RegistrationResponse> addNewProduct(@RequestBody ProductMasterDto productDto) {

		return ResponseEntity.ok(traderService.createNewProduct(productDto));
	}

	@PostMapping("/product")
	public ResponseEntity<List<ProductMasterDto>> getAllProducts(@RequestBody RequestObject req) {

		return ResponseEntity.ok(productService.getAllProducts(req.getId()));
	}
	
	@GetMapping("/product/single")
	public ResponseEntity<ProductMasterDto> getSingleProduct(@RequestParam Long pId, @RequestParam Long cId) {

		return ResponseEntity.ok(productService.getSingleProduct(pId, cId));
	}
	
	

	@PutMapping("/product/update")
	public ResponseEntity<RegistrationResponse> updateProduct(@RequestBody ProductMasterDto productDto) {

		return ResponseEntity.ok(traderService.updateProduct(productDto));
	}

	@PostMapping("/customer/add")
	public ResponseEntity<RegistrationResponse> addNewCustomer(@RequestBody RegistrationRequest request) {

		return ResponseEntity.ok(traderService.createNewCustomer(request));
	}

	@PostMapping("/customer/import")
	public ResponseEntity<RegistrationResponse> importNewCustomerData(@RequestBody MultipartFile cutomerData) {

		return ResponseEntity.ok(traderService.importNewCustomerData(cutomerData));
	}

//	@PostMapping("/customer")
//	public ResponseEntity<List<CustomerDto>> getAllCustomers(@RequestBody RequestObject reqObj) {
//
//		Pageable page = PageRequest.of(reqObj.getPageBegin(), reqObj.getPageLength());
//
////		if(reqObj.getSortBy() != null) {
////			page = reqObj.getDir() == "asc" ? PageRequest.of(reqObj.getPageBegin(), reqObj.getPageLength(), ) 
////		}
//
//		return ResponseEntity.ok(traderService.getAllCustomersByCompany(reqObj.getId(), page));
//	}

	@GetMapping("/customer")
	public ResponseEntity<List<CustomerDto>> getAllCustomers(@RequestParam Long id) {

		return ResponseEntity.ok(traderService.getAllCustomersByCompany(id));
	}

	@GetMapping("/customer/single")
	public ResponseEntity<CustomerDto> getSingleCustomer(@RequestParam Long sId, @RequestParam Long bId) {

		return ResponseEntity.ok(traderService.getSingleCustomer(bId, sId));
	}

	@PutMapping("/customer/update")
	public ResponseEntity<RegistrationResponse> updateCustomer(@RequestBody CustomerDto customerDto) {

		return ResponseEntity.ok(customerService.updateCustomerData(customerDto));
	}

	@PostMapping("/customer/products/add")
	public ResponseEntity<RegistrationResponse> addProductsToCustomers(
			@RequestBody List<CompanyProductDto> cProductDtoList) {

		return ResponseEntity.ok(companyProductService.createRelation(cProductDtoList));
	}

	@GetMapping("/customer/products")
	public ResponseEntity<List<CompanyProductDto>> getCompanyProductListByCompanyId(@RequestParam Long id) {

		return ResponseEntity.ok(companyProductService.getByCompanyId(id));
	}

	@PostMapping("/customer/product/add")
	public ResponseEntity<RegistrationResponse> addProductToCustomer(@RequestBody CompanyProductDto cProductDto) {

		return ResponseEntity.ok(companyProductService.createRelation(cProductDto));
	}

	@GetMapping("/customer/product")
	public ResponseEntity<List<CompanyProductDto>> getCompanyProductListByBuyerId(@RequestParam Long id) {

		return ResponseEntity.ok(companyProductService.getByBuyerCompanyId(id));
	}

	@PutMapping("/customer/product/update")
	public ResponseEntity<RegistrationResponse> updateCustomerProduct(@RequestBody CompanyProductDto cProductDto) {

		return ResponseEntity.ok(companyProductService.updateCompanyProductRelation(cProductDto));
	}

	@DeleteMapping("/customer/product/delete")
	public ResponseEntity<Boolean> deleteRelation(@RequestParam Long id) {
		return ResponseEntity.ok(companyProductService.deleteCompanyProductRelation(id));
	}

	@PostMapping("/customer/sp/add")
	public ResponseEntity<RegistrationResponse> addCustomerToSalesPerson(
			@RequestBody List<CustomerSalesPersonRelationDto> relationList) {

		return ResponseEntity.ok(customerService.mapSalesPersonsToCustomer(relationList));
	}

	@PutMapping("/customer/sp/update")
	public ResponseEntity<RegistrationResponse> updateCustomerSalesPersonMapping(
			@RequestBody List<CustomerSalesPersonRelationDto> relationList) {

		return ResponseEntity.ok(customerService.updateRelationForCustomer(relationList));
	}

	@GetMapping("/sales-person/sp")
	public ResponseEntity<List<CustomerSalesPersonRelationDto>> getCustomerSalesPersonRelationListBySalesPersonId(
			@RequestParam Long id) {

		return ResponseEntity.ok(customerService.getAllBySalesPerson(id));
	}

	@GetMapping("/customer/sp")
	public ResponseEntity<List<CustomerSalesPersonRelationDto>> getCustomerSalesPersonRelationListByCustomerId(
			@RequestParam Long id) {

		return ResponseEntity.ok(customerService.getAllByCustomerCompany(id));
	}

	@PostMapping("/masters/add")
	public ResponseEntity<WorkAreaMasterDto> addNewWorkAreaMasters(@RequestBody WorkAreaMasterDto listDto) {

		return ResponseEntity.ok(masterService.createWorkAreaMaster(listDto));
	}

	@GetMapping("/masters")
	public ResponseEntity<List<WorkAreaMasterDto>> getWorkAreaMasterList(@RequestParam Long id) {

		return ResponseEntity.ok(masterService.getWorkAreaMasterByCompany(id));
	}

	@PostMapping("/activity-master/add")
	public ResponseEntity<RegistrationResponse> addNewActivityMasterList(@RequestBody ActivityMasterDto masterDto) {

		return ResponseEntity.ok(activityService.createActivityMaster(masterDto));
	}

	@GetMapping("/activity-master")
	public ResponseEntity<List<ActivityMasterDto>> getAllActivityMasters(@RequestParam Long id) {

		return ResponseEntity.ok(activityService.getAllActivityMastersForCompany(id));
	}

	@PutMapping("/activity-master/update")
	public ResponseEntity<RegistrationResponse> updateActivityMaster(@RequestBody ActivityMasterDto masterDto) {

		return ResponseEntity.ok(activityService.updateActivityMaster(masterDto));
	}

	@GetMapping("/reports/expense")
	public ResponseEntity<List<ExpenseReportDto>> getExpenseReportSummaryForCompany(@RequestParam Long id) {
		return ResponseEntity.ok(traderService.getExpenseReportByCompanyId(id));
	}

	@GetMapping("/reports/expense/detail")
	public ResponseEntity<List<ExpensesDto>> getExpenseBetween(@RequestParam String mY, @RequestParam Long id) {

		return ResponseEntity.ok(expenseService.getExpensesForMonth(mY,id));
	}
	
//	@PostMapping("/reports/expense/daily")
//	public ResponseEntity<List<ExpensesDto>> getExpenseForDay(@RequestBody RequestObject req) {
//
//		return ResponseEntity.ok(expenseService.getExpensesForDay(req.getDate()));
//	} 

	@GetMapping("/reports/attendance")
	public ResponseEntity<List<AttendanceReportDto>> getAttendanceReportSummaryForCompany(
			@RequestParam(name = "mY") String monthYear, @RequestParam Long id) {
		return ResponseEntity.ok(traderService.getAttendanceReportForCompanyByMonthYear(id, monthYear));
	}

	@GetMapping("/reports/attendance/daily")
	public ResponseEntity<List<AttendanceDto>> getDailyAttendance(@RequestParam(name = "d") String date,
			@RequestParam Long id) {

		return ResponseEntity.ok(traderService.getDailyAttendanceByCompanyId(id, date));
	}

	@GetMapping("/reports/attendance/user")
	public ResponseEntity<List<AttendanceDto>> getMonthlyAttendanceByUserId(@RequestParam(name = "mY") String monthYear,
			@RequestParam(name = "uId") Long id) {
		return ResponseEntity.ok(attendanceService.getAttendanceByMonth(monthYear, id));
	}

	@PostMapping("/reports/activity")
	public ResponseEntity<List<ActivityDto>> getActivityReportsForCompany(@RequestBody RequestObject req) {
		return ResponseEntity.ok(traderService.getActivityReports(req.getId()));
	}

	@GetMapping("/reports/visits")
	public ResponseEntity<List<VisitsDto>> getVisitReportsForCompany(@RequestParam Long id) {
		return ResponseEntity.ok(traderService.getVisitReports(id));
	}

	@GetMapping("/reports/tour")
	public ResponseEntity<List<TourDto>> getTourReportsForCompany(@RequestParam Long id) {
		return ResponseEntity.ok(traderService.getTourReports(id));
	}

	@PostMapping("/masters/holiday/add")
	public ResponseEntity<HolidayMasterDto> addNewHolidayMaster(@RequestBody HolidayMasterDto masterDto) {
		return ResponseEntity.ok(workMasterService.createHolidayMaster(masterDto));
	}

	@GetMapping("/masters/holiday")
	public ResponseEntity<HolidayMasterDto> getHolidayMaster(@RequestParam("cId") Long id,
			@RequestParam("mY") String mY) {
		return ResponseEntity.ok(workMasterService.getHolidayMasterbyCompanyIdAndMonthYear(id, mY));
	}
}
