package design.boilerplate.springboot.security.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import design.boilerplate.springboot.model.City;
import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.model.State;
import design.boilerplate.springboot.security.dto.CityDto;
import design.boilerplate.springboot.security.dto.CountryDto;
import design.boilerplate.springboot.security.dto.StateDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CityMapper {

	CityMapper INSTANCE = Mappers.getMapper(CityMapper.class);
	
	@Mapping(source = "state", target = "stateId")
	City convertToCity(CityDto cityDto);
	
	@Mapping(source = "stateId", target = "state")
	CityDto convertToCityDto(City city);
	
	@Mapping(source = "country", target = "countryId")
	State convertToState(StateDto stateDto);
	
	@Mapping(source = "countryId", target = "country")
	StateDto convertToStateDto(State state);
	
	Country convertToCountry(CountryDto countryDto);
	
	CountryDto convertToCountryDto(Country country);
}
