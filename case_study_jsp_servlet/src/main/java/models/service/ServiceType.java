package models.service;

public class ServiceType {
    private int idServiceType;
    private String nameServiceType;

    public ServiceType() {
    }

    public ServiceType(int idServiceType, String nameServiceType) {
        this.idServiceType = idServiceType;
        this.nameServiceType = nameServiceType;
    }

    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getNameServiceType() {
        return nameServiceType;
    }

    public void setNameServiceType(String nameServiceType) {
        this.nameServiceType = nameServiceType;
    }
}
