package by.artur.service.mongoDB.repository;

import by.artur.service.mongoDB.entity.UserAction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserActionRepository extends MongoRepository<UserAction, String> {

    Optional<UserAction> findByUserId(Long userId);
}
