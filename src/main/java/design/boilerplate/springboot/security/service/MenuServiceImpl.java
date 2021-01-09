package design.boilerplate.springboot.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import design.boilerplate.springboot.model.Menu;
import design.boilerplate.springboot.repository.MenuRepository;
import design.boilerplate.springboot.security.dto.MenuDto;
import design.boilerplate.springboot.security.mapper.MenuMapper;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	MenuRepository menuRepository;

	@Override
	public MenuDto createMenu(MenuDto menuDto) {
		
		Menu menu = convertMenuDtoToMenu(menuDto);
		
		return convertMenuToMenuDto(menuRepository.save(menu));
	}

	@Override
	public MenuDto getMenu(Long id) {
		
		Menu menu = menuRepository.findById(id).get();
		
		return convertMenuToMenuDto(menu);
	}

	@Override
	public boolean deleteMenu(MenuDto menuDto) {
		
		if(menuRepository.existsById(menuDto.getId())) {
			
			menuRepository.deleteById(menuDto.getId());
			
			return menuRepository.existsById(menuDto.getId());
		}
		
		return false;
	}
	
	private Menu convertMenuDtoToMenu(MenuDto menuDto) {
		
		Menu menu = MenuMapper.INSTANCE.convertToMenu(menuDto);
		
		return menu;
		
	}
	
	private MenuDto convertMenuToMenuDto(Menu menu) {
		
		MenuDto menuDto = MenuMapper.INSTANCE.convertToMenuDto(menu);
		
		return menuDto;
	}
	

}
