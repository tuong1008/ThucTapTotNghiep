package ptithcm.service;

import ptithcm.entity.Customer;

import java.util.List;

public interface CustomerService {
    String addCustomer(Customer customer);

    String updateCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer findCustomerByUsername(String username);

    Customer getCustomerById(long customerId);

    Customer findCustomerByUsernameAndPassword(String username, String password);

    List<Customer> getAllCustomers(Integer pageNumber);

    long getTotalCustomers();

    List<Customer> findAllCustomerByUsernameOrEmail(String searchTerm, int pageNumber);

    long getTotalCustomerByUsernameOrEmail(String searchTerm);

}
