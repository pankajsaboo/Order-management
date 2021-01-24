package design.boilerplate.springboot.security.dto;

import lombok.Builder.Default;
import lombok.experimental.FieldDefaults;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import javax.validation.constraints.*;

import org.springframework.boot.context.properties.bind.DefaultValue;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created on Ağustos, 2020
 *
 * @author Faruk
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class RegistrationRequest {

	@JsonProperty(value = "companyTypeRelationId")
	CompanyTypeRelationDto companyTypeRelationId;
	
	@JsonProperty(value = "userId")
	AuthenticatedUserDto userId;
	
	@JsonProperty(value = "emailId")
	EmailsDto emailId;
	
	@JsonProperty(value = "phoneId")
	PhonesDto phoneId;
	
	@JsonProperty(value = "workAreaList")
	List<WorkAreaMasterDto> workAreaList;
	
	@JsonProperty(value = "addressId")
	AddressDto addressId;

}





/*
 * @NotEmpty(message = "{registration_name_not_empty}") String name;
 * 
 * @NotEmpty(message = "{registration_company_name_not_empty}") String
 * companyName;
 * 
 * String gstNumber;
 * 
 * @Email(message = "{registration_email_is_not_valid}")
 * 
 * @NotEmpty(message = "{registration_email_not_empty}") String email;
 * 
 * 
 * @NotEmpty(message = "{registration_phone_not_empty}") String phone;
 * 
 * @NotEmpty(message = "{registration_username_not_empty}") String username;
 * 
 * @NotEmpty(message = "{registration_password_not_empty}") String password;
 * 
 * AddressDto address;
 */
 
