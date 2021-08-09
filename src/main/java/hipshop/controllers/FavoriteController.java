package hipshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hipshop.models.Favorite;
import hipshop.services.FavoriteService;

@RestController
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;

	@GetMapping("/favorite")
	public Favorite saveFavorite (Favorite favorite) {
		return favoriteService.saveFavorite(favorite);
	}
}
