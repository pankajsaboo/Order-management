package design.boilerplate.springboot.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class MenuDto {
	
	@JsonProperty(value = "orderNumber")
	int orderNumber;
	
	@JsonProperty(value = "levelNumber")
	int levelNumber;
	
	@JsonProperty(value = "isParent")
	boolean isParent;
	
	@JsonProperty(value = "parentMenuId")
	MenuDto parentMenuId;
	
	@JsonProperty(value = "title")
	String title;
	
	@JsonProperty(value = "status")
	String status;

}
