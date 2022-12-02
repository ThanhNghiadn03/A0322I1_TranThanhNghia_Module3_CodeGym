package models.employee;

public class Position {
    private int idPosition;
    private String nameOfPosition;

    public Position() {
    }

    public Position(int idPosition, String nameOfPosition) {
        this.idPosition = idPosition;
        this.nameOfPosition = nameOfPosition;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getNameOfPosition() {
        return nameOfPosition;
    }

    public void setNameOfPosition(String nameOfPosition) {
        this.nameOfPosition = nameOfPosition;
    }
}
