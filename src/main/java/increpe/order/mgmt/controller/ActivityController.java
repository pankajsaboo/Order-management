package increpe.order.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
import increpe.order.mgmt.service.ActivityService;
import increpe.order.mgmt.sp.dto.ActivityDto;
import increpe.order.mgmt.sp.dto.ActivityMasterDto;
import increpe.order.mgmt.sp.dto.PageResultObject;

@CrossOrigin
@RestController
@RequestMapping("/activity")
public class ActivityController {
	
	@Autowired
	ActivityService activityService;
	
	@PostMapping("")
	public ResponseEntity<ActivityDto> getActivityById(@RequestBody RequestObject req) {
		
		return ResponseEntity.ok(activityService.getActivityById(req.getId()));
	}
	
	@PostMapping("/master/add")
	public ResponseEntity<RegistrationResponse> addNewActivityMasterList(@RequestBody ActivityMasterDto masterDto) {

		return ResponseEntity.ok(activityService.createActivityMaster(masterDto));
	}

	@GetMapping("/master")
	public ResponseEntity<List<ActivityMasterDto>> getAllActivityMasters(@RequestParam Long cId) {

		return ResponseEntity.ok(activityService.getAllActivityMastersForCompany(cId));
	}

	@PutMapping("/master/update")
	public ResponseEntity<RegistrationResponse> updateActivityMaster(@RequestBody ActivityMasterDto masterDto) {

		return ResponseEntity.ok(activityService.updateActivityMaster(masterDto));
	}

	@PostMapping("/reports/user")
	public ResponseEntity<PageResultObject> getActivityReportsByUser(@RequestBody RequestObject req) {
		return ResponseEntity.ok(activityService.findActivityReportsByUser(req));
	}
	
	@PostMapping("/reports/date")
	public ResponseEntity<PageResultObject> getActivityReportByDate(@RequestBody RequestObject req) {
		return ResponseEntity.ok(activityService.findActivityReportsByDate(req));
	}
	
	@PostMapping("/reports/month")
	public ResponseEntity<PageResultObject> getActivityReportsByMonthYear(@RequestBody RequestObject req) {
		return ResponseEntity.ok(activityService.findActivityReportsByMonthYear(req));
	}
	
	@PostMapping("/add")
	public ResponseEntity<RegistrationResponse> createNewActivity(@RequestBody ActivityDto activityDto) {

		return ResponseEntity.ok(activityService.createNewActivity(activityDto));
	}

	//could be replaced with reportsByUser
	@PostMapping("/salesperson")
	public ResponseEntity<List<ActivityDto>> getActivitiesBySalesPersonId(@RequestBody RequestObject req) {

		return ResponseEntity.ok(activityService.getAllActivitiesForSalesPerson(req.getId()));
	}

	@PutMapping("/update")
	public ResponseEntity<RegistrationResponse> updateActivity(@RequestBody ActivityDto activityDto) {

		return ResponseEntity.ok(activityService.updateActivity(activityDto));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Boolean> deleteActivity(@RequestParam(name = "aId") Long id) {

		return ResponseEntity.ok(activityService.deleteActivity(id));
	}
}
