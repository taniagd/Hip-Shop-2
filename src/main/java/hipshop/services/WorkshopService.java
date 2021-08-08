package hipshop.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hipshop.models.Workshop;
import hipshop.repositories.WorkshopRepository;

@Service
public class WorkshopService {

	@Autowired
	WorkshopRepository workshopRepository;
	
	public ArrayList<Workshop> getUsers() {
		return (ArrayList<Workshop>) workshopRepository.findAll();
	}
	
	public Workshop saveWorkshop(Workshop workshop) {
		return workshopRepository.save(workshop);		
	}
	
	public Optional<Workshop> getUserById(Long id) {
		return workshopRepository.findById(id);
	}
	
	
	public boolean deleteVendor(Long id) {
		
		
		try {
			workshopRepository.deleteById(id); 
			return true;
		}catch(Exception error) { 
			return false;
		}
	}
}
