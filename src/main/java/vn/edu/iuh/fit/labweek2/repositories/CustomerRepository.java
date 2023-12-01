package vn.edu.iuh.fit.labweek2.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.labweek2.models.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerRepository {
    private EntityManager cus;
    private EntityTransaction transaction;

    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    public CustomerRepository(){
        cus = Persistence.createEntityManagerFactory("lab-week-2").createEntityManager();
        transaction = cus.getTransaction();
    }
    public void insertCus(Customer customer){
        try {
            transaction.begin();
            cus.persist(customer);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public void updateCus(Customer customer){
        try {
            transaction.begin();
            cus.merge(customer);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            logger.error(e.getMessage());
        }
    }
    public Optional<Customer> findById(long id){
        TypedQuery<Customer> query = cus.createQuery("select c from Customer c where c.id = :id", Customer.class);
        query.setParameter("id", id);
        Customer customer = query.getSingleResult();
        return customer == null ? Optional.empty():Optional.of(customer);
    }
    public List<Customer> getAllCustomer(){
        return cus.createNamedQuery("Customer.findAll", Customer.class).getResultList();
    }
}
