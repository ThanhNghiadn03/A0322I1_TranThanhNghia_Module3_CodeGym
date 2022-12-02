package repository.itf_employee;

import models.employee.Employee;
import repository.CRUDRepository;

public interface EmployeeRepository extends CRUDRepository<Employee>, PositionRepository, EducationDegreeRepository, DepartmentRepository {
    Employee findEmployeeByID(int id);
}
