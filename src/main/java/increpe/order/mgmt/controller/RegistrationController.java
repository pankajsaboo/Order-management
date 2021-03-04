package increpe.order.mgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.RegistrationResponse;
import increpe.order.mgmt.service.RegistrationService;
import lombok.RequiredArgsConstructor;

/**
 * 
 *
 * 
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/register")
public class RegistrationController {

	@Autowired
	RegistrationService registrationService;

	@PostMapping("")
	public ResponseEntity<RegistrationResponse> registerCustomer(@RequestBody RegistrationRequest registrationRequest) {

		final RegistrationResponse registrationResponse = registrationService.register(registrationRequest);

		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
	}
	
//	@PostMapping("/trader")
//	public ResponseEntity<RegistrationResponse> registerBuyer(@RequestBody RegistrationRequest registrationRequest) {
//
//		final RegistrationResponse registrationResponse = registrationService.registerBuyer(registrationRequest);
//
//		return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
//	}

}
