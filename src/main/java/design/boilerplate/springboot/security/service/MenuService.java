package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.security.dto.MenuDto;

public interface MenuService {
	
	MenuDto getMenu(Long id);

}
