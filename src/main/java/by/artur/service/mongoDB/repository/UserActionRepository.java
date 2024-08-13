package by.artur.service.mongoDB.repository;

import by.artur.service.mongoDB.entity.UserAction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserActionRepository extends MongoRepository<UserAction, String> {

    Optional<UserAction> findByUserId(String userId);
}
