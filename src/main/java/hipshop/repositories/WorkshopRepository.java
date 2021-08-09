package hipshop.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hipshop.models.Workshop;

@Repository
public interface WorkshopRepository extends CrudRepository<Workshop, Long> {
	
}
