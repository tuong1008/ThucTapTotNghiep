package ptithcm.service;

import ptithcm.entity.BillingAddress;

/**
 * @author Tuong
 */
public interface BillingAddressService {
    String addBillingAddress(BillingAddress billingAddress);

    String removeBillingAddress(BillingAddress billingAddress);
}
