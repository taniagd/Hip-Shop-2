package hipshop.repositories;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Favorite;

public interface FavoriteRepository extends CrudRepository<Favorite, Long>{

}
