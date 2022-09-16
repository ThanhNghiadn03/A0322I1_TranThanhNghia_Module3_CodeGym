package model;


public class Customer {
    private String name;
    private String birthDate;
    private String address;
    private String urlImage;

    public Customer(String name, String birthDate, String address, String urlImage) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.urlImage = urlImage;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
