package hipshop.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import hipshop.models.Clothing;
import hipshop.models.ClothingType;
import hipshop.models.HipHopBranch;
import hipshop.models.Member;
import hipshop.models.Product;
import hipshop.repositories.ClothingRepository;
import hipshop.repositories.MemberRepository;
import hipshop.repositories.ProductRepository;

@Service
public class ClothingService {

	@Autowired
	ClothingRepository clothingRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	MemberRepository memberRepository;
	
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
		return clothingRepository.findByTypeClothing(type);
	}
	
	public Clothing saveClothing(Clothing clothing) {

		Object username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Member member = memberRepository.findByUsername((String) username);

		HipHopBranch branch = member.getBranch();
		
		Product product = new Product(clothing, member, branch);
		
		productRepository.save(product);
		
		return clothing;
	}
}
