package design.boilerplate.springboot.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.security.dto.CountryDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CountryMapper {
	
	CountryMapper INSTANCE = Mappers.getMapper(CountryMapper.class);
	
	CountryDto convertToCountryDto(Country country);

}
