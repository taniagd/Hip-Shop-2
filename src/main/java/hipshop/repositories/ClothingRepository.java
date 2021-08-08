package hipshop.repositories;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Clothing;

public interface ClothingRepository extends CrudRepository<Clothing, Long> {

}
