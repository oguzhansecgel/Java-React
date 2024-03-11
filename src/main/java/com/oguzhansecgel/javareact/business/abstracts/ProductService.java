package com.oguzhansecgel.javareact.business.abstracts;

import com.oguzhansecgel.javareact.core.utilities.results.DataResult;
import com.oguzhansecgel.javareact.core.utilities.results.Result;
import com.oguzhansecgel.javareact.entites.concretes.Product;

import java.util.List;

public interface ProductService {
    DataResult<List<Product>> getAll();
    Result add(Product product);


}
