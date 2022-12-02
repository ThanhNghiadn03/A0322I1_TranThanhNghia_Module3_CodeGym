package repository.itf_employee;

import models.employee.Position;

import java.util.List;

public interface PositionRepository {
    List<Position> findAllPosition();
    Position findPositionByID(int id);
}
