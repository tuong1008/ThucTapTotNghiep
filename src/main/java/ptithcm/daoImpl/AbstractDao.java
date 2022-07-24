package ptithcm.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ptithcm.dao.GenericDao;

/**
 * @author Tuong
 */
@Transactional
public class AbstractDao<T> implements GenericDao<T> {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public String save(T object) {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            session.save(object);
            t.commit();
        } catch (ConstraintViolationException e) {
            t.rollback();
            return e.getSQLException().getMessage();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public String update(T object) {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            session.update(object);
            t.commit();
        } catch (ConstraintViolationException e) {
            t.rollback();
            return e.getSQLException().getMessage();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

    @Override
    public String delete(T object) {
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();
        try {
            session.delete(object);
            t.commit();
        } catch (Exception e) {
            t.rollback();
            return e.getMessage();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return null;
    }

}
