package customer_mvc.service.impl;

import customer_mvc.bean.Customer;
import customer_mvc.service.CustomerService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private  static Map<Integer , Customer> customerMap;
    static {
        customerMap = new HashMap<>();
        customerMap.put(1,new Customer(1,"John","john@codegym.vn","Ha Noi"));
        customerMap.put(2,new Customer(2,"Bill","bill@codegym.vn","Da Nang"));
        customerMap.put(3,new Customer(3,"Alex","alex@codegym.vn","Sai Gon"));
        customerMap.put(4,new Customer(4,"Adam","adam@codegym.vn","Beijin"));
        customerMap.put(5,new Customer(5,"Sophia","sophia@codegym.vn","Miami"));
        customerMap.put(6,new Customer(6,"Rose","rose@codegym.vn","New York"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public void save(Customer customer) {
        customerMap.put(customer.getId(),customer);
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerMap.put(id,customer);
    }

    @Override
    public void remove(int id) {
        customerMap.remove(id);
    }
}
