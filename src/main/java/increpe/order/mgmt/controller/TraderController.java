package increpe.order.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import increpe.order.mgmt.model.SalesPerson;
import increpe.order.mgmt.security.dto.CompanyProductDto;
import increpe.order.mgmt.security.dto.CustomerDto;
import increpe.order.mgmt.security.dto.CustomerSalesPersonRelationDto;
import increpe.order.mgmt.security.dto.ProductMasterDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.security.dto.WorkAreaMasterDto;
import increpe.order.mgmt.service.ActivityService;
import increpe.order.mgmt.service.CompanyProductRelationService;
import increpe.order.mgmt.service.CustomerService;
import increpe.order.mgmt.service.ProductService;
import increpe.order.mgmt.service.RegistrationService;
import increpe.order.mgmt.service.SalesPersonService;
import increpe.order.mgmt.service.TraderService;
import increpe.order.mgmt.service.WorkAreaMasterService;
import increpe.order.mgmt.sp.dto.ActivityMasterDto;

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

	@PostMapping("/employee/add")
	public ResponseEntity<RegistrationResponse> addNewSalesPersonAccont(@RequestBody SalesPersonDto request) {

		return ResponseEntity.ok(registrationService.registerSalesPerson(request));
	}

	@GetMapping("/employee")
	public ResponseEntity<List<SalesPersonDto>> getSalesPersonAccount(@RequestParam Long id) {

		return ResponseEntity.ok(traderService.getAllSalesPersonByCompanyId(id));
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

	@GetMapping("/product")
	public ResponseEntity<List<ProductMasterDto>> getAllProducts(@RequestParam Long id) {

		return ResponseEntity.ok(productService.getAllProducts(id));
	}

	@PutMapping("/product/update")
	public ResponseEntity<RegistrationResponse> updateProduct(@RequestBody ProductMasterDto productDto) {

		return ResponseEntity.ok(traderService.updateProduct(productDto));
	}

	@PostMapping("/customer/add")
	public ResponseEntity<RegistrationResponse> addNewCustomer(@RequestBody RegistrationRequest request) {

		return ResponseEntity.ok(traderService.createNewCustomer(request));
	}

	@GetMapping("/customer")
	public ResponseEntity<List<CustomerDto>> getAllCustomers(@RequestParam Long id) {

		return ResponseEntity.ok(traderService.getAllCustomersByCompany(id));
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
	public ResponseEntity<RegistrationResponse> addNewActivityMasterList(
			@RequestBody List<ActivityMasterDto> masterDtoList) {

		return ResponseEntity.ok(activityService.createAllMasters(masterDtoList));
	}
}
