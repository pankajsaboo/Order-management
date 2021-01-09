package design.boilerplate.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TraderDto {
	
	@JsonProperty(value = "traderCompanyName")
	String companyName;
	
	@JsonProperty(value = "traderAdminName")
	String adminName;
	
	@JsonProperty(value = "traderCompanyEmail")
	String companyEmail;
	
	@JsonProperty(value = "traderCompanyPhone")
	String companyPhone;
	
	@JsonProperty(value = "traderCompanyLogo")
	String companyLogo;
	
	@JsonProperty(value = "traderGstNumber")
	String gstNumber;

}
