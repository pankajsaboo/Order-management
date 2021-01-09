package design.boilerplate.springboot.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import design.boilerplate.springboot.model.Menu;
import design.boilerplate.springboot.security.dto.MenuDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper {
	
	MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);
	
	MenuDto convertToMenuDto(Menu menu);
	
	Menu convertToMenu(MenuDto menuDto);

}
