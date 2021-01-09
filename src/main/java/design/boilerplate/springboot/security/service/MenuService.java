package design.boilerplate.springboot.security.service;

import design.boilerplate.springboot.security.dto.MenuDto;

public interface MenuService {
	
	MenuDto createMenu(MenuDto menuDto);
	
	MenuDto getMenu(Long id);
	
	boolean deleteMenu(MenuDto menuDto);

}
