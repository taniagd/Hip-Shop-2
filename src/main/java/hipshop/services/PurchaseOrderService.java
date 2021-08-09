package hipshop.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hipshop.models.Member;
import hipshop.models.PurchaseOrder;
import hipshop.repositories.PurchaseOrderRepository;


@Service
public class PurchaseOrderService {

	@Autowired
	PurchaseOrderRepository purchaseOrderRepository;
	
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