package hipshop.repositories;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

}
