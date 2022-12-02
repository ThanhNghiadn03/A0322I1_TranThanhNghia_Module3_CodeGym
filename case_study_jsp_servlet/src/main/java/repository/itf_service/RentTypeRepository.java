package repository.itf_service;

import models.service.RentType;

import java.util.List;

public interface RentTypeRepository {
    List<RentType> findAllRentType();
    RentType findRentTypeById(int id);
}
