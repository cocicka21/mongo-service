package by.artur.service.mongoDB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class MongoApp {

	public static void main(String[] args) {
		SpringApplication.run(MongoApp.class, args);
	}

}
