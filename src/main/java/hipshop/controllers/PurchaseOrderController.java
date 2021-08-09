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

import hipshop.models.PurchaseOrder;
import hipshop.services.PurchaseOrderService;

@RestController
@RequestMapping("/purchaseorder")
public class PurchaseOrderController {

	@Autowired
	PurchaseOrderService purchaseOrderService;
	
	@GetMapping
	public ArrayList<PurchaseOrder> getUsers(){
		return purchaseOrderService.getPurchaseOrders();
	}
	@PostMapping
	public PurchaseOrder savePurchaseOrder(@RequestBody PurchaseOrder user) {
			return purchaseOrderService.savePurchaseOrder(user);
	}
	@GetMapping(path = "/{idPurchaseOrder}")
	public Optional<PurchaseOrder> getUserById(@PathVariable("idPurchaseOrder") Long idVariable){
		return purchaseOrderService.getUserById(idVariable);
	}
	@DeleteMapping(path = "/{idPurchaseOrder}")
	public String deletePurchaseOrder(@PathVariable("idPurchaseOrder")Long id) {
		boolean ok = purchaseOrderService.deletePurchaseOrder(id);
		if(ok) {
			return "Se eliminó la orden de compra";
		}else {
			return "No se pudo eliminar la orden de compra";
		}
	}
	
	@GetMapping("/buy")
	public PurchaseOrder buyItems(@RequestParam(value = "products", defaultValue="")String products){
		return purchaseOrderService.buyItems(products); 
	}
	
	@GetMapping("/query")
	public ArrayList<PurchaseOrder> getUsersByName(@RequestParam(value = "name", defaultValue="")String name){
		return purchaseOrderService.findByName(name); 
	}
}