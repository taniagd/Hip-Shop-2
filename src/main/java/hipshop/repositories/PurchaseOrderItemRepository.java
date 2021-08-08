package hipshop.repositories;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.PurchaseOrderItem;

public interface PurchaseOrderItemRepository extends CrudRepository<PurchaseOrderItem, Long> {

}
