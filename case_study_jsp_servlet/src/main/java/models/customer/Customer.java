package models.customer;

import models.Person;

public class Customer extends Person {
    private String code;
    private int idCustomer;
    private CustomerType type;

    public Customer(int idCustomer, int idTypeCus,String nameType) {
        this.idCustomer = idCustomer;
        this.type = new CustomerType(idTypeCus,nameType);
    }

    public Customer(String fullName, String dateOfBirth, boolean gender, long identityCardNum, String phoneNumber, String mail, String address, int idCustomer, int idTypeCus , String nameType) {
        super(fullName, dateOfBirth, gender, identityCardNum, phoneNumber, mail, address);
        this.idCustomer = idCustomer;
        this.type = new CustomerType(idTypeCus,nameType);
        if (this.idCustomer < 10) {
            this.code = "KH"+"00"+this.idCustomer;
        } else if (this.idCustomer <100) {
            this.code = "KH"+"0"+this.idCustomer;
        } else if (this.idCustomer <1000) {
            this.code = "KH"+this.idCustomer;
        }
    }

    public Customer(String fullName, String dateOfBirth, boolean gender, long identityCardNum, String phoneNumber, String mail, String address, String code, int idCustomer, int idTypeCus, String nameType) {
        super(fullName, dateOfBirth, gender, identityCardNum, phoneNumber, mail, address);
        this.code = code;
        this.idCustomer = idCustomer;
        this.type = new CustomerType(idTypeCus,nameType);
    }

    public Customer(String fullName, String dateOfBirth, boolean gender, long identityCardNum, String phoneNumber, String mail, String address, CustomerType type) {
        super(fullName, dateOfBirth, gender, identityCardNum, phoneNumber, mail, address);
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public CustomerType getType() {
        return type;
    }

    public void setType(CustomerType type) {
        this.type = type;
    }
}
