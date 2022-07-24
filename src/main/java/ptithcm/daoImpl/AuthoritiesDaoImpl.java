package ptithcm.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ptithcm.dao.AuthoritiesDao;
import ptithcm.entity.Authorities;

import java.util.List;

/**
 * @author Tuong
 */
public class AuthoritiesDaoImpl extends AbstractDao<Authorities> implements AuthoritiesDao {

    @Override
    public Authorities findOne(String username) {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM Authorities A WHERE A.username = :username");
        query.setParameter("username", username);

        List<Authorities> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
