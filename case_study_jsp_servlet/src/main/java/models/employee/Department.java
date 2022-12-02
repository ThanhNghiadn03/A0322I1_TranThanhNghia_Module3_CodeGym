package models.employee;

public class Department {
    private int idDepartment;
    private String nameOfDepartment;

    public Department(int idDepartment, String nameOfDepartment) {
        this.idDepartment = idDepartment;
        this.nameOfDepartment = nameOfDepartment;
    }

    public Department() {
    }

    public int getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(int idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameOfDepartment() {
        return nameOfDepartment;
    }

    public void setNameOfDepartment(String nameOfDepartment) {
        this.nameOfDepartment = nameOfDepartment;
    }
}
