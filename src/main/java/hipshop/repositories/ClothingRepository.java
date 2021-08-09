package hipshop.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Clothing;
import hipshop.models.ClothingType;

public interface ClothingRepository extends CrudRepository<Clothing, Long> {
	public abstract ArrayList<Clothing> findByTypeClothing(ClothingType type);
}
