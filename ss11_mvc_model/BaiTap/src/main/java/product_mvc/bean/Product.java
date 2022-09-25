package product_mvc.bean;

public class Product {
    private int id;
    private String name;
    private double price;
    private String description;
    private String manuFac;

    public Product(int id, String name, double price, String description, String manuFac) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.manuFac = manuFac;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManuFac() {
        return manuFac;
    }

    public void setManuFac(String manuFac) {
        this.manuFac = manuFac;
    }
}
