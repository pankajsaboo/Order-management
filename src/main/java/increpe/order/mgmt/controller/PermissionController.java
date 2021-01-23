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

import increpe.order.mgmt.security.dto.PermissionDto;
import increpe.order.mgmt.service.PermissionService;

@CrossOrigin
@RestController
@RequestMapping("/permission")
public class PermissionController {
	
	@Autowired
	PermissionService permissionService;

	@PostMapping("/add")
	public ResponseEntity<PermissionDto> addNewPermission(@RequestBody PermissionDto permissionDto) {	
		
		return ResponseEntity.ok(permissionService.createPermission(permissionDto));
	}
	
	@GetMapping("/{permissionTitle}")
	public ResponseEntity<PermissionDto> getPermissionByTitle(@PathVariable(name = "permissionTitle") String permissionTitle) {
		return ResponseEntity.ok(permissionService.getPermissionByPermissionTitle(permissionTitle));
	}
	
	@GetMapping("/all/{status}")
	public ResponseEntity<List<PermissionDto>> getAllByStatus(@PathVariable(name = "status") String status){
		return ResponseEntity.ok(permissionService.getPermissionsByStatus(status));
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<PermissionDto> updatePermission(@RequestBody PermissionDto permissionDto) {
		return ResponseEntity.ok(permissionService.updatePermission(permissionDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deletePermission(@RequestBody PermissionDto permissionDto) {
		 
		return ResponseEntity.ok(!permissionService.deletePermission(permissionDto) ? "Deleted" : "Something went wrong!");
	}

}
