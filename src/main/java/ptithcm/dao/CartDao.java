package ptithcm.dao;

import ptithcm.entity.Cart;
import ptithcm.entity.Product;

/**
 * @author Tuong
 */

public interface CartDao extends GenericDao<Cart> {
    Cart findOne(long cartId);

    Product checkAndUpdateProductsInCart(Cart cart);
}
