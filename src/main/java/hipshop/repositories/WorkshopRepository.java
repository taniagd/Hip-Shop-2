package hipshop.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Workshop;

public interface WorkshopRepository extends CrudRepository<Workshop, Long> {
	public abstract ArrayList<Workshop> findByName(String name);
}
