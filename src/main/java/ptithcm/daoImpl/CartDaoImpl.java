package ptithcm.daoImpl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ptithcm.dao.CartDao;
import ptithcm.entity.Cart;
import ptithcm.entity.CartItem;
import ptithcm.entity.Product;
import ptithcm.service.ProductService;

import java.util.List;

/**
 * @author Tuong
 */
@Transactional
public class CartDaoImpl extends AbstractDao<Cart> implements CartDao {

    @Autowired
    ProductService productService;

    @Override
    public Cart findOne(long cartId) {
        Session session = sessionFactory.getCurrentSession();
                Transaction t = session.beginTransaction();
        Query query = session.createQuery("FROM Cart C WHERE C.cartId = :cartId");
        query.setParameter("cartId", cartId);

        List<Cart> list = query.list();
        t.commit();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    //use when create order
    @Override
    public Product checkAndUpdateProductsInCart(Cart cart) {
        List<CartItem> cartItems = cart.getCartItem();
        Session session = sessionFactory.getCurrentSession();
        Transaction t = session.beginTransaction();

        for (CartItem cartItem : cartItems) {
            //Tìm lại trong CSDL để có được UnitInStock chính xác

            Query query = session.createQuery("FROM Product P where P.productId = :id");
            query.setParameter("id", cartItem.getProduct().getProductId());
            List<Product> list = query.list();
            Product product = list.get(0);

            int unitInStock = product.getUnitInStock() - cartItem.getQuantity();
            if (unitInStock >= 0) {
                //update unit in stock of product
                product.setUnitInStock(unitInStock);
                session.update(product);
            } else {
                t.rollback();
                return product;
            }
        }
        t.commit();
        if (session.isOpen()) {
            session.close();
        }
        return null;
    }
}
