package ptithcm.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.MessageDao;
import ptithcm.entity.Message;
import ptithcm.service.MessageService;
import java.util.List;

public class MessageDaoImpl extends AbstractDao<Message> implements MessageDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    MessageService messageService;

    @Override
    public Message findById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM Message m WHERE m.id = :id");
        query.setParameter("id", id);

        List<Message> list = query.list();
        t.commit();

        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<Message> getAllMessages() {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();

        Query query = session.createQuery("FROM Message m");
        List<Message> list = query.list();
        t.commit();

        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Message> getAllMessages(int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM Message m");

        query.setFirstResult((pageNumber - 1) * 10);
        query.setMaxResults(10);

        List<Message> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Message> getAllMessagesByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM Message m WHERE m.email=:email");
        query.setParameter("email", MatchMode.ANYWHERE.toMatchString(email));

        List<Message> list = query.list();
        t.commit();

        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Message> getAllMessagesByEmail(String email, int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM Message m WHERE m.email=:email");
        query.setParameter("email", MatchMode.ANYWHERE.toMatchString(email));

        query.setFirstResult((pageNumber - 1) * 10);
        query.setMaxResults(10);

        List<Message> list = query.list();
        t.commit();

        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Message> getAllMessagesByUserId(long id) {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM Message m WHERE m.customerId=:id");
        query.setParameter("id", id);

        List<Message> list = query.list();
        t.commit();

        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public List<Message> getAllMessagesByUserId(long id, int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM Message m WHERE m.customerId=:id");
        query.setParameter("id", id);

        query.setFirstResult((pageNumber - 1) * 10);
        query.setMaxResults(10);

        List<Message> list = query.list();
        t.commit();

        if (list.isEmpty()) {
            return null;
        }
        return list;
    }


    @Override
    public long getTotalMessages() {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        Query query = session.createQuery("select count(*) FROM Message m");
        long results = (long) query.uniqueResult();
        t.commit();

        return results;
    }
}
