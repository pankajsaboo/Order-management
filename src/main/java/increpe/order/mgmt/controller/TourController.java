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

import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.security.dto.RequestObject;
import increpe.order.mgmt.service.TourService;
import increpe.order.mgmt.sp.dto.PageResultObject;
import increpe.order.mgmt.sp.dto.TourDto;
import increpe.order.mgmt.sp.dto.TourReportsDTO;

@CrossOrigin
@RestController
@RequestMapping("/tour")
public class TourController {
	
	@Autowired
	TourService tourService;
	
	@PostMapping("")
	public ResponseEntity<TourDto> getTourById(@RequestBody RequestObject req) {
		
		return ResponseEntity.ok(tourService.getTourById(req.getId()));
	}
	
	@PostMapping("/reports/user")
	public ResponseEntity<PageResultObject<TourReportsDTO>> getTourReportsByUser(@RequestBody RequestObject req) {
		return ResponseEntity.ok(tourService.findTourReportsByUser(req));
	}
	
	@PostMapping("/reports/date")
	public ResponseEntity<PageResultObject<TourReportsDTO>> getTourReportByDate(@RequestBody RequestObject req) {
		return ResponseEntity.ok(tourService.findTourReportsByDate(req));
	}
	
	@PostMapping("/reports/month")
	public ResponseEntity<PageResultObject<TourReportsDTO>> getTourReportsByMonthYear(@RequestBody RequestObject req) {
		return ResponseEntity.ok(tourService.findTourReportsByMonthYear(req));
	}
	
	@PostMapping("/add")
	public ResponseEntity<RegistrationResponse> createNewTour(@RequestBody TourDto tourDto) {

		return ResponseEntity.ok(tourService.createNewTour(tourDto));
	}

	@GetMapping("/salesperson")
	public ResponseEntity<List<TourDto>> getToursBySalesPersonId(@RequestParam(name = "uId") Long id) {

		return ResponseEntity.ok(tourService.getTourListBySalesPersonId(id));
	}

	@PutMapping("/update")
	public ResponseEntity<RegistrationResponse> updateTour(@RequestBody TourDto eDto) {

		return ResponseEntity.ok(tourService.updateTour(eDto));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteTour(@RequestParam(name = "tId") Long id) {

		return ResponseEntity.ok(tourService.deleteTour(id));
	}

}
