package hipshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hipshop.models.Album;
import hipshop.services.AlbumService;

@RestController
@RequestMapping("/album")
public class AlbumController {

	@Autowired
	AlbumService albumService;
	
	
	@PostMapping
	public Album saveAlbum(@RequestBody Album album) {
		return albumService.saveAlbum(album);
	}
}
