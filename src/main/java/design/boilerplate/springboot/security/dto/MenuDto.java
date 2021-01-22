package design.boilerplate.springboot.security.dto;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import design.boilerplate.springboot.model.Menu;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class MenuDto {
	
	@JsonProperty(value = "_id")
	Long id;
	
	@JsonProperty(value = "orderNumber")
	int orderNumber;
	
	@JsonProperty(value = "levelNumber")
	int levelNumber;
	
	@JsonProperty(value = "isParent")
	boolean isParent;
	
	@JsonProperty(value = "parentMenuId")
	MenuDto parentMenuId;
	
	@JsonProperty(value = "childMenuList")
	Set<MenuDto> childMenuList = new HashSet<MenuDto>();
	
	@JsonProperty(value = "title")
	String title;
	
	@JsonProperty(value = "status")
	String status;

}
