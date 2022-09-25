package product_mvc.service.impl;

import product_mvc.bean.Product;
import product_mvc.service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> productList;
    static {
        productList = new HashMap<>();
        productList.put(1,new Product(1,"Milk",12.5,"Fresh milk","Ha Noi"));
        productList.put(2,new Product(2,"Cake",53,"Best cake","Da Nang"));
        productList.put(3,new Product(3,"Bread",8,"Baguette","Gia Lai"));
        productList.put(4,new Product(4,"Rice",67,"Delicious rice","Viet Tri"));
        productList.put(5,new Product(5,"Meat",32,"Spicy meat","HCM"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public void saveProduct(Product product) {
        productList.put(product.getId(),product);
    }

    @Override
    public void editProduct(int id, Product product) {
        productList.put(id,product);
    }

    @Override
    public void deleteProduct(int id) {
        productList.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public Product findByName(String name) {
        return null;
    }
}
