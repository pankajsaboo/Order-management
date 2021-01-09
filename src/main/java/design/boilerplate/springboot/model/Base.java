package design.boilerplate.springboot.model;

import java.util.Date;

import javax.persistence.Column;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Base {
	
	@Column(name  = "created_at")
	Date createdAt;
	
	@Column(name  = "updated_at")
	Date updatedAt;

}
