package com.hibernate.example.hibernatesring.controller;

import com.hibernate.example.hibernatesring.model.Customer;
import com.hibernate.example.hibernatesring.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping(value = "/getAllCustomers")
    public String getAllCustomers(Model model) {
        List<Customer> listOfCustomers = customerService.getAllCustomers();
        model.addAttribute("customer", new Customer());
        model.addAttribute("listOfCustomers", listOfCustomers);
        return "customerDetails";
    }

    @GetMapping(value = "/getCustomer/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomer(id);
    }

    @PostMapping(value = "/addCustomer")
    public String addCustomer(@ModelAttribute("customer") Customer customer) {

        if(customer.getId() == 0) {
            customerService.addCustomer(customer);
        } else {
            customerService.updateCustomer(customer);
        }

        return "redirect:/getAllCustomers";
    }

    @GetMapping(value = "/updateCustomer/{id}")
    public String updateCustomer(@PathVariable("id") int id,Model model) {
        model.addAttribute("customer", this.customerService.getCustomer(id));
        model.addAttribute("listOfCustomers", this.customerService.getAllCustomers());
        return "customerDetails";
    }

    @GetMapping(value = "/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable("id") int id) {
        customerService.deleteCustomer(id);
        return "redirect:/getAllCustomers";
    }
}
