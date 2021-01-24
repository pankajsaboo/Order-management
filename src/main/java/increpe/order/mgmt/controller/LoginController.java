package increpe.order.mgmt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import increpe.order.mgmt.security.dto.LoginRequest;
import increpe.order.mgmt.security.dto.LoginResponse;
import increpe.order.mgmt.security.jwt.JwtTokenService;

import javax.validation.Valid;

/**
 * 
 *
 * 
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

	private final JwtTokenService jwtTokenService;

	@PostMapping
	public ResponseEntity<LoginResponse> loginRequest(@Valid @RequestBody LoginRequest loginRequest) {

		final LoginResponse loginResponse = jwtTokenService.getLoginResponse(loginRequest);

		return ResponseEntity.ok(loginResponse);
	}

}
