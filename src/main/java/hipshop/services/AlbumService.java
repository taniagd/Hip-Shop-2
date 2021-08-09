package hipshop.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hipshop.models.Album;
import hipshop.models.Product;
import hipshop.repositories.AlbumRepository;

@Service
public class AlbumService {

	@Autowired 
	AlbumRepository albumRepository; 
	public List<Album> getAlbum(){
			return (List<Album>) albumRepository.findAll();
	}
	
	public Album saveAlbum (Album album) {
		String productName = album.getProductName();
		BigDecimal price = album.getPrice();
		String image = album.getImage();
		
		if(productName != null && price !=null && image !=null) { 
			Product product = new Product(album, vendor);
			return albumRepository.save(album);
		}
		return album;
	}
	
	public Optional<Album> getAlbumById(Long id) {
		return albumRepository.findById(id);
	}
	
	public ArrayList<Album> getAlbumByProductName(String productName){
		return albumRepository.findByproductNameContaining(productName);
	}
	
	public boolean deleteAlbum(Long id) {
		try {
			albumRepository.deleteById(id);
			return true; 
		} catch (Exception error) {
			return false; 
		}
	}
}


