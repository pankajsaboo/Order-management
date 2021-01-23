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

import increpe.order.mgmt.security.dto.UserTypeDto;
import increpe.order.mgmt.service.UserTypeService;

@CrossOrigin
@RestController
@RequestMapping("/userType")
public class UserTypeController {
	
	@Autowired
	UserTypeService userTypeService;

	@PostMapping("/add")
	public ResponseEntity<UserTypeDto> addNewUserType(@RequestBody UserTypeDto userTypeDto) {	
		
		return ResponseEntity.ok(userTypeService.createUserType(userTypeDto));
	}
	
	@GetMapping("/{userTypeName}")
	public ResponseEntity<UserTypeDto> getUserTypeByName(@PathVariable(name = "userTypeName") String userTypeName) {
		return ResponseEntity.ok(userTypeService.getUserTypeByUserTypeName(userTypeName));
	}
	
	@GetMapping("/all/{status}")
	public ResponseEntity<List<UserTypeDto>> getAllByStatus(@PathVariable(name = "status") String status){
		return ResponseEntity.ok(userTypeService.getUserTypesByStatus(status));
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<UserTypeDto> updateUserType(@RequestBody UserTypeDto userTypeDto) {
		return ResponseEntity.ok(userTypeService.updateUserType(userTypeDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteUserType(@RequestBody UserTypeDto userTypeDto) {
		 
		return ResponseEntity.ok(!userTypeService.deleteUserType(userTypeDto) ? "Deleted" : "Something went wrong!");
	}

}
