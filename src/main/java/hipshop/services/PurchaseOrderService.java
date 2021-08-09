package hipshop.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import hipshop.models.Member;
import hipshop.models.Product;
import hipshop.models.ProductType;
import hipshop.models.PurchaseOrder;
import hipshop.models.PurchaseOrderItem;
import hipshop.repositories.MemberRepository;
import hipshop.repositories.ProductRepository;
import hipshop.repositories.PurchaseOrderItemRepository;
import hipshop.repositories.PurchaseOrderRepository;


@Service
public class PurchaseOrderService {

	@Autowired
	PurchaseOrderRepository purchaseOrderRepository;
	@Autowired
	PurchaseOrderItemRepository purchaseOrderItemRepository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ProductRepository productRepository;
	
	
	public ArrayList<PurchaseOrder> getPurchaseOrders() {
		return (ArrayList<PurchaseOrder>) purchaseOrderRepository.findAll();
	}
	
	public PurchaseOrder savePurchaseOrder(PurchaseOrder purchaseOrder) {
		String address = purchaseOrder.getAddress();
		String guideNumber = purchaseOrder.getGuideNumber();
		String packageStatus = purchaseOrder.getPackageStatus();
		
		
		if( address != null && guideNumber!= null && packageStatus != null ) {
			return purchaseOrderRepository.save(purchaseOrder);
		}
		
		return purchaseOrder;
	}
	
	public Optional<PurchaseOrder> getUserById(Long id) {
		return purchaseOrderRepository.findById(id);
	}
	
	public ArrayList<PurchaseOrder> findByName(String name){
		return purchaseOrderRepository.findByAddress(name);
	}
	
	public PurchaseOrder buyItems(String items) {
		String[] idsProducts = items.split(",");
		ArrayList<Long> idsProductsLong = new ArrayList<Long>();
		ArrayList<Product> products = new ArrayList<Product>();
//		ArrayList<PurchaseOrderItem> purchaseOrderItem = new ArrayList<PurchaseOrderItem>();
		
		for(int i = 0; i < idsProducts.length; i++) {
			idsProductsLong.add(Long.parseLong(idsProducts[i]));
		}
		
		Object username = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		Member member = memberRepository.findByUsername((String) username);
		
		Iterator<Long> iter = idsProductsLong.iterator();
	    while (iter.hasNext()) {
	    	products.add(productRepository.findById(iter.next()).get());
	    }
	    
	    Iterator<Product> product = products.iterator();
	    BigDecimal total = new BigDecimal("0");
	    while (product.hasNext()) {
	    	total = total.add(product.next().getProduct().getPrice());
	    }
	    
		PurchaseOrder purchase = new PurchaseOrder(total, member);
		
		Iterator<Product> productsItem = products.iterator();
		while (productsItem.hasNext()) {
			PurchaseOrderItem item = new PurchaseOrderItem(purchase, productsItem.next(), productsItem.next().getProduct().getPrice());
			purchaseOrderItemRepository.save(item);
	    }
		
		purchaseOrderRepository.save(purchase);
		
		return purchase;
	}
	
	
	public boolean deletePurchaseOrder(Long id) {
		
		
		try {
			purchaseOrderRepository.deleteById(id); 
			return true;
		}catch(Exception error) { 
			return false;
		}
	}
	public ArrayList<PurchaseOrder> getUsersByUser(Member user){
		return purchaseOrderRepository.findByUser(user);
	}
}