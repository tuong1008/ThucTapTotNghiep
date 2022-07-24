package ptithcm.service;

import ptithcm.entity.CartItem;

import java.util.List;

/**
 * @author Tuong
 */
public interface CartItemService {
    String addCartItem(CartItem cartItem);

    String updateCartItem(CartItem cartItem);

    String deleteCartItem(CartItem cartItem);

    List<CartItem> findItemsByCartId(long cartId);

    CartItem findItemById(long cartItemId);

    void removeAllCartItems(long cartId);
}
