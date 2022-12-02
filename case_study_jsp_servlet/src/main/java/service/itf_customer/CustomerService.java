package service.itf_customer;

import models.customer.Customer;
import service.CRUDService;

public interface CustomerService extends CRUDService<Customer>, CustomerTypeService {
    Customer findCustomerByID(int id);
}
