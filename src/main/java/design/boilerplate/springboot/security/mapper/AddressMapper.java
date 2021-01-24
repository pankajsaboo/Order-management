package design.boilerplate.springboot.security.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import design.boilerplate.springboot.model.Address;
import design.boilerplate.springboot.model.City;
import design.boilerplate.springboot.model.Country;
import design.boilerplate.springboot.model.State;
import design.boilerplate.springboot.security.dto.AddressDto;
import design.boilerplate.springboot.security.dto.CityDto;
import design.boilerplate.springboot.security.dto.CountryDto;
import design.boilerplate.springboot.security.dto.StateDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
	
	
//	@Mappings({
//		@Mapping(source = "city", target = "cityId"),
//	})
	Address convertToAddress(AddressDto addressDto);
	
	AddressDto convertToAddressDto(Address address);
	
	@Mapping(source = "state", target = "stateId")
	City convertToCity(CityDto cityDto);
	
	@Mapping(source = "stateId", target = "state")
	CityDto convertToCityDto(City city);
	
	State convertToState(StateDto stateDto);
	
	StateDto convertToStateDto(State state);
	
	Country convertToCountry(CountryDto countryDto);
	
	CountryDto convertToCountryDto(Country country);
	
//	@AfterMapping
//	default void convertToCompanyDto(Address address, @MappingTarget AddressDto addressDto) {
//		
//		addressDto.setCompanyId(CompanyMapper.INSTANCE.convertToCompanyDto(address.getCompanyId()));
//		
//		addressDto.setUserId(UserMapper.INSTANCE.convertToAuthenticatedUserDto(address.getUserId()));
//	}
//	
//	@AfterMapping
//	default void convertToCompany(AddressDto addressDto, @MappingTarget Address address) {
//		
//		address.setCompanyId(CompanyMapper.INSTANCE.convertToCompany(addressDto.getCompanyId()));
//		
//		address.setUserId(UserMapper.INSTANCE.convertToUser(addressDto.getUserId()));
//	}
}
