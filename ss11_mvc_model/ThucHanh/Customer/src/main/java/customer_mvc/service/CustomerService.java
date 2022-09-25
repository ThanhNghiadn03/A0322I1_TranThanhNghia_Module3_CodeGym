package customer_mvc.service;

import customer_mvc.bean.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Customer findById(int id);
    void update(int id , Customer customer);
    void remove(int id);
}
