package design.boilerplate.springboot.security.service;

import java.util.List;

import design.boilerplate.springboot.model.Api;
import design.boilerplate.springboot.security.dto.ApiDto;

public interface ApiService {

	ApiDto createApi(ApiDto apiDto);

	ApiDto getApi(Long id);
	
	Api getApiByName(String apiName);
	
	ApiDto getApiByApiName(String apiName);
	
	ApiDto updateApi(ApiDto apiDto);
	
	boolean deleteApi(ApiDto apiDto);
}
