package service.itf_employee;

import models.employee.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAllDepartment();
    Department findDepartmentByID(int id);
}
