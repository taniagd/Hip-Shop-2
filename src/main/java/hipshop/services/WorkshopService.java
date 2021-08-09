package hipshop.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import hipshop.models.HipHopBranch;
import hipshop.models.Member;
import hipshop.models.Product;
import hipshop.models.Workshop;
import hipshop.repositories.MemberRepository;
import hipshop.repositories.ProductRepository;
import hipshop.repositories.WorkshopRepository;

@Service
public class WorkshopService {

	@Autowired
	WorkshopRepository workshopRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	MemberRepository memberRepository;
	
	public ArrayList<Workshop> getWorkshop() {
		return (ArrayList<Workshop>) workshopRepository.findAll();
	}
	
	public Workshop saveWorkshop(Workshop workshop) {
		Object username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Member member = memberRepository.findByUsername((String) username);
		
		HipHopBranch branch = member.getBranch();
		
		Product product = new Product(workshop, member, branch);
		
		productRepository.save(product);
		return workshop;
		//return workshopRepository.save(workshop);		
	}
	
	public Optional<Workshop> getUserById(Long id) {
		return workshopRepository.findById(id);
	}
	
	
	public boolean deleteWorkshop(Long id) {
		
		
		try {
			workshopRepository.deleteById(id); 
			return true;
		}catch(Exception error) { 
			return false;
		}
	}
}