package fi.academy.drinkifyrestapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages="fi.academy.drinkifyrestapi")

public class MongoConfig extends AbstractMongoConfiguration{

    @Override
    protected String getDatabaseName() {
        // name of the database in mongo
        return "drinkify";
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        // ip and port for mongodb
        return new MongoClient("localhost", 27017);
    }
}
