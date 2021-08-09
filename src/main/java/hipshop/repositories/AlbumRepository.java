package hipshop.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {
	public abstract ArrayList<Album> findByproductNameContaining(String productName);
}
