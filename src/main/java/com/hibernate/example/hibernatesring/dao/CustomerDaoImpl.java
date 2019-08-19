package com.hibernate.example.hibernatesring.dao;

import com.hibernate.example.hibernatesring.model.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * email : s.lakhmenev@andersenlab.com
 *
 * @author Lakhmenev Sergey
 * @version 1.1
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Customer> getCustomersList() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customerList = session.createQuery("from Customer").list();
        return customerList;
    }

    public Customer getCustomerById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.get(Customer.class, id);
        return customer;
    }

    public Customer addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.save(customer);
        return customer;
    }

    public void updateCustomer(Customer customer) {

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }

    public void deleteCustomerById(int id) {

        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a persistent object
            Customer customer = session.load(Customer.class, id);
            if (customer != null) {
                session.delete(customer);
                System.out.println("customer is deleted");
            }

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {
                transaction.rollback();
            }

            e.printStackTrace();
        }

        //Delete customer using NAME_QUERY

//        Session session = sessionFactory.getCurrentSession();
//        Transaction transaction = session.beginTransaction();
//        Query query = session.getNamedQuery("deleteCustomer").setParameter("id", id);
//        int rows = query.executeUpdate();
//        transaction.commit();
//        session.close();
    }
}



