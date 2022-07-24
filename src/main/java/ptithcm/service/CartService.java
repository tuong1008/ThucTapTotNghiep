package ptithcm.service;

import ptithcm.entity.Cart;
import ptithcm.entity.Product;

/**
 * @author Tuong
 */
public interface CartService {
    String addCart(Cart cart);

    String updateCart(Cart cart);

    String removeCart(Cart cart);

    Cart getCartById(long cartId);

    Product checkAndUpdateProductsInCart(Cart cart);
}
