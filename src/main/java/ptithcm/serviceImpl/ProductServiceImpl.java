package ptithcm.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import ptithcm.dao.ProductDao;
import ptithcm.entity.Product;
import ptithcm.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProduct(Integer pageNumber) {
        return productDao.getAllProduct(pageNumber);
    }

    @Override
    public long getTotalProduct() {
        return productDao.getTotalProduct();
    }

    @Override
    public String addProduct(Product prdct) {
        return productDao.save(prdct);
    }

    @Override
    public String updateProduct(Product prdct) {
        return productDao.update(prdct);
    }

    @Override
    public String deleteProduct(Product prdct) {
        return productDao.delete(prdct);
    }

    @Override
    public Product getProductById(long l) {
        return productDao.findOne(l);
    }

    @Override
    public List<Product> getAllProductInStock(Integer pageNumber) {
        return productDao.getAllProductInStock(pageNumber);
    }

    @Override
    public List<Product> findAllProductByNameorCategory(String string, int i) {
        return productDao.findAllProductByNameorCategory(string, i);
    }

    @Override
    public long getTotalProductByNameorCategory(String string) {
        return productDao.getTotalProductByNameorCategory(string);
    }

    @Override
    public List<Product> getAllProductByCategoryInStock(String string, int i) {
        return productDao.getAllProductByCategoryInStock(string, i);
    }

    @Override
    public long getTotalProductByCategoryInStock(String string) {
        return productDao.getTotalProductByCategoryInStock(string);
    }

    @Override
    public List<Product> findAllProductByNameInStock(String string, int i) {
        return productDao.findAllProductByNameInStock(string, i);
    }

    @Override
    public long getTotalProductByNameInStock(String string) {
        return productDao.getTotalProductByNameInStock(string);
    }
}
