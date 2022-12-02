package service.impl;

import models.employee.Department;
import models.employee.EducationDegree;
import models.employee.Employee;
import models.employee.Position;
import repository.itf_employee.DepartmentRepository;
import repository.itf_employee.EducationDegreeRepository;
import repository.itf_employee.EmployeeRepository;
import repository.itf_employee.PositionRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.itf_employee.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();
    PositionRepository positionRepository = new EmployeeRepositoryImpl();
    DepartmentRepository departmentRepository = new EmployeeRepositoryImpl();
    EducationDegreeRepository educationDegreeRepository = new EmployeeRepositoryImpl();
    @Override
    public Employee findEmployeeByID(int id) {
        return employeeRepository.findEmployeeByID(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void insert(Employee employee) {
        employeeRepository.insert(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.edit(employee);
    }

    @Override
    public List<EducationDegree> findAllDegree() {
        return educationDegreeRepository.findAllDegree();
    }
    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAllPosition();
    }
    @Override
    public List<Department> findAllDepartment() {
        return departmentRepository.findAllDepartment();
    }

    @Override
    public EducationDegree findDegreeByID(int id) {
        return educationDegreeRepository.findDegreeByID(id);
    }

    @Override
    public Position findPositionByID(int id) {
        return positionRepository.findPositionByID(id);
    }
    @Override
    public Department findDepartmentByID(int id) {
        return departmentRepository.findDepartmentByID(id);
    }
}
