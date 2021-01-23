package increpe.order.mgmt.security.mapper;

import org.mapstruct.AfterMapping;
import org.mapstruct.BeforeMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import increpe.order.mgmt.model.Address;
import increpe.order.mgmt.model.City;
import increpe.order.mgmt.model.Country;
import increpe.order.mgmt.model.State;
import increpe.order.mgmt.security.dto.AddressDto;
import increpe.order.mgmt.security.dto.CityDto;
import increpe.order.mgmt.security.dto.CountryDto;
import increpe.order.mgmt.security.dto.StateDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

	AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);
	
	
	@Mappings({
		@Mapping(source = "city", target = "cityId"),
		@Mapping(source = "addressType", target = "addressTypeId")
	})
	Address convertToAddress(AddressDto addressDto);
	
	@Mappings({
		@Mapping(source = "cityId", target = "city"),
		@Mapping(source = "addressTypeId", target = "addressType")
	})
	AddressDto convertToAddressDto(Address address);
	
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
