package design.boilerplate.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import design.boilerplate.springboot.security.dto.MenuDto;
import design.boilerplate.springboot.security.service.MenuService;

@CrossOrigin
@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	MenuService menuService;

	@PostMapping("/add")
	public ResponseEntity<MenuDto> addNewMenu(@RequestBody MenuDto menuDto) {

		return ResponseEntity.ok(menuService.createMenu(menuDto));
	}

	@GetMapping("/{menuId}")
	public ResponseEntity<MenuDto> getMenuByName(@PathVariable(name = "menuId") Long id) {

		return ResponseEntity.ok(menuService.getMenu(id));
	}

//	@PutMapping("/update")
//	public ResponseEntity<MenuDto> updateMenu(@RequestBody MenuDto menuDto) {
//		return ResponseEntity.ok(menuService.updateMenu(menuDto));
//	}

	@DeleteMapping("/remove")
	public ResponseEntity<String> deleteMenu(@RequestBody MenuDto menuDto) {

		return ResponseEntity.ok(!menuService.deleteMenu(menuDto) ? "Deleted" : "Something went wrong!");
	}

}
