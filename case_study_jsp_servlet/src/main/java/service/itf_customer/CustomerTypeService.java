package service.itf_customer;

import models.customer.CustomerType;

import java.util.List;

public interface CustomerTypeService {
    List<CustomerType> findAllCustomerType();
    CustomerType findCustomerTypeByID(int id);
}
