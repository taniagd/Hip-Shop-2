package hipshop.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import hipshop.models.Product;
import hipshop.models.PurchaseOrder;
import hipshop.models.Member;
import hipshop.models.Album;
import hipshop.models.Clothing;
import hipshop.repositories.AlbumRepository;
import hipshop.repositories.ProductRepository;
import hipshop.repositories.MemberRepository;
import hipshop.repositories.PurchaseOrderRepository;
import hipshop.services.ClothingService;
import hipshop.services.MemberService;
import hipshop.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	/*
	 * Dependency injection by constructor
	 */
	private ProductService productService;
	private ClothingService clothingService;
	public ProductController(ProductService productService,  ClothingService clothingService) {
		this.productService = productService;
		this.clothingService = clothingService;
	}
	
	/*
	 * Get all products from vendors available
	 */
	@GetMapping
	public ArrayList<Product> getProducts(){
		return productService.getProducts();
	}
	
	/*
	 * Get by branch of hip hop
	 * RapFreestyle, Breaking, DJBeatmaker, Graffiti
	 * 0             1         2            3
	 */
	@GetMapping("/branch")
	public ArrayList<Product> getProductsByBranch(@RequestParam(value = "branch", defaultValue="") String name){
		return productService.getProductsByBranch(name);
	}
	/*
	 * Get by type of cloth
	 * Hoodies, TShirt, Shoes
	 * 0        1       2   
	 */
	@GetMapping("/clothing")
	public ArrayList<Clothing> getClothesByType(@RequestParam(value = "type", defaultValue="") String name){
		return clothingService.getClothesByType(name);
	}
	/*
	 * Get by type of cloth
	 * Hoodies, TShirt, Shoes
	 * 0        1       2   
	 */
	@GetMapping(path = "/{id}")
	public Optional<Product> getProductById(@PathVariable("id") Long id){
		return productService.getProductById(id);
	}
	

	
	@GetMapping("/vendor")
	@PreAuthorize("hasAuthority('VENDOR')")
	public String esVendor(){
		return "ES vendor";
	}
}
