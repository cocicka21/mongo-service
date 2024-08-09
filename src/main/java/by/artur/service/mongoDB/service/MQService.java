package by.artur.service.mongoDB.service;

import by.artur.service.mongoDB.dto.UserActionDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static by.artur.service.mongoDB.utils.StringUtil.MQ_QUEUE_NAME;

@Service
@RequiredArgsConstructor
@Slf4j
public class MQService {

    private final UserActionService userActionService;
    private final ObjectMapper objectMapper;

    @RabbitListener(queues = {MQ_QUEUE_NAME})
    public void listen(Object object) throws IOException {
        log.info("Message from mq : {}", object);
        UserActionDto dto = objectMapper.readValue((byte[]) object, UserActionDto.class);
        userActionService.saveUserAction(dto);
    }

}
