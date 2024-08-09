package by.artur.service.mongoDB.service;

import by.artur.service.mongoDB.dto.UserActionDto;
import by.artur.service.mongoDB.entity.UserAction;
import by.artur.service.mongoDB.exception.NotFoundException;
import by.artur.service.mongoDB.repository.UserActionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserActionService {

    private final UserActionRepository userActionRepository;
    private final ModelMapper mapper;


    //TODO
    public UserAction getUserAction(String userId) {
        return userActionRepository.findByUserId(userId).orElseThrow(() -> new NotFoundException("Action with user not found"));
    }

    public List<UserAction> getAllActions() {
        return userActionRepository.findAll();
    }

    public void saveUserAction(UserActionDto dto) {
        UserAction userAction = mapper.map(dto, UserAction.class);
        userAction.setId(UUID.randomUUID().toString());
        log.info("{}", userAction);
        userActionRepository.save(userAction);
    }

}
