package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ItemRepository extends MongoRepository<Item, String> {
    public List<Item> findAllByName(String name);
    public List<Item> findAllByAvailableTrue();

}
