package repository.itf_customer;

import models.customer.CustomerType;

import java.util.List;

public interface CustomerTypeRepository {
    List<CustomerType> findAllCustomerType();
    CustomerType findCustomerTypeById(int id);
}
