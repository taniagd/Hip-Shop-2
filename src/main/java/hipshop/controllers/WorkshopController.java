package hipshop.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hipshop.models.Workshop;
import hipshop.services.WorkshopService;



@RestController
@RequestMapping("/workshop")
public class WorkshopController {


	@Autowired
	WorkshopService workshopService;
	
	@GetMapping
	public ArrayList<Workshop> getUsers(){
		return workshopService.getWorkshop();
	}
	@PostMapping
	public Workshop saveWorkshop(@RequestBody Workshop user) {
			return workshopService.saveWorkshop(user);
	}
	@GetMapping(path = "/{idWorkshop}")
	public Optional<Workshop> getUserById(@PathVariable("idWorkshop") Long idVariable){
		return workshopService.getUserById(idVariable);
	}
	@DeleteMapping(path = "/{idWorkshop}")
	public String deleteWorkshop(@PathVariable("idWorkshop")Long id) {
		boolean ok = workshopService.deleteWorkshop(id);
		if(ok) {
			return "Se eliminó ";
		}else {
			return "No se pudo eliminar ";
		}
	}
	

}