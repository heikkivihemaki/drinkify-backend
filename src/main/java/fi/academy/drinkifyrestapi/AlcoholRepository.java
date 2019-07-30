package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Alcohol;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlcoholRepository extends MongoRepository<Alcohol, String> {
}
