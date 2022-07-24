package ptithcm.service;

import ptithcm.entity.CustomerOrder;

import java.util.List;

/**
 * @author Tuong
 */
public interface CustomerOrderService {
    String addCustomerOrder(CustomerOrder customerOrder);

    CustomerOrder getCustomerOrderById(long customerOrderId);

    String removeCustomerOrder(CustomerOrder customerOrder);

    List<CustomerOrder> getAllCustomerOrder();

    List<CustomerOrder> getAllCustomerOrders(Integer pageNumber);

    long getTotalCustomerOrders();

    List<CustomerOrder> findAllOrderByUsernameOrEmail(String searchTerm, int pageNumber);

    long getTotalOrderByUsernameOrEmail(String searchTerm);

    long getTotalOrderByCustomerId(long customerId);
}
