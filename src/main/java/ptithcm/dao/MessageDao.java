package ptithcm.dao;

import ptithcm.entity.Message;

import java.util.List;

public interface MessageDao extends GenericDao<Message> {

    Message findById(long id);

    List<Message> getAllMessages();
    List<Message> getAllMessages(int page);

    List<Message> getAllMessagesByEmail(String email);
    List<Message> getAllMessagesByEmail(String email, int page);

    List<Message> getAllMessagesByUserId(long id);
    List<Message> getAllMessagesByUserId(long id, int page);

    long getTotalMessages();

    String save(Message message);

}
