package fi.academy.drinkifyrestapi;


import fi.academy.drinkifyrestapi.classes.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * UserRepository rajapinnan avulla tehdään kyselyitä User-collectioniin
 */
public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findUserByEmail(String email);

}
