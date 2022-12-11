package service.impl;

import models.service.RentType;
import models.service.Service;
import models.service.ServiceType;
import repository.impl.ServiceRepositoryImpl;
import repository.itf_service.RentTypeRepository;
import repository.itf_service.ServiceRepository;
import repository.itf_service.ServiceTypeRepository;
import service.itf_service.ServiceOfService;

import java.util.List;

public class ServiceOfServiceImpl implements ServiceOfService {
    ServiceRepository serviceRepository = new ServiceRepositoryImpl();
    RentTypeRepository rentTypeRepository = new ServiceRepositoryImpl();
    ServiceTypeRepository serviceTypeRepository = new ServiceRepositoryImpl();
    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void insert(Service service) {
        serviceRepository.insert(service);
    }

    @Override
    public void deleteById(int id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public void edit(Service service) {
        serviceRepository.edit(service);
    }

    @Override
    public List<RentType> findAllRentType() {
        return rentTypeRepository.findAllRentType();
    }

    @Override
    public RentType findRentTypeById(int id) {
        return null;
    }

    @Override
    public List<ServiceType> findAllServiceType() {
        return serviceTypeRepository.findAllServiceType();
    }

    @Override
    public ServiceType findServiceTypeById(int id) {
        return null;
    }

    @Override
    public Service findServiceById(int id) {
        return serviceRepository.findServiceById(id);
    }
}
