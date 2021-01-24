package increpe.order.mgmt.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import increpe.order.mgmt.model.Menu;
import increpe.order.mgmt.security.dto.MenuDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper {
	
	MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);
	
	MenuDto convertToMenuDto(Menu menu);
	
	Menu convertToMenu(MenuDto menuDto);

}
