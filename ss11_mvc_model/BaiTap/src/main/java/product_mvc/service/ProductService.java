package product_mvc.service;

import product_mvc.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
    void saveProduct(Product product);
    void editProduct(int id , Product product);
    void deleteProduct(int id);
    Product findById(int id);
    Product findByName(String name);
}
