package models.service;

public class RentType {
    private int idRentType;
    private String nameRenType;

    public RentType(int idRentType, String nameRenType) {
        this.idRentType = idRentType;
        this.nameRenType = nameRenType;
    }

    public RentType() {
    }

    public int getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(int idRentType) {
        this.idRentType = idRentType;
    }

    public String getNameRenType() {
        return nameRenType;
    }

    public void setNameRenType(String nameRenType) {
        this.nameRenType = nameRenType;
    }
}
