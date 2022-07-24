package ptithcm.service;

import ptithcm.entity.ShippingAddress;

/**
 * @author Tuong
 */
public interface ShippingAddressService {
    String addShippingAddress(ShippingAddress shippingAddress);

    String removeShippingAddress(ShippingAddress shippingAddress);
}
