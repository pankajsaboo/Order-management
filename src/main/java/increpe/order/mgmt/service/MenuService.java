package increpe.order.mgmt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import increpe.order.mgmt.model.Menu;
import increpe.order.mgmt.repository.MenuRepository;
import increpe.order.mgmt.security.dto.MenuDto;
import increpe.order.mgmt.security.mapper.MenuMapper;

@Service
public class MenuService {
	
	@Autowired
	MenuRepository menuRepository;

	
	public MenuDto createMenu(MenuDto menuDto) {
		
		Menu menu = convertMenuDtoToMenu(menuDto);
		
		return convertMenuToMenuDto(menuRepository.save(menu));
	}

	
	public MenuDto getMenu(Long id) {
		
		Menu menu = menuRepository.findById(id).get();
		
		return convertMenuToMenuDto(menu);
	}

	
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
