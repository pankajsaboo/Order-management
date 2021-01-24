package increpe.order.mgmt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Api;
import increpe.order.mgmt.repository.ApiRepository;
import increpe.order.mgmt.security.dto.ApiDto;

@Service
public class ApiService {
	
	@Autowired
	ApiRepository apiRepository;

	
	public ApiDto createApi(ApiDto apiDto) {
		
		Api api = convertToApi(apiDto);

		return convertToApiDto(apiRepository.save(api));
	}

	
	public ApiDto getApi(Long id) {
		return convertToApiDto(apiRepository.findById(id).get());
	}

	
	public Api getApiByName(String apiName) {
		return apiRepository.findByApiName(apiName);
	}

	
	public ApiDto getApiByApiName(String apiName) {
		return convertToApiDto(apiRepository.findByApiName(apiName));
	}

	
	public ApiDto updateApi(ApiDto apiDto) {
		
		if (apiRepository.existsById(apiDto.getId())) {

			Api api = convertToApi(apiDto);

			return convertToApiDto(apiRepository.save(api));
			
		}

		return createApi(apiDto);
	}

	
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
