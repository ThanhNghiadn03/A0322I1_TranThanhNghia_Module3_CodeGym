package service.itf_employee;

import models.employee.Position;

import java.util.List;

public interface PositionService {
    List<Position> findAllPosition();
    Position findPositionByID(int id);
}
