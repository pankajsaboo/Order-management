package increpe.order.mgmt.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.exceptions.RegistrationException;
import increpe.order.mgmt.repository.EmailsRepository;
import increpe.order.mgmt.repository.UserRepository;
import increpe.order.mgmt.security.dto.EmailsDto;
import increpe.order.mgmt.security.dto.RegistrationRequest;
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

	private final UserRepository userRepository;

	private final EmailsRepository emailsRepository;
	
	private final ExceptionMessageAccessor exceptionMessageAccessor;

	public void validateUser(RegistrationRequest registrationRequest) {

		final EmailsDto email = registrationRequest.getEmailId();
		final String username = registrationRequest.getUserId().getUsername();

		checkEmail(email);
		checkUsername(username);
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

}
