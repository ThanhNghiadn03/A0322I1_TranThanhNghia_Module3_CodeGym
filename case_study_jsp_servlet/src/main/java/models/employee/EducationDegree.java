package models.employee;

public class EducationDegree {
    private int idEduDegree;
    private String nameOfEduDegree;

    public EducationDegree() {
    }

    public EducationDegree(int idEduDegree, String nameOfEduDegree) {
        this.idEduDegree = idEduDegree;
        this.nameOfEduDegree = nameOfEduDegree;
    }

    public int getIdEduDegree() {
        return idEduDegree;
    }

    public void setIdEduDegree(int idEduDegree) {
        this.idEduDegree = idEduDegree;
    }

    public String getNameOfEduDegree() {
        return nameOfEduDegree;
    }

    public void setNameOfEduDegree(String nameOfEduDegree) {
        this.nameOfEduDegree = nameOfEduDegree;
    }
}
