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

import increpe.order.mgmt.security.dto.EmailTypeDto;
import increpe.order.mgmt.service.EmailTypeService;

@CrossOrigin
@RestController
@RequestMapping("/emailType")
public class EmailTypeController {
	
	@Autowired
	EmailTypeService emailTypeService;

	@PostMapping("/add")
	public ResponseEntity<EmailTypeDto> addNewEmailType(@RequestBody EmailTypeDto emailTypeDto) {	
		
		return ResponseEntity.ok(emailTypeService.createEmailType(emailTypeDto));
	}
	
	@GetMapping("/{emailTypeName}")
	public ResponseEntity<EmailTypeDto> getEmailTypeByName(@PathVariable(name = "emailTypeName") String emailTypeName) {
		return ResponseEntity.ok(emailTypeService.getEmailTypeByEmailTypeName(emailTypeName));
	}
	
	@GetMapping("/all/{status}")
	public ResponseEntity<List<EmailTypeDto>> getAllByStatus(@PathVariable(name = "status") String status){
		return ResponseEntity.ok(emailTypeService.getEmailTypesByStatus(status));
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<EmailTypeDto> updateEmailType(@RequestBody EmailTypeDto emailTypeDto) {
		return ResponseEntity.ok(emailTypeService.updateEmailType(emailTypeDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteEmailType(@RequestBody EmailTypeDto emailTypeDto) {
		 
		return ResponseEntity.ok(!emailTypeService.deleteEmailType(emailTypeDto) ? "Deleted" : "Something went wrong!");
	}

}
