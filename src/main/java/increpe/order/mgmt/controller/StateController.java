package increpe.order.mgmt.controller;

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

import increpe.order.mgmt.security.dto.StateDto;
import increpe.order.mgmt.service.StateService;


@CrossOrigin
@RestController
@RequestMapping("/state")
public class StateController {
	
	@Autowired
	StateService stateService;
	
	@PostMapping("/add")
	public ResponseEntity<StateDto> addNewStateType(@RequestBody StateDto stateDto) {	
		
		return ResponseEntity.ok(stateService.createState(stateDto));
	}
	
	@GetMapping("/name")
	public ResponseEntity<StateDto> getStateByName(@RequestParam(name = "id") String stateName) {
		
		return ResponseEntity.ok(stateService.getStateByStateName(stateName));
	}

	@GetMapping("/code")
	public ResponseEntity<StateDto> getStateByCode(@RequestParam(name = "id") String stateCode) {
		
		return ResponseEntity.ok(stateService.getStateByStateCode(stateCode));
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<StateDto> updateState(@RequestBody StateDto stateDto) {
		
		return ResponseEntity.ok(stateService.updateState(stateDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteState(@RequestBody StateDto stateDto) {
		 
		return ResponseEntity.ok(!stateService.deleteState(stateDto) ? "Deleted" : "Something went wrong!");
	}

}

