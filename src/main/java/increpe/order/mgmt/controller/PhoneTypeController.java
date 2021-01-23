package increpe.order.mgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import increpe.order.mgmt.security.dto.PhoneTypeDto;
import increpe.order.mgmt.service.PhoneTypeService;

@CrossOrigin
@RestController
@RequestMapping("/phoneType")
public class PhoneTypeController {
	
	@Autowired
	PhoneTypeService phoneTypeService;

	@PostMapping("/add")
	public ResponseEntity<PhoneTypeDto> addNewPhoneType(@RequestBody PhoneTypeDto phoneTypeDto) {	
		
		return ResponseEntity.ok(phoneTypeService.createPhoneType(phoneTypeDto));
	}
	
	@GetMapping("/{phoneTypeName}")
	public ResponseEntity<PhoneTypeDto> getPhoneTypeByName(@PathVariable(name = "phoneTypeName") String phoneTypeName) {
		return ResponseEntity.ok(phoneTypeService.getPhoneTypeByPhoneTypeName(phoneTypeName));
	}
	
	@GetMapping("/all/{status}")
	public ResponseEntity<List<PhoneTypeDto>> getAllByStatus(@PathVariable(name = "status") String status){
		return ResponseEntity.ok(phoneTypeService.getPhoneTypesByStatus(status));
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<PhoneTypeDto> updatePhoneType(@RequestBody PhoneTypeDto phoneTypeDto) {
		return ResponseEntity.ok(phoneTypeService.updatePhoneType(phoneTypeDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deletePhoneType(@RequestBody PhoneTypeDto phoneTypeDto) {
		 
		return ResponseEntity.ok(!phoneTypeService.deletePhoneType(phoneTypeDto) ? "Deleted" : "Something went wrong!");
	}

}
