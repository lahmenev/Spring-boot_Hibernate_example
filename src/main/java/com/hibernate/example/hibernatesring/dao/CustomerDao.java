package com.hibernate.example.hibernatesring.dao;

import com.hibernate.example.hibernatesring.model.Customer;
import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public interface CustomerDao {

    List<Customer> getCustomersList();

    Customer getCustomerById(int id);

    Customer addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomerById(int id);
}
