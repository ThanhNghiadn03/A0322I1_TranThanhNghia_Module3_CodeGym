package repository.itf_employee;

import models.employee.Department;

import java.util.List;

public interface DepartmentRepository {
    List<Department> findAllDepartment();
    Department findDepartmentByID(int id);
}
