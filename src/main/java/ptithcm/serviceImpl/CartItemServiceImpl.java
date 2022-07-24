package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.CartItemDao;
import ptithcm.entity.CartItem;
import ptithcm.service.CartItemService;

import java.util.List;

/**
 * @author Tuong
 */
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemDao cartItemDao;

    @Override
    public String addCartItem(CartItem cartItem) {
        return cartItemDao.save(cartItem);
    }

    @Override
    public List<CartItem> findItemsByCartId(long l) {
        return cartItemDao.findByCartId(l);
    }

    @Override
    public String updateCartItem(CartItem cartItem) {
        return cartItemDao.update(cartItem);
    }

    @Override
    public CartItem findItemById(long l) {
        return cartItemDao.findOne(l);
    }

    @Override
    public String deleteCartItem(CartItem cartItem) {
        return cartItemDao.delete(cartItem);
    }

    @Override
    public void removeAllCartItems(long l) {
        cartItemDao.removeAllByCartId(l);
    }
}
