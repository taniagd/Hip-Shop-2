package hipshop.repositories;

import org.springframework.data.repository.CrudRepository;

import hipshop.models.Card;

public interface CardRepository extends CrudRepository<Card, Long> {

}
