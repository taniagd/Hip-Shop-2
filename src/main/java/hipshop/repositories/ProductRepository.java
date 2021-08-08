package hipshop.repositories;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
