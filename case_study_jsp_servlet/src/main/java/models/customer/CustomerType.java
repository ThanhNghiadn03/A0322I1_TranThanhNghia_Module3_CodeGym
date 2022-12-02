package models.customer;

public class CustomerType {
    private int id;
    private String nameTypeOfCustomer;

    public CustomerType() {
    }

    public CustomerType(int id, String nameTypeOfCustomer) {
        this.id = id;
        this.nameTypeOfCustomer = nameTypeOfCustomer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTypeOfCustomer() {
        return nameTypeOfCustomer;
    }

    public void setNameTypeOfCustomer(String nameTypeOfCustomer) {
        this.nameTypeOfCustomer = nameTypeOfCustomer;
    }
}
