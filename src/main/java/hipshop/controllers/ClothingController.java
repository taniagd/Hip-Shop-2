package hipshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hipshop.models.Clothing;
import hipshop.services.ClothingService;

@RestController
@RequestMapping("/clothing")
public class ClothingController {

	@Autowired
	ClothingService clothingService;
	
	
	@PostMapping
	public Clothing saveClothing(@RequestBody Clothing clothing) {

		return clothingService.saveClothing(clothing);
	}
	
}
