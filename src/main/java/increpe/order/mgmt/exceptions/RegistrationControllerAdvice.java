package increpe.order.mgmt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import increpe.order.mgmt.controller.RegistrationController;

import java.time.LocalDateTime;

/**
 * 
 *
 * 
 */
@RestControllerAdvice(basePackageClasses = RegistrationController.class)
public class RegistrationControllerAdvice {

	@ExceptionHandler(RegistrationException.class)
	ResponseEntity<ApiExceptionResponse> handleRegistrationException(RegistrationException exception) {

		final ApiExceptionResponse response = new ApiExceptionResponse(exception.getErrorMessage(), HttpStatus.BAD_REQUEST);

		return ResponseEntity.status(response.getStatus()).body(response);
	}

}
