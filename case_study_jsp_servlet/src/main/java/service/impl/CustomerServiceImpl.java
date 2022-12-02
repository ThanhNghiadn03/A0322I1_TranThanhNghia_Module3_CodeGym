package service.impl;

import models.customer.Customer;
import models.customer.CustomerType;
import repository.itf_customer.CustomerRepository;
import repository.itf_customer.CustomerTypeRepository;
import repository.impl.CustomerRepositoryImpl;
import service.itf_customer.CustomerService;
import service.itf_customer.CustomerTypeService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService, CustomerTypeService {
    CustomerRepository customerRepository = new CustomerRepositoryImpl();
    CustomerTypeRepository customerTypeRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void insert(Customer t) {
        customerRepository.insert(t);
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void edit(Customer t) {
        customerRepository.edit(t);
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAllCustomerType();
    }

    @Override
    public CustomerType findCustomerTypeByID(int id) {
        return customerTypeRepository.findCustomerTypeById(id);
    }

    @Override
    public Customer findCustomerByID(int id) {
        return customerRepository.findCustomerById(id);
    }
}
