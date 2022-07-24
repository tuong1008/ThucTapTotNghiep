package ptithcm.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.CustomerOrderDao;
import ptithcm.dao.ProductDao;
import ptithcm.entity.CustomerOrder;

import java.util.List;

/**
 * @author Tuong
 */
public class CustomerOrderDaoImpl extends AbstractDao<CustomerOrder> implements CustomerOrderDao {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<CustomerOrder> findAll() {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM CustomerOrder C");

        List<CustomerOrder> list = query.list();
        t.commit();

        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public CustomerOrder findOne(long customerOrderId) {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM CustomerOrder C where C.customerOrderId = :customerOrderId");
        query.setParameter("customerOrderId", customerOrderId);

        List<CustomerOrder> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrders(Integer pageNumber) {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM CustomerOrder C");
        query.setFirstResult((pageNumber - 1) * 10); //trang 1, từ 0
        query.setMaxResults(10); //đến 9

        List<CustomerOrder> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public long getTotalCustomerOrders() {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("select count(*) FROM CustomerOrder C");
        long results = (long) query.uniqueResult();
        t.commit();

        return results;
    }

    @Override
    public List<CustomerOrder> findAllOrderByUsernameOrEmail(String searchTerm, int pageNumber) {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM CustomerOrder t WHERE t.customer.username LIKE :searchTerm OR t.customer.customerEmailAddress LIKE :searchTerm");
        query.setParameter("searchTerm", MatchMode.ANYWHERE.toMatchString(searchTerm));
        query.setFirstResult((pageNumber - 1) * 10); //trang 1, từ 0
        query.setMaxResults(10); //đến 9

        List<CustomerOrder> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public long getTotalOrderByUsernameOrEmail(String searchTerm) {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("select count(*) FROM CustomerOrder t WHERE t.customer.username LIKE :searchTerm OR t.customer.customerEmailAddress LIKE :searchTerm");
        query.setParameter("searchTerm", MatchMode.ANYWHERE.toMatchString(searchTerm));
        long results = (long) query.uniqueResult();
        t.commit();

        return results;
    }

    public long getTotalOrderByCustomerId(long customerId) {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("select count(*) FROM CustomerOrder t WHERE t.customer.customerId=:customerId");
        query.setParameter("customerId", customerId);
        long results = (long) query.uniqueResult();
        t.commit();

        return results;
    }
}
