package com.oguzhansecgel.javareact.business.concretes;

import com.oguzhansecgel.javareact.business.abstracts.ProductService;
import com.oguzhansecgel.javareact.core.utilities.results.DataResult;
import com.oguzhansecgel.javareact.core.utilities.results.Result;
import com.oguzhansecgel.javareact.core.utilities.results.SuccessDataResult;
import com.oguzhansecgel.javareact.core.utilities.results.SuccessResult;
import com.oguzhansecgel.javareact.dataAccess.abstracts.ProductDao;
import com.oguzhansecgel.javareact.entites.concretes.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductManager implements ProductService {

    private final ProductDao productDao;

    @Override
    public DataResult<List<Product>> getAll() {

        return new SuccessDataResult<List<Product>>
                (productDao.findAll()
                        ,"Data listelendi");

    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("ürün eklendi");
    }

}
