package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.CartDao;
import ptithcm.entity.Cart;
import ptithcm.entity.Product;
import ptithcm.service.CartService;

/**
 * @author Tuong
 */
public class CartServiceImpl implements CartService {

    @Autowired
    CartDao cartDao;

    @Override
    public String addCart(Cart cart) {
        return cartDao.save(cart);
    }

    @Override
    public Cart getCartById(long cartId) {
        return cartDao.findOne(cartId);
    }

    @Override
    public String updateCart(Cart cart) {
        return cartDao.update(cart);
    }

    @Override
    public String removeCart(Cart cart) {
        return cartDao.delete(cart);
    }

    @Override
    public Product checkAndUpdateProductsInCart(Cart cart) {
        return cartDao.checkAndUpdateProductsInCart(cart);
    }
}
