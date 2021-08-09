package hipshop.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hipshop.models.Clothing;
import hipshop.models.ClothingType;
import hipshop.models.HipHopBranch;
import hipshop.models.Product;
import hipshop.repositories.ClothingRepository;

@Service
public class ClothingService {

	@Autowired
	ClothingRepository clothingRepository;
	
	public ArrayList<Clothing> getClothing(){
		return (ArrayList<Clothing>) clothingRepository.findAll();
	}
	
	public ArrayList<Clothing> getClothesByType(String name){
		ClothingType type = null;
		if(name.contentEquals("hoodies")) {
			type = ClothingType.Hoodies;
		}else if(name.contentEquals("tshirt")){
			type = ClothingType.TShirt;
		}else if(name.contentEquals("shoes")) {
			type = ClothingType.Shoes;
		}else{
			return getClothing();
		}
		return clothingRepository.findByType(type);
	}
}
