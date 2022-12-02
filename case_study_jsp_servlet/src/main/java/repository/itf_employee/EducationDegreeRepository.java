package repository.itf_employee;

import models.employee.EducationDegree;

import java.util.List;

public interface EducationDegreeRepository {
    List<EducationDegree> findAllDegree();
    EducationDegree findDegreeByID(int id);
}
