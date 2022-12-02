package service.itf_employee;

import models.employee.Employee;
import service.CRUDService;
import service.itf_employee.DepartmentService;
import service.itf_employee.EducationDegreeService;
import service.itf_employee.PositionService;

public interface EmployeeService extends CRUDService<Employee>, PositionService, EducationDegreeService, DepartmentService {
    Employee findEmployeeByID(int id);
}
