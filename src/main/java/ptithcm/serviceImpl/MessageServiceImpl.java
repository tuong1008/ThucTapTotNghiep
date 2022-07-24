package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.MessageDao;
import ptithcm.entity.Message;
import ptithcm.service.MessageService;

import java.util.List;

public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageDao messageDao;

    @Override
    public void addMessage(Message message) {
        messageDao.save(message);
    }

    @Override
    public void deleteMessage(Message message) {
        messageDao.delete(message);
    }

    @Override
    public List<Message> getAllMessage() {
        return messageDao.getAllMessages();
    }

    @Override
    public List<Message> getAllMessage(int pageNumber) {
        return messageDao.getAllMessages();
    }

    @Override
    public Message getMessageById(long id) {
        return messageDao.findById(id);
    }

    @Override
    public List<Message> getAllMessageByEmail(String email) {
        return messageDao.getAllMessagesByEmail(email);
    }

    @Override
    public List<Message> getAllMessageByEmail(String email, int page) {
        return messageDao.getAllMessagesByEmail(email, page);
    }

    @Override
    public List<Message> getAllMessageOfUser(long customerid) {
        return messageDao.getAllMessagesByUserId(customerid);
    }

    @Override
    public List<Message> getAllMessageOfUser(long customerid, int page) {
        return messageDao.getAllMessagesByUserId(customerid, page);
    }

    @Override
    public long getTotalMessages() {
        return messageDao.getTotalMessages();
    }
}
