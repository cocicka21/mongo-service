package by.artur.service.mongoDB.service;

import by.artur.service.mongoDB.entity.UserAction;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

import static by.artur.service.mongoDB.utils.StringUtil.MQ_QUEUE_NAME;

@Service
@RequiredArgsConstructor
@Slf4j
public class MQService {

    private final UserActionService userActionService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = {MQ_QUEUE_NAME})
    public void listen(Object dto) throws IOException {
        log.info("Message from mq : {}", dto);
        UserAction userAction = objectMapper.readValue((byte[]) dto, UserAction.class);
        log.info("UserAction from mq : {}", userAction);
        userAction.setId(UUID.randomUUID().toString());
        log.info("user action from mq : {}", userAction);
        userActionService.saveUserAction(userAction);
    }

}
