package increpe.order.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.RequestObject;
import increpe.order.mgmt.service.VisitsService;
import increpe.order.mgmt.sp.dto.PageResultObject;
import increpe.order.mgmt.sp.dto.VisitsDto;
import increpe.order.mgmt.sp.dto.VisitsReportsDTO;

@CrossOrigin
@RestController
@RequestMapping("/visits")
public class VisitsController {
	
	@Autowired
	VisitsService visitsService;
	
	@PostMapping("")
	public ResponseEntity<VisitsDto> getVisitById(@RequestBody RequestObject req) {
		
		return ResponseEntity.ok(visitsService.getVisitById(req.getId()));
	}
	
	@PostMapping("/add")
	public ResponseEntity<RegistrationResponse> createNewVisit(@RequestBody VisitsDto visitsDto) {

		return ResponseEntity.ok(visitsService.createNewVisit(visitsDto));
	}
	
	@PutMapping("/update")
	public ResponseEntity<RegistrationResponse> updateVisitRecord(@RequestBody VisitsDto visitsDto) {

		return ResponseEntity.ok(visitsService.updateVisit(visitsDto));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteVisitRecord(@RequestParam(name = "vId") Long id) {

		return ResponseEntity.ok(visitsService.deleteVisit(id));
	}
	
	@PostMapping("/reports/user")
	public ResponseEntity<PageResultObject<VisitsReportsDTO>> getVisitReportsByUser(@RequestBody RequestObject req) {
		return ResponseEntity.ok(visitsService.findVisitReportsByUser(req));
	}
	
	@PostMapping("/reports/user-date")
	public ResponseEntity<PageResultObject<VisitsReportsDTO>> getVisitReportsByUserAndDate(@RequestBody RequestObject req) {
		return ResponseEntity.ok(visitsService.findVisitReportsByUserAndDate(req));
	}
	
	@PostMapping("/reports/date")
	public ResponseEntity<PageResultObject<VisitsReportsDTO>> getTourReportByDate(@RequestBody RequestObject req) {
		return ResponseEntity.ok(visitsService.findVisitReportsByDate(req));
	}
	
	@PostMapping("/reports/month")
	public ResponseEntity<PageResultObject<VisitsReportsDTO>> getTourReportsByMonthYear(@RequestBody RequestObject req) {
		return ResponseEntity.ok(visitsService.findVisitReportsByMonthYear(req));
	}

}
