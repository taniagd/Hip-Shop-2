package hipshop.repositories;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.PurchaseOrder;

public interface PurchaseOrderRepository extends CrudRepository<PurchaseOrder, Long> {

}
