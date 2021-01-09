package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.UserType;
import design.boilerplate.springboot.repository.UserTypeRepository;
import design.boilerplate.springboot.security.dto.UserTypeDto;

@Service
public class UserTypeServiceImpl implements UserTypeService {

	@Autowired
	UserTypeRepository userTypeRepository;

	@Override
	public UserTypeDto createUserType(UserTypeDto userTypeDto) {

		UserType userType = convertToUserType(userTypeDto);

		return convertToUserTypeDto(userTypeRepository.save(userType));
	}

	@Override
	public UserTypeDto getUserType(Long id) {
		return convertToUserTypeDto(userTypeRepository.findById(id).get());
	}

	@Override
	public UserType getUserTypeByName(String userTypeName) {
		return userTypeRepository.findByUserTypeName(userTypeName);
	}

	@Override
	public UserTypeDto getUserTypeByUserTypeName(String userTypeName) {
		return convertToUserTypeDto(userTypeRepository.findByUserTypeName(userTypeName));
	}

	@Override
	public List<UserTypeDto> getUserTypesByStatus(String status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserTypeDto updateUserType(UserTypeDto userTypeDto) {

		if (userTypeRepository.existsById(userTypeDto.getId())) {

			UserType userType = convertToUserType(userTypeDto);

			return convertToUserTypeDto(userTypeRepository.save(userType));
		}
		
		return createUserType(userTypeDto);
	}

	@Override
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
