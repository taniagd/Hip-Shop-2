package hipshop.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

	public abstract ArrayList<Song> findBySongName(String songName);
}