package hipshop.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hipshop.models.Favorite;
import hipshop.repositories.FavoriteRepository;

@Service
public class FavoriteService {

	@Autowired
	FavoriteRepository favoriteRepository;
	
	public ArrayList<Favorite> getFavoriteByProduct(String favorite) {
		return (ArrayList<Favorite>)favoriteRepository.findByProductName();
	}

	public static Favorite saveFavorite(Favorite favorite) {
		// TODO Auto-generated method stub
		return null;
	}
}
