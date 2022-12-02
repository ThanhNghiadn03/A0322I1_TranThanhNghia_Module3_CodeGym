package service.itf_service;

import models.service.RentType;

import java.util.List;

public interface RentTypeService {
    List<RentType> findAllRentType();
    RentType findRentTypeById(int id);
}
