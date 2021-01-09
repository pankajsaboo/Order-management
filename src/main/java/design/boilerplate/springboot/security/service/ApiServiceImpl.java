package design.boilerplate.springboot.security.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Api;
import design.boilerplate.springboot.repository.ApiRepository;
import design.boilerplate.springboot.security.dto.ApiDto;

@Service
public class ApiServiceImpl implements ApiService {
	
	@Autowired
	ApiRepository apiRepository;

	@Override
	public ApiDto createApi(ApiDto apiDto) {
		
		Api api = convertToApi(apiDto);

		return convertToApiDto(apiRepository.save(api));
	}

	@Override
	public ApiDto getApi(Long id) {
		return convertToApiDto(apiRepository.findById(id).get());
	}

	@Override
	public Api getApiByName(String apiName) {
		return apiRepository.findByApiName(apiName);
	}

	@Override
	public ApiDto getApiByApiName(String apiName) {
		return convertToApiDto(apiRepository.findByApiName(apiName));
	}

	@Override
	public ApiDto updateApi(ApiDto apiDto) {
		
		if (apiRepository.existsById(apiDto.getId())) {

			Api api = convertToApi(apiDto);

			return convertToApiDto(apiRepository.save(api));
			
		}

		return createApi(apiDto);
	}

	@Override
	public boolean deleteApi(ApiDto apiDto) {
		
		if (apiRepository.existsById(apiDto.getId())) {
			
			apiRepository.deleteById(apiDto.getId());
			
			return apiRepository.existsById(apiDto.getId());
		}

		return false;
	}

	private ApiDto convertToApiDto(Api api) {

		ApiDto dto = new ApiDto();

		BeanUtils.copyProperties(api, dto);

		return dto;
	}

	private Api convertToApi(ApiDto dto) {

		Api api = new Api();

		BeanUtils.copyProperties(dto, api);

		return api;
	}

}
