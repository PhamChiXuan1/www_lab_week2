package vn.edu.iuh.fit.labweek2.services;

import vn.edu.iuh.fit.labweek2.models.Customer;
import vn.edu.iuh.fit.labweek2.repositories.CustomerRepository;

import java.util.List;
import java.util.Optional;

public class CustomerService {
    private CustomerRepository customerRepository;
    public CustomerService(){
        customerRepository = new CustomerRepository();
    }
    public void insertCust(Customer customer){
        customerRepository.insertCus(customer);
    }

    public void updateCust(Customer customer){
        customerRepository.updateCus(customer);
    }

    public Optional<Customer> findById(long id){
        return customerRepository.findById(id);
    }

    public List<Customer> getAll(){
        return customerRepository.getAllCustomer();
    }
}
