package hipshop.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Member;
import hipshop.models.PurchaseOrder;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Long> {
	public abstract ArrayList<PurchaseOrder> findByAddress(String address);
	public abstract ArrayList<PurchaseOrder> findByUser(Member user);
}
