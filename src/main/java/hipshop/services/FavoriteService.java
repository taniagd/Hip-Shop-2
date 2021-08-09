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
	

	public Favorite saveFavorite(Favorite favorite) {
		return favoriteRepository.save(favorite);
	}
}
