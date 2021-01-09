package design.boilerplate.springboot.controller;

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

import design.boilerplate.springboot.security.dto.RolesDto;
import design.boilerplate.springboot.security.service.RolesService;

@CrossOrigin
@RestController
@RequestMapping("/roles")
public class RolesController {
	
	@Autowired
	RolesService rolesService;

	@PostMapping("/add")
	public ResponseEntity<RolesDto> addNewRoles(@RequestBody RolesDto rolesDto) {	
		
		return ResponseEntity.ok(rolesService.createRoles(rolesDto));
	}
	
	@GetMapping("/{rolesTitle}")
	public ResponseEntity<RolesDto> getRolesByTitle(@PathVariable(name = "rolesTitle") String rolesTitle) {
		return ResponseEntity.ok(rolesService.getRolesByRolesTitle(rolesTitle));
	}
	
	@GetMapping("/all/{status}")
	public ResponseEntity<List<RolesDto>> getAllByStatus(@PathVariable(name = "status") String status){
		return ResponseEntity.ok(rolesService.getRolessByStatus(status));
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<RolesDto> updateRoles(@RequestBody RolesDto rolesDto) {
		return ResponseEntity.ok(rolesService.updateRoles(rolesDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteRoles(@RequestBody RolesDto rolesDto) {
		 
		return ResponseEntity.ok(!rolesService.deleteRoles(rolesDto) ? "Deleted" : "Something went wrong!");
	}

}
