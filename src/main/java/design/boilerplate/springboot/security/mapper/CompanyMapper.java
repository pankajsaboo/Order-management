package design.boilerplate.springboot.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import design.boilerplate.springboot.model.Company;
import design.boilerplate.springboot.security.dto.TraderDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CompanyMapper {
	
	CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);
	
	Company ConvertToCompany(TraderDto traderDto);

}
