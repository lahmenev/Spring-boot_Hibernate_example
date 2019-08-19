package com.hibernate.example.hibernatesring.service;

import com.hibernate.example.hibernatesring.model.Customer;

import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomer(int id);

    Customer addCustomer(Customer customer);

    void updateCustomer(Customer customer);

    void deleteCustomer(int id);
}
