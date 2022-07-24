package ptithcm.service;

import ptithcm.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct(Integer pageNumber);

    List<Product> getAllProductInStock(Integer pageNumber);

    long getTotalProduct();

    String addProduct(Product product);

    String updateProduct(Product prdct);

    String deleteProduct(Product product);

    Product getProductById(long id);

    List<Product> findAllProductByNameorCategory(String searchTerm, int pageNumber);

    long getTotalProductByNameorCategory(String searchTerm);

    List<Product> getAllProductByCategoryInStock(String category, int pageNumber);

    long getTotalProductByCategoryInStock(String category);


    List<Product> findAllProductByNameInStock(String searchTerm, int pageNumber);

    long getTotalProductByNameInStock(String searchTerm);
}
