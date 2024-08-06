package by.artur.service.mongoDB.service;

import by.artur.service.mongoDB.dto.UserActionDto;
import by.artur.service.mongoDB.entity.UserAction;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static by.artur.service.mongoDB.utils.StringUtil.MQ_QUEUE_NAME;

@Service
@RequiredArgsConstructor
@Slf4j
public class MQService {

    private final UserActionService userActionService;
    private final ModelMapper mapper;

    @RabbitListener(queues = MQ_QUEUE_NAME)
    public void listen(UserActionDto dto) {
        log.info("Message from mq : {}", dto);
        UserAction userAction = mapper.map(dto, UserAction.class);
        userAction.setId(UUID.randomUUID().toString());
        log.info("user action from mq : {}", userAction);
//        userActionService.saveUserAction(userAction);
    }

}
