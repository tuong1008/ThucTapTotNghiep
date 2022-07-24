package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.BillingAddressDao;
import ptithcm.entity.BillingAddress;
import ptithcm.service.BillingAddressService;

/**
 * @author Tuong
 */
public class BillingAddressServiceImpl implements BillingAddressService {

    @Autowired
    BillingAddressDao billingAddressDao;

    @Override
    public String addBillingAddress(BillingAddress billingAddress) {
        return billingAddressDao.save(billingAddress);
    }

    @Override
    public String removeBillingAddress(BillingAddress billingAddress) {
        return billingAddressDao.delete(billingAddress);
    }
}
