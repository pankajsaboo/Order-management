package design.boilerplate.springboot.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	@JoinColumn(name = "parentMenu_id")
	Menu parentMenuId;
	
	@OneToMany(mappedBy = "parentMenuId")
	Set<Menu> childMenuList = new HashSet<Menu>();
	
	@Column(name = "title")
	String title;
	
	@Column(name = "status")
	String status;

}
