package by.artur.service.mongoDB.service;

import by.artur.service.mongoDB.dto.UserActionDto;
import by.artur.service.mongoDB.utils.StringUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaConsumerService {

    private final ModelMapper mapper;

//    @KafkaListener(topics = StringUtil.TOPIC_NAME, groupId = "id1", containerFactory = "filterItemKafkaListenerContainerFactory")
//    public void getData(ConsumerRecord<String, UserActionDto> data) {
//        log.info("{}", data.value());
//        String d = String.valueOf(data.value().getAction());
//        log.info("{}", d);
//        UserActionDto dt1 = mapper.map(data.value(), UserActionDto.class);
//        log.info("{}", dt1);
//        UserActionDto dto = new UserActionDto();
//        dto.setAction(data.value().getAction());
//        dto.setDate(data.value().getDate());
//        dto.setUserId(data.value().getUserId());
//        log.info("{}", dto);
//    }

    @KafkaListener(topics = StringUtil.TOPIC_NAME, groupId = "id1", containerFactory = "filterItemKafkaListenerContainerFactory")
    public void getData(UserActionDto data) {
        log.info("{}", data);
    }
}

