package ptithcm.dao;

import ptithcm.entity.CartItem;

import java.util.List;

/**
 * @author Tuong
 */
public interface CartItemDao extends GenericDao<CartItem> {
    List<CartItem> findByCartId(long cartId);

    void removeAllByCartId(long cartId);

    CartItem findOne(long cartItemId);
}
