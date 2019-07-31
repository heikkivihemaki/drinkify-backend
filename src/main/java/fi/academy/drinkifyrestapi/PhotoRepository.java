package fi.academy.drinkifyrestapi;

import fi.academy.drinkifyrestapi.classes.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo, String> { }
