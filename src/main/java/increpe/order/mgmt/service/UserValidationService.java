package increpe.order.mgmt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.exceptions.RegistrationException;
import increpe.order.mgmt.repository.EmailsRepository;
import increpe.order.mgmt.repository.SalesPersonRepository;
import increpe.order.mgmt.repository.UserRepository;
import increpe.order.mgmt.security.dto.EmailsDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
import increpe.order.mgmt.security.dto.SalesPersonDto;
import increpe.order.mgmt.utils.ExceptionMessageAccessor;

/**
 * 
 *
 * 
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserValidationService {

	private static final String EMAIL_ALREADY_EXISTS = "email_already_exists";

	private static final String USERNAME_ALREADY_EXISTS = "username_already_exists";
	
	private static final String EMPLOYEE_ID_ALREADY_EXISTS = "employee_id_already_exists";

	private final UserRepository userRepository;

	private final EmailsRepository emailsRepository;
	
	private final ExceptionMessageAccessor exceptionMessageAccessor;
	
	private final SalesPersonRepository salesPersonRepository;

	public void validateUser(RegistrationRequest registrationRequest) {

		final EmailsDto email = registrationRequest.getEmailId();
		final String username = registrationRequest.getUserId().getUsername();

		checkEmail(email);
		checkUsername(username);
	}
	
	public void validateSalesPerson(SalesPersonDto salesPersonDto) {
		
		final EmailsDto email = salesPersonDto.getEmailId();
		final String username = salesPersonDto.getUserId().getUsername();
		final String employeeId = salesPersonDto.getEmployeeId();
		
		checkEmail(email);
		checkUsername(username);
		checkEmpId(employeeId);
	}

	private void checkUsername(String username) {

		final boolean existsByUsername = userRepository.existsByUsername(username);

		if (existsByUsername) {

			log.warn("{} is already being used!", username);

			final String existsUsername = exceptionMessageAccessor.getMessage(null, USERNAME_ALREADY_EXISTS);
			throw new RegistrationException(existsUsername);
		}

	}

	private void checkEmail(EmailsDto email) {

		final boolean existsByEmail = emailsRepository.existsByEmailId(email.getEmailId());

		if (existsByEmail) {

			log.warn("{} is already registered!", email);

			final String existsEmail = exceptionMessageAccessor.getMessage(null, EMAIL_ALREADY_EXISTS);
			throw new RegistrationException(existsEmail);
		}
	}
	
	private void checkEmpId(String empId) {
		
		final boolean existsByEmpId = salesPersonRepository.existsByEmployeeId(empId);

		if (existsByEmpId) {

			log.warn("{} is already registered!", empId);

			final String existsEmpId = exceptionMessageAccessor.getMessage(null, EMPLOYEE_ID_ALREADY_EXISTS);
			throw new RegistrationException(existsEmpId);
		}
	}

}
