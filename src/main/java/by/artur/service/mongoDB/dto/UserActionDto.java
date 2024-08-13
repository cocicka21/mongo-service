package by.artur.service.mongoDB.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserActionDto {

    private String userId;

    private String action;

    private LocalDateTime actionsDate;

}
