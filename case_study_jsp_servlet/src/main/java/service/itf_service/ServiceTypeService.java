package service.itf_service;

import models.service.ServiceType;

import java.util.List;

public interface ServiceTypeService {
    List<ServiceType> findAllServiceType();
    ServiceType findServiceTypeById(int id);
}
