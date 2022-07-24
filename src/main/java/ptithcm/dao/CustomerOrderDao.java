package ptithcm.dao;

import ptithcm.entity.CustomerOrder;

import java.util.List;

/**
 * @author Tuong
 */
public interface CustomerOrderDao extends GenericDao<CustomerOrder> {
    List<CustomerOrder> findAll();

    CustomerOrder findOne(long customerOrderId);

    List<CustomerOrder> getAllCustomerOrders(Integer pageNumber);

    long getTotalCustomerOrders();

    List<CustomerOrder> findAllOrderByUsernameOrEmail(String searchTerm, int pageNumber);

    long getTotalOrderByUsernameOrEmail(String searchTerm);

    long getTotalOrderByCustomerId(long customerId);
}
