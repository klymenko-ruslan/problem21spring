package problem21spring.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import problem21spring.model.Message;


/**
 * Created by rklimemnko on 28.05.2016.
 */
@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    public Message findByMissionId(Integer id);
}