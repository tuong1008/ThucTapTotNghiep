package ptithcm.service;

import ptithcm.entity.Message;

import java.util.List;

public interface MessageService {
    void addMessage(Message message);

    void deleteMessage(Message message);

    List<Message> getAllMessage();
    List<Message> getAllMessage(int pageNumber);

    Message getMessageById(long id);

    List<Message> getAllMessageByEmail(String email);
    List<Message> getAllMessageByEmail(String email, int page);

    List<Message> getAllMessageOfUser(long customerid);
    List<Message> getAllMessageOfUser(long customerid, int page);

    long getTotalMessages();

}
