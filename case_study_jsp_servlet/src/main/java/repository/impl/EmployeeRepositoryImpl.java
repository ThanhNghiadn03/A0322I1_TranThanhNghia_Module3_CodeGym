package repository.impl;

import models.employee.Department;
import models.employee.EducationDegree;
import models.employee.Employee;
import models.employee.Position;
import repository.itf_employee.EmployeeRepository;
import utils.ConnectionUtils;
import utils.ConstantCustomerEmployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.EMPLOYEE_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("nv.ma_nhan_vien");
                String ho_ten = rs.getString("nv.ho_ten");
                String dob = rs.getString("nv.ngay_sinh");
                long cmnd = rs.getLong("nv.so_cmnd");
                long luong = rs.getLong("nv.luong");
                String sdt = rs.getString("nv.so_dien_thoai");
                String email = rs.getString("nv.email");
                String address = rs.getString("nv.diachi");
                Position position = new Position(rs.getInt("vt.ma_vi_tri"),rs.getString("vt.ten_vi_tri"));
                EducationDegree educationDegree = new EducationDegree(rs.getInt("td.ma_trinh_do"),rs.getString("td.ten_trinh_do"));
                Department department = new Department(rs.getInt("bp.ma_bo_phan"),rs.getString("bp.ten_bo_phan"));
                Employee employee = new Employee(ho_ten,dob,cmnd,sdt,email,address,id,luong,position,educationDegree,department);
                employeeList.add(employee);
            }
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public void insert(Employee employee) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.EMPLOYEE_INSERT);
            statement.setString(1, employee.getFullName());
            statement.setString(2,employee.getDob());
            statement.setLong(3,employee.getIdentityCardNum());
            statement.setLong(4,employee.getSalary());
            statement.setString(5,employee.getPhoneNumber());
            statement.setString(6,employee.getMail());
            statement.setString(7,employee.getAddress());
            statement.setInt(8,employee.getPosition().getIdPosition());
            statement.setInt(9,employee.getEducationDegree().getIdEduDegree());
            statement.setInt(10,employee.getDepartment().getIdDepartment());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.EMPLOYEE_DELETE_BY_ID);
            statement.setInt(1,id);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(Employee employee) {
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.UPDATE_EMPLOYEE);
            statement.setString(1, employee.getFullName());
            statement.setString(2,employee.getDob());
            statement.setLong(3,employee.getIdentityCardNum());
            statement.setLong(4,employee.getSalary());
            statement.setString(5, employee.getPhoneNumber());
            statement.setString(6, employee.getMail());
            statement.setString(7,employee.getAddress());
            statement.setInt(8, employee.getPosition().getIdPosition());
            statement.setInt(9,employee.getEducationDegree().getIdEduDegree());
            statement.setInt(10,employee.getDepartment().getIdDepartment());
            statement.setInt(11,employee.getIdEmployee());
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Department> findAllDepartment() {
        List<Department> departmentList = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.DEPARTMENT_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_bo_phan");
                String name = rs.getString("ten_bo_phan");
                Department department = new Department(id,name);
                departmentList.add(department);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public List<EducationDegree> findAllDegree() {
        List<EducationDegree> degreeList = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.EDUCATION_DEGREE_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_trinh_do");
                String name = rs.getString("ten_trinh_do");
                EducationDegree educationDegree = new EducationDegree(id,name);
                degreeList.add(educationDegree);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return degreeList;
    }

    @Override
    public List<Position> findAllPosition() {
        List<Position> positionList = new ArrayList<>();
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.POSITION_SELECT_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ma_vi_tri");
                String name = rs.getString("ten_vi_tri");
                Position position = new Position(id,name);
                positionList.add(position);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }

    @Override
    public Position findPositionByID(int id) {
        Position position = null;
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.POSITION_SELECT_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                position = new Position(rs.getInt("ma_vi_tri"),rs.getString("ten_vi_tri"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return position;
    }
    @Override
    public Department findDepartmentByID(int id) {
        Department department = null;
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.DEPARTMENT_SELECT_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                department = new Department(rs.getInt("ma_bo_phan"),rs.getString("ten_bo_phan"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return department;
    }
    @Override
    public EducationDegree findDegreeByID(int id) {
        EducationDegree educationDegree = null;
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.EDU_DEGREE_SELECT_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                educationDegree = new EducationDegree(rs.getInt("ma_trinh_do"),rs.getString("ten_trinh_do"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegree;
    }

    @Override
    public Employee findEmployeeByID(int id) {
        Employee employee = null;
        try {
            Connection connection = ConnectionUtils.getConnection();
            PreparedStatement statement = connection.prepareStatement(ConstantCustomerEmployee.EMPLOYEE_SELECT_BY_ID);
            statement.setInt(1,id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String ho_ten = rs.getString("nv.ho_ten");
                String dob = rs.getString("nv.ngay_sinh");
                long cmnd = rs.getLong("nv.so_cmnd");
                long luong = rs.getLong("nv.luong");
                String sdt = rs.getString("nv.so_dien_thoai");
                String email = rs.getString("nv.email");
                String address = rs.getString("nv.diachi");
                Position position = new Position(rs.getInt("vt.ma_vi_tri"),rs.getString("vt.ten_vi_tri"));
                EducationDegree educationDegree = new EducationDegree(rs.getInt("td.ma_trinh_do"),rs.getString("td.ten_trinh_do"));
                Department department = new Department(rs.getInt("bp.ma_bo_phan"),rs.getString("bp.ten_bo_phan"));
                employee = new Employee(ho_ten,dob,cmnd,sdt,email,address,id,luong,position,educationDegree,department);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employee;
    }
}
