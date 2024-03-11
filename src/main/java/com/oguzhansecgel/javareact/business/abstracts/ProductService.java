package com.oguzhansecgel.javareact.business.abstracts;

import com.oguzhansecgel.javareact.core.utilities.results.DataResult;
import com.oguzhansecgel.javareact.core.utilities.results.Result;
import com.oguzhansecgel.javareact.entites.concretes.Category;
import com.oguzhansecgel.javareact.entites.concretes.Product;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    DataResult<List<Product>> getAllSorted();
    DataResult<List<Product>> gettAllSortedAsc();
    DataResult<List<Product>> getAll(int pageNo,int pageSize);
    Result add(Product product);

    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, Category category);

    //DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    //DataResult<List<Product>> getByProductNameStarsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName,int categoryId);


}
