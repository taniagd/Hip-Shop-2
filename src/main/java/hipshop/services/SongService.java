package hipshop.services;


import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hipshop.models.Album;
import hipshop.models.Song;
import hipshop.repositories.SongRepository;


@Service

public class SongService {

	@Autowired
	SongRepository songRepository;
	
	public ArrayList<Song> getUsers() {
		return (ArrayList<Song>) songRepository.findAll();
	}
	
	public Song saveSong(Song song) {
		Integer songNumber = song.getSongNumber();
		
		
		if(songNumber != null ) {
			return songRepository.save(song);
		}
		
		return song;
	}
	
	public Optional<Song> getUserById(Long id) {
		return songRepository.findById(id);
	}
	
	
	public boolean deleteSong(Long id) {
		
		
		try {
			songRepository.deleteById(id); 
			return true;
		}catch(Exception error) { 
			return false;
		}
	}
	public ArrayList<Song> getUsersBySongName(String songName){
		return songRepository.findBySongName(songName);
	}
}