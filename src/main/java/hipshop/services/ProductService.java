package hipshop.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import hipshop.models.HipHopBranch;
import hipshop.models.Product;
import hipshop.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public ArrayList<Product> getProducts(){
		return (ArrayList<Product>) productRepository.findAll();
	}
	
	public ArrayList<Product> getProductsByBranch(String name){
		HipHopBranch hipHopBranch = null;
		if(name.contentEquals("RapFreestyle")) {
			hipHopBranch = HipHopBranch.RapFreestyle;
		}else if(name.contentEquals("Breaking")){
			hipHopBranch = HipHopBranch.Breaking;
		}else if(name.contentEquals("DjBeatmakers")) {
			hipHopBranch = HipHopBranch.DJBeatmaker;
		}else if(name.contentEquals("Graffiti")) {
			hipHopBranch = HipHopBranch.Graffiti;
		}else {
			return getProducts();
		}
		return productRepository.findByBranch(hipHopBranch);
	}
}
