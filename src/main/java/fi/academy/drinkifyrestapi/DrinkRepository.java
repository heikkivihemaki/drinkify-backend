package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Drink;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface DrinkRepository extends MongoRepository<Drink, String> {
    public List<Drink> findAllByName(String name);
    public List<Drink> findAllByVirginTrue();

}
