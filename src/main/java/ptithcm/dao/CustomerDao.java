package ptithcm.dao;

import ptithcm.entity.Customer;

import java.util.List;

public interface CustomerDao extends GenericDao<Customer> {
    Customer findByUsername(String username);

    Customer findByUsernameAndPassword(String username, String password);

    Customer findById(long customerId);

    List<Customer> findAll();

    List<Customer> getAllCustomers(int pageNumber);

    long getTotalCustomers();

    List<Customer> findAllCustomerByUsernameOrEmail(String searchTerm, int pageNumber);

    long getTotalCustomerByUsernameOrEmail(String searchTerm);

    String update(Customer customer);
}
