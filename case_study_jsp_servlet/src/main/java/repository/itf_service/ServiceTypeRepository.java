package repository.itf_service;

import models.service.ServiceType;

import java.util.List;

public interface ServiceTypeRepository {
    List<ServiceType> findAllServiceType();
    ServiceType findServiceTypeById(int id);
}
