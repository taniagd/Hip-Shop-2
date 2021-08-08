package hipshop.repositories;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Album;

public interface AlbumRepository extends CrudRepository<Album, Long> {

}
