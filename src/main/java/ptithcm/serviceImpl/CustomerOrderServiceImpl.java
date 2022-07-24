package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.CustomerOrderDao;
import ptithcm.entity.CustomerOrder;
import ptithcm.service.CustomerOrderService;

import java.util.List;

/**
 * @author Tuong
 */
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    CustomerOrderDao customerOrderDao;

    @Override
    public String addCustomerOrder(CustomerOrder customerOrder) {
        return customerOrderDao.save(customerOrder);
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrder() {
        return customerOrderDao.findAll();
    }

    @Override
    public CustomerOrder getCustomerOrderById(long l) {
        return customerOrderDao.findOne(l);
    }

    @Override
    public String removeCustomerOrder(CustomerOrder co) {
        return customerOrderDao.delete(co);
    }

    @Override
    public List<CustomerOrder> getAllCustomerOrders(Integer intgr) {
        return customerOrderDao.getAllCustomerOrders(intgr);
    }

    @Override
    public long getTotalCustomerOrders() {
        return customerOrderDao.getTotalCustomerOrders();
    }

    @Override
    public List<CustomerOrder> findAllOrderByUsernameOrEmail(String string, int i) {
        return customerOrderDao.findAllOrderByUsernameOrEmail(string, i);
    }

    @Override
    public long getTotalOrderByUsernameOrEmail(String string) {
        return customerOrderDao.getTotalOrderByUsernameOrEmail(string);
    }

    public long getTotalOrderByCustomerId(long customerId) {
        return customerOrderDao.getTotalOrderByCustomerId(customerId);
    }
}
