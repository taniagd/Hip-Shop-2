package hipshop.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Favorite;

public interface FavoriteRepository extends CrudRepository<Favorite, Long>{

	public abstract ArrayList<Favorite> findByProductName ();
	
} 
