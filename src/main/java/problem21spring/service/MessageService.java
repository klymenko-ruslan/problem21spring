package problem21spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import problem21spring.model.Message;
import problem21spring.repository.MessageRepository;
import problem21spring.util.NumberUtil;

import java.util.stream.IntStream;

/**
 * Created by rklimemnko on 28.05.2016.
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Integer handleMessage(Message message) {
        if (messageRepository.findByMissionId(message.getMissionId()) != null)
            throw new DuplicateKeyException("Not unique id!");
        messageRepository.save(message);
        return NumberUtil.amicableNumbersSum(message.getSeed());
    }

}
