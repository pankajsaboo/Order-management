package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.security.dto.ApiDto;

public interface ApiService {

	ApiDto getAPI(Long id);
}
