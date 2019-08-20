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
     *
     * @return List of customers
     */
    public List<Customer> getAllCustomers() {
        return customerDao.getCustomersList();
    }

    /**
     * Gets customer
     *
     * @param id input parameter
     * @return return object of Customer
     */
    public Customer getCustomer(int id) {
        return customerDao.getCustomerById(id);
    }

    /**
     * Adds customer
     *
     * @param customer input parameter
     * @return object of Customer
     */
    public Customer addCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }

    /**
     * Update customer
     *
     * @param customer input parameter
     */
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    /**
     * Delete customers
     *
     * @param id input parameter
     */
    public void deleteCustomer(int id) {
        customerDao.deleteCustomerById(id);
    }
}
