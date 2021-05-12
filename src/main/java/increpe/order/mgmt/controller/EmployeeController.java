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

import increpe.order.mgmt.repository.ExpensesSummary;
import increpe.order.mgmt.security.dto.CompanyProductDto;
import increpe.order.mgmt.security.dto.CustomerDto;
import increpe.order.mgmt.security.dto.CustomerSalesPersonRelationDto;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.RequestObject;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.service.ActivityService;
import increpe.order.mgmt.service.AttendanceService;
import increpe.order.mgmt.service.CompanyProductRelationService;
import increpe.order.mgmt.service.CustomerService;
import increpe.order.mgmt.service.ExpensesService;
import increpe.order.mgmt.service.SalesPersonService;
import increpe.order.mgmt.service.TourService;
import increpe.order.mgmt.service.VisitsService;
import increpe.order.mgmt.sp.dto.ActivityDto;
import increpe.order.mgmt.sp.dto.ActivityMasterDto;
import increpe.order.mgmt.sp.dto.AttendanceDto;
import increpe.order.mgmt.sp.dto.ExpensesDto;
import increpe.order.mgmt.sp.dto.TourDto;
import increpe.order.mgmt.sp.dto.VisitsDto;

@CrossOrigin
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	AttendanceService attendanceService;

	@Autowired
	SalesPersonService salesPersonService;

	@Autowired
	CustomerService customerService;

	@Autowired
	CompanyProductRelationService companyProductRelationService;

	@PostMapping("")
	public ResponseEntity<SalesPersonDto> getEmployeeProfile(@RequestBody RequestObject req) {

		return ResponseEntity.ok(salesPersonService.getSalesPersonByUserId(req.getId()));
	}

	@PutMapping("/update")
	public ResponseEntity<RegistrationResponse> updateEmployeeProfile(@RequestBody SalesPersonDto salesPersonDto) {

		return ResponseEntity.ok(salesPersonService.updateSalesPersonData(salesPersonDto, false));
	}

	@PostMapping("/attendance/add")
	public ResponseEntity<RegistrationResponse> createNewAttendance(@RequestBody AttendanceDto aDto) {

		return ResponseEntity.ok(attendanceService.addNewAttendance(aDto));
	}

	@GetMapping("/attendance")
	public ResponseEntity<List<AttendanceDto>> getAttendanceBetween(@RequestParam(name = "mY") String monthYear,
			@RequestParam(name = "uId") Long id) {

		return ResponseEntity.ok(attendanceService.getAttendanceByMonth(monthYear, id));
	}

	@GetMapping("/customers")
	public ResponseEntity<List<CustomerSalesPersonRelationDto>> getCustomerSalesPersonRelationListBySalesPersonId(
			@RequestParam(name = "uId") Long id) {

		return ResponseEntity.ok(customerService.getAllBySalesPerson(id));
	}

	@GetMapping("/customers/details")
	public ResponseEntity<CustomerDto> getCustomerDetailsByCustomerId(@RequestParam(name = "cId") Long id) {

		return ResponseEntity.ok(salesPersonService.getCustomerDetailsForSalesPerson(id));
	}

	@GetMapping("/products")
	public ResponseEntity<List<CompanyProductDto>> getCustomerProductListByCustomerId(
			@RequestParam(name = "cId") Long id) {

		return ResponseEntity.ok(companyProductRelationService.getByCustomerId(id));
	}
}
