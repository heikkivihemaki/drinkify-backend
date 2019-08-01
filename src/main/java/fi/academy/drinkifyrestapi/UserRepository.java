package fi.academy.drinkifyrestapi;


import fi.academy.drinkifyrestapi.classes.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);
}
