package design.boilerplate.springboot.security.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.repository.ApiRepository;
import design.boilerplate.springboot.security.dto.ApiDto;

@Service
public class ApiServiceImpl implements ApiService {
	
	@Autowired
	ApiRepository apiRepository;

	@Override
	public ApiDto getAPI(Long id) {
		
		ApiDto apiDto = new ApiDto();
		
		BeanUtils.copyProperties(apiRepository.findById(id).get(), apiDto);
		
		return apiDto;
	}

}
