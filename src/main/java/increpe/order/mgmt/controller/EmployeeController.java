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
	VisitsService visitsService;
	
	@Autowired
	TourService tourService;

	@Autowired
	ExpensesService expensesService;
	
	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	SalesPersonService salesPersonService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	CompanyProductRelationService companyProductRelationService;
	
	@Autowired
	ActivityService activityService;
	
	@PostMapping("")
	public ResponseEntity<SalesPersonDto> getEmployeeProfile(@RequestBody RequestObject req){
		
		return ResponseEntity.ok(salesPersonService.getSalesPersonByUserId(req.getId()));
	}
	
	@PutMapping("/update")
	public ResponseEntity<RegistrationResponse> updateEmployeeProfile(@RequestBody SalesPersonDto salesPersonDto){
		
		return ResponseEntity.ok(salesPersonService.updateSalesPersonData(salesPersonDto, false));
	}

	@PostMapping("/visits/add")
	public ResponseEntity<RegistrationResponse> createNewVisit(@RequestBody VisitsDto visitsDto) {

		return ResponseEntity.ok(visitsService.createNewVisit(visitsDto));
	}

	@GetMapping("/visits/salesperson")
	public ResponseEntity<List<VisitsDto>> getVisitsBySalesPersonId(@RequestParam(name = "uId") Long id) {

		return ResponseEntity.ok(visitsService.getAllVisitsForSalesPerson(id));
	}

	@GetMapping("/visits/date")
	public ResponseEntity<List<VisitsDto>> getVisitsByDate(@RequestParam(name = "uId") Long id,
			@RequestParam(name = "date") String visitDate) {

		return ResponseEntity.ok(visitsService.getVisitsByDateAndSalesPersonId(visitDate, id));
	}

	@PutMapping("/visit/update")
	public ResponseEntity<RegistrationResponse> updateVisitRecord(@RequestBody VisitsDto visitsDto) {
		
		return ResponseEntity.ok(visitsService.updateVisit(visitsDto));
	}
	
	@PostMapping("/expense/add")
	public ResponseEntity<RegistrationResponse> createNewExpense(@RequestBody ExpensesDto eDto) {
		
		return ResponseEntity.ok(expensesService.createNewExpense(eDto));
	}

	@GetMapping("/expense/summary")
	public ResponseEntity<List<ExpensesSummary>> getExpenseSummary(@RequestParam(name = "uId") Long salesPersonId) {

		return ResponseEntity.ok(expensesService.getExpenseSummary(salesPersonId));
	}

	@PostMapping("/expense")
	public ResponseEntity<List<ExpensesDto>> getExpenseBetween(@RequestBody RequestObject req) {

		return ResponseEntity.ok(expensesService.getExpensesForMonth(req.getMY(), req.getId()));
	}
	
	@PutMapping("/expense/update")
	public ResponseEntity<RegistrationResponse> updateExpenseRecord(@RequestBody ExpensesDto eDto) {
		
		return ResponseEntity.ok(expensesService.updateExpense(eDto));
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
	public ResponseEntity<List<CustomerSalesPersonRelationDto>> getCustomerSalesPersonRelationListBySalesPersonId(@RequestParam(name = "uId") Long id) {
		
		return ResponseEntity.ok(customerService.getAllBySalesPerson(id));
	}
	
	@GetMapping("/customers/details")
	public ResponseEntity<CustomerDto> getCustomerDetailsByCustomerId(@RequestParam(name = "cId") Long id) {
		
		return ResponseEntity.ok(salesPersonService.getCustomerDetailsForSalesPerson(id));
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<CompanyProductDto>> getCustomerProductListByCustomerId(@RequestParam(name = "cId") Long id) {
		
		return ResponseEntity.ok(companyProductRelationService.getByCustomerId(id));
	}
	
	@PostMapping("/tour/add")
	public ResponseEntity<RegistrationResponse> createNewTour(@RequestBody TourDto tourDto) {

		return ResponseEntity.ok(tourService.createNewTour(tourDto));
	}

	@GetMapping("/tour/salesperson")
	public ResponseEntity<List<TourDto>> getToursBySalesPersonId(@RequestParam(name = "uId") Long id) {

		return ResponseEntity.ok(tourService.getTourListBySalesPersonId(id));
	}
	
	@PutMapping("/tour/update")
	public ResponseEntity<RegistrationResponse> updateTour(@RequestBody TourDto eDto) {
		
		return ResponseEntity.ok(tourService.updateTour(eDto));
	}

	@DeleteMapping("/tour/delete")
	public ResponseEntity<Boolean> deleteTour(@RequestParam(name = "tId") Long id){
		
		return ResponseEntity.ok(tourService.deleteTour(id));
	}
	
	@PostMapping("/activity/add")
	public ResponseEntity<RegistrationResponse> createNewActivity(@RequestBody ActivityDto activityDto) {

		return ResponseEntity.ok(activityService.createNewActivity(activityDto));
	}

	@PostMapping("/activity/salesperson")
	public ResponseEntity<List<ActivityDto>> getActivitiesBySalesPersonId(@RequestBody RequestObject req) {

		return ResponseEntity.ok(activityService.getAllActivitiesForSalesPerson(req.getId()));
	}
	
	@PutMapping("/activity/update")
	public ResponseEntity<RegistrationResponse> updateActivity(@RequestBody ActivityDto activityDto) {
		
		return ResponseEntity.ok(activityService.updateActivity(activityDto));
	}

	@DeleteMapping("/activity/delete")
	public ResponseEntity<Boolean> deleteActivity(@RequestParam(name = "aId") Long id){
		
		return ResponseEntity.ok(activityService.deleteActivity(id));
	}
	
	@GetMapping("/activity-master")
	public ResponseEntity<List<ActivityMasterDto>> getAllActivityMasters(@RequestParam(name = "cId") Long id) {

		return ResponseEntity.ok(activityService.getAllActivityMastersForCompany(id));
	}
}
