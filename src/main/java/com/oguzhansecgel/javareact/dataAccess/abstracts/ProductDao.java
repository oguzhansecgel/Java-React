package com.oguzhansecgel.javareact.dataAccess.abstracts;

import com.oguzhansecgel.javareact.entites.concretes.Category;
import com.oguzhansecgel.javareact.entites.concretes.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductDao extends JpaRepository<Product,Integer> {

 Product getByProductName(String productName);

 Product getByProductNameAndCategory_CategoryId(String productName, Category category);

 //List<Product> getByProductNameOrCategory(String productName, int categoryId);

 List<Product> getByCategoryIn(List<Integer> categories);

 List<Product> getByProductNameContains(String productName);

 //List<Product> getByProductNameStarsWith(String productName);

 @Query("FROM Product p WHERE p.productName = :productName AND p.category.id = :categoryId")
 List<Product> getByNameAndCategory(String productName, int categoryId);

}
