package design.boilerplate.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@Entity(name = "menu")
@FieldDefaults(makeFinal = false, level = AccessLevel.PRIVATE)
public class Menu {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "menu_seq")
	@SequenceGenerator(name = "MENU_SEQ", sequenceName = "menu_seq")
	Long id;
	
	@Column(name = "order_number")
	int orderNumber;
	
	@Column(name = "level_number")
	int levelNumber;
	
	@Column(name = "is_parent")
	boolean isParent;
	
	@ManyToOne
	@JoinColumn(name = "menu_id")
	Menu parentMenuId;
	
	@Column(name = "title")
	String title;
	
	@Column(name = "status")
	String status;

}
