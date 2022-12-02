package repository.itf_service;

import models.service.Service;
import service.CRUDService;

public interface ServiceRepository extends CRUDService<Service>,RentTypeRepository,ServiceTypeRepository {
    Service findServiceById(int id);
}
