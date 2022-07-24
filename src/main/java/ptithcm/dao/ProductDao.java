package ptithcm.dao;

import ptithcm.entity.Product;

import java.util.List;

public interface ProductDao extends GenericDao<Product> {

    List<Product> getAllProduct(Integer pageNumber);

    List<Product> getAllProductInStock(Integer pageNumber);

    Product findOne(long id);

    long getTotalProduct();

    long getTotalProductByNameorCategory(String searchTerm);

    //	@Query("SELECT t FROM Product t WHERE t.productCategory = :category AND t.productModel LIKE %:searchTerm%  OR  t.productCategory = :category AND t.productBrand LIKE %:searchTerm%")
//	Page<Product> findAllProductByBrandOrModel(@Param("searchTerm")String searchTerm,@Param("category")String category,Pageable pageable);
//	
//	
    List<Product> findAllProductByNameorCategory(String searchTerm, int pageNumber);

    List<Product> getAllProductByCategoryInStock(String category, int pageNumber);

    long getTotalProductByCategoryInStock(String category);

    List<Product> findAllProductByNameInStock(String searchTerm, int pageNumber);

    long getTotalProductByNameInStock(String searchTerm);
}
