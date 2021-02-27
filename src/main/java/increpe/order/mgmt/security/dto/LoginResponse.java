package increpe.order.mgmt.security.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 *
 * 
 */
@Getter
@Setter
@AllArgsConstructor
public class LoginResponse {

	private String accessToken;
	
	private String message;
	
	private HttpStatus status;

}
