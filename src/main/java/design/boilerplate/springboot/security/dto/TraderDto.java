package design.boilerplate.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TraderDto {
	
	@JsonProperty(value = "traderId")
	Long traderId;
	
	@JsonProperty(value = "traderCompanyName")
	String companyName;
	
	@JsonProperty(value = "traderAdminName")
	String traderAdminName;
	
	@JsonProperty(value = "traderCompanyEmail")
	String traderCompanyEmail;
	
	@JsonProperty(value = "traderCompanyPhone")
	String traderCompanyPhone;
	
	@JsonProperty(value = "traderCompanyLogo")
	String traderCompanyLogo;
	
	@JsonProperty(value = "traderGstNumber")
	String gstNumber;

}
