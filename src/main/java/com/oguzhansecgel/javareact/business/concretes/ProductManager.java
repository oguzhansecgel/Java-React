package com.oguzhansecgel.javareact.business.concretes;

import com.oguzhansecgel.javareact.business.abstracts.ProductService;
import com.oguzhansecgel.javareact.core.utilities.results.DataResult;
import com.oguzhansecgel.javareact.core.utilities.results.Result;
import com.oguzhansecgel.javareact.core.utilities.results.SuccessDataResult;
import com.oguzhansecgel.javareact.core.utilities.results.SuccessResult;
import com.oguzhansecgel.javareact.dataAccess.abstracts.ProductDao;
import com.oguzhansecgel.javareact.entites.concretes.Category;
import com.oguzhansecgel.javareact.entites.concretes.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC,"productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Başarılı");
    }

    @Override
    public DataResult<List<Product>> gettAllSortedAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"productName");
        return new SuccessDataResult<List<Product>>(this.productDao.findAll(sort),"Başarılı");
    }

    @Override
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo-1,pageSize);

        return new SuccessDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public Result add(Product product) {
        productDao.save(product);
        return new SuccessResult("ürün eklendi");
    }

    @Override
    public DataResult<Product> getByProductName(String productName) {

       return new SuccessDataResult<Product>(this.productDao.getByProductName(productName),"data listelendi");

    }

    @Override
    public DataResult<Product> getByProductNameAndCategory_CategoryId(String productName, Category category) {
        return new SuccessDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName,category),"data listelendi");
    }

   /* @Override
    public DataResult<List<Product>> getByProductNameOrCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(this.productDao.getByProductNameOrCategory(productName,categoryId),"data listelendi");

    }*/

    @Override
    public DataResult<List<Product>> getByCategoryIn(List<Integer> categories) {
        return new SuccessDataResult<List<Product>>(productDao.getByCategoryIn(categories),"categoryidler listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameContains(productName),"Contains");
    }

 /* @Override
    public DataResult<List<Product>> getByProductNameStarsWith(String productName) {
        return new SuccessDataResult<List<Product>>(productDao.getByProductNameStarsWith(productName),"Stars With");
    }
*/
    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccessDataResult<List<Product>>(productDao.getByNameAndCategory(productName,categoryId),"Sıralama okey");
    }

}
