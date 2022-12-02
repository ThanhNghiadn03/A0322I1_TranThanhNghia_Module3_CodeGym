package service.itf_service;

import models.service.Service;
import service.CRUDService;

public interface ServiceOfService extends CRUDService<Service>,ServiceTypeService,RentTypeService {
    Service findServiceById(int id);
}
