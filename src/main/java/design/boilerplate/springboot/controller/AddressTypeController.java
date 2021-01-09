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

import design.boilerplate.springboot.model.AddressType;
import design.boilerplate.springboot.security.dto.AddressTypeDto;
import design.boilerplate.springboot.security.service.AddressTypeService;

@CrossOrigin
@RestController
@RequestMapping("/addressType")
public class AddressTypeController {

	@Autowired
	AddressTypeService addressTypeService;

	@PostMapping("/add")
	public ResponseEntity<AddressTypeDto> addNewAddressType(@RequestBody AddressTypeDto addressTypeDto) {	
		
		return ResponseEntity.ok(addressTypeService.createAddressType(addressTypeDto));
	}
	
	@GetMapping("/{addressTypeName}")
	public ResponseEntity<AddressTypeDto> getAddressTypeByName(@PathVariable(name = "addressTypeName") String addressTypeName) {
		return ResponseEntity.ok(addressTypeService.getAddressTypeByAddressTypeName(addressTypeName));
	}
	
	@GetMapping("/all/{status}")
	public ResponseEntity<List<AddressTypeDto>> getAllByStatus(@PathVariable(name = "status") String status){
		return ResponseEntity.ok(addressTypeService.getAddressTypesByStatus(status));
	}
	
	@PutMapping("/updateStatus")
	public ResponseEntity<AddressTypeDto> updateAddressType(@RequestBody AddressTypeDto addressTypeDto) {
		return ResponseEntity.ok(addressTypeService.updateAddressType(addressTypeDto));
	}
	
	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteAddressType(@RequestBody AddressTypeDto addressTypeDto) {
		 
		return ResponseEntity.ok(!addressTypeService.deleteAddressType(addressTypeDto) ? "Deleted" : "Something went wrong!");
	}
	
}
