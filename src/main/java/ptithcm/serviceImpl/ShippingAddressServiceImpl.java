package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.ShippingAddressDao;
import ptithcm.entity.ShippingAddress;
import ptithcm.service.ShippingAddressService;

/**
 * @author Tuong
 */
public class ShippingAddressServiceImpl implements ShippingAddressService {

    @Autowired
    ShippingAddressDao shippingAddressDao;

    @Override
    public String addShippingAddress(ShippingAddress shippingAddress) {
        return shippingAddressDao.save(shippingAddress);
    }

    @Override
    public String removeShippingAddress(ShippingAddress shippingAddress) {
        return shippingAddressDao.delete(shippingAddress);
    }
}
