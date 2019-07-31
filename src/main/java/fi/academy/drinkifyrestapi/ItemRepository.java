package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ItemRepository extends MongoRepository<Item, String> {
    List<Item> findAllByName(String name);
    List<Item> findAllByAvailableTrue();
    List<Item> findAllByCategory(String category);

    List<Item> findAllByCategoryAndAvailableTrue(String category);
}
