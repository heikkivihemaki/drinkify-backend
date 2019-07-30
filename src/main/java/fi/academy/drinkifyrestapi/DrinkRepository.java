package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Drink;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrinkRepository extends MongoRepository<Drink, String> {
}
