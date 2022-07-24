package ptithcm.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ptithcm.dao.CartItemDao;
import ptithcm.entity.CartItem;

import java.util.List;

/**
 * @author Tuong
 */
@Transactional
public class CartItemDaoImpl extends AbstractDao<CartItem> implements CartItemDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<CartItem> findByCartId(long cartId) {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM CartItem C WHERE C.cart.cartId = :cartId");
        query.setParameter("cartId", cartId);

        List<CartItem> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    public CartItem findOne(long cartItemId) {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM CartItem C WHERE C.cartItemId = :cartItemId");
        query.setParameter("cartItemId", cartItemId);

        List<CartItem> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public void removeAllByCartId(long cartId) {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("delete CartItem c where c.cart.cartId = :id");
        query.setParameter("id", cartId);

        int result = query.executeUpdate();
        t.commit();
        if (result > 0) {
            System.out.println("Expensive CartItem was removed");
        }
    }
}
