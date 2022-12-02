package repository.itf_customer;

import models.customer.Customer;
import repository.CRUDRepository;

public interface CustomerRepository extends CRUDRepository<Customer>, CustomerTypeRepository {
    Customer findCustomerById(int id);
}
