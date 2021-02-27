package increpe.order.mgmt.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.UserType;
import increpe.order.mgmt.repository.UserTypeRepository;
import increpe.order.mgmt.security.dto.UserTypeDto;

@Service
public class UserTypeService {

	@Autowired
	UserTypeRepository userTypeRepository;

	
	public UserTypeDto createUserType(UserTypeDto userTypeDto) {

		UserType userType = convertToUserType(userTypeDto);

		return convertToUserTypeDto(userTypeRepository.save(userType));
	}

	
	public UserType getUserType(Long id) {
		return userTypeRepository.findById(id).get();
	}

	
	public UserType getUserTypeByName(String userTypeName) {
		return userTypeRepository.findByUserTypeName(userTypeName);
	}

	
	public UserTypeDto getUserTypeByUserTypeName(String userTypeName) {
		return convertToUserTypeDto(userTypeRepository.findByUserTypeName(userTypeName));
	}

	
	public List<UserTypeDto> getUserTypesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public UserTypeDto updateUserType(UserTypeDto userTypeDto) {

		if (userTypeRepository.existsById(userTypeDto.getId())) {

			UserType userType = convertToUserType(userTypeDto);

			return convertToUserTypeDto(userTypeRepository.save(userType));
		}
		
		return createUserType(userTypeDto);
	}

	
	public boolean deleteUserType(UserTypeDto userTypeDto) {
		
		if (userTypeRepository.existsById(userTypeDto.getId())) {
			
			userTypeRepository.deleteById(userTypeDto.getId());

			return userTypeRepository.existsById(userTypeDto.getId());
		}
		
		return false;

		
	}

	private UserTypeDto convertToUserTypeDto(UserType userType) {

		UserTypeDto dto = new UserTypeDto();

		BeanUtils.copyProperties(userType, dto);

		return dto;
	}

	private UserType convertToUserType(UserTypeDto dto) {

		UserType userType = new UserType();

		BeanUtils.copyProperties(dto, userType);

		return userType;
	}

}
