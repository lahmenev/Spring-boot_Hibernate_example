package com.hibernate.example.hibernatesring.service;

import com.hibernate.example.hibernatesring.dao.CustomerDao;
import com.hibernate.example.hibernatesring.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    /**
     * Gets customers
     * @return
     */
    public List<Customer> getAllCustomers() {
        return customerDao.getCustomersList();
    }

    public Customer getCustomer(int id) {
        return customerDao.getCustomerById(id);
    }

    public Customer addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        customerDao.deleteCustomerById(id);
    }
}
