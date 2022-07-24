package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ptithcm.dao.CustomerDao;
import ptithcm.entity.Customer;
import ptithcm.service.CustomerService;

import java.util.List;

@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerDao customerDao;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public String addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    @Override
    public String updateCustomer(Customer customer) {
        return customerDao.update(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    @Override
    public Customer findCustomerByUsername(String username) {
        return customerDao.findByUsername(username);
    }

    @Override
    public Customer getCustomerById(long customerId) {
        return customerDao.findById(customerId);
    }

    @Override
    public Customer findCustomerByUsernameAndPassword(String username, String password) {
        return customerDao.findByUsernameAndPassword(username, password);
    }

    @Override
    public List<Customer> getAllCustomers(Integer intgr) {
        return customerDao.getAllCustomers(intgr);
    }

    @Override
    public long getTotalCustomers() {
        return customerDao.getTotalCustomers();
    }

    @Override
    public List<Customer> findAllCustomerByUsernameOrEmail(String string, int i) {
        return customerDao.findAllCustomerByUsernameOrEmail(string, i);
    }

    @Override
    public long getTotalCustomerByUsernameOrEmail(String string) {
        return customerDao.getTotalCustomerByUsernameOrEmail(string);
    }
}
