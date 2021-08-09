package hipshop.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import hipshop.models.Favorite;
import hipshop.services.FavoriteService;

@RestController
public class FavoriteController {

	@GetMapping("/favorite")
	public Favorite saveFavorite (Favorite favorite) {
		return FavoriteService.saveFavorite(favorite);
	}
}
