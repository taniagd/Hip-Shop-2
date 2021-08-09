package hipshop.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.HipHopBranch;
import hipshop.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	public abstract ArrayList<Product> findByBranch(HipHopBranch branch);
}
