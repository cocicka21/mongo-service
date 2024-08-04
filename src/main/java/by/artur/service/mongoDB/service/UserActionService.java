package by.artur.service.mongoDB.service;

import by.artur.service.mongoDB.entity.UserAction;
import by.artur.service.mongoDB.exception.NotFoundException;
import by.artur.service.mongoDB.repository.UserActionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserActionService {

    private final UserActionRepository userActionRepository;

    public UserAction getUserAction(Long userId) {
        return userActionRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("Action with user not found"));
    }

    public List<UserAction> getAllActions() {
        return userActionRepository.findAll();
    }

}
