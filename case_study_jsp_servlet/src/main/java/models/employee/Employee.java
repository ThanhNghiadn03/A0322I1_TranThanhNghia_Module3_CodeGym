package models.employee;

import models.Person;

public class Employee extends Person {
    private int idEmployee;
    private long salary;
    private Position position;
    private EducationDegree educationDegree;
    private Department department;

    public Employee(String fullName, String dateOfBirth, long identityCardNum, String phoneNumber, String mail, String address, int idEmployee, long salary, Position position, EducationDegree educationDegree, Department department) {
        super(fullName, dateOfBirth, true, identityCardNum, phoneNumber, mail, address);
        this.idEmployee = idEmployee;
        this.salary = salary;
        this.position = position;
        this.educationDegree = educationDegree;
        this.department = department;
    }

    public Employee(String fullName, String dateOfBirth, long identityCardNum, String phoneNumber, String mail, String address, long salary, Position position, EducationDegree educationDegree, Department department) {
        super(fullName, dateOfBirth, true, identityCardNum, phoneNumber, mail, address);
        this.salary = salary;
        this.position = position;
        this.educationDegree = educationDegree;
        this.department = department;
    }

    public Employee() {
    }


    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
