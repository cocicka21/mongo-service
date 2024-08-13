package by.artur.service.mongoDB.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "user_actions")
@Data
public class UserAction {

    @Id
    private String id;

    private String userId;

    private String action;

    private LocalDateTime actionsDate;
}
