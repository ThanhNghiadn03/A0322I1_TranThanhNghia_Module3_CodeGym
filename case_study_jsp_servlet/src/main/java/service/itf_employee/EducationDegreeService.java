package service.itf_employee;

import models.employee.EducationDegree;

import java.util.List;

public interface EducationDegreeService {
    List<EducationDegree> findAllDegree();
    EducationDegree findDegreeByID(int id);
}
