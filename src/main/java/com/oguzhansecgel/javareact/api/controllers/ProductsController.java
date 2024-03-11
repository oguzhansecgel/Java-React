package com.oguzhansecgel.javareact.api.controllers;

import com.oguzhansecgel.javareact.business.abstracts.ProductService;
import com.oguzhansecgel.javareact.core.utilities.results.DataResult;
import com.oguzhansecgel.javareact.core.utilities.results.Result;
import com.oguzhansecgel.javareact.entites.concretes.Category;
import com.oguzhansecgel.javareact.entites.concretes.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService productService;

    @GetMapping("/getAll")
    public DataResult<List<Product>> getAll()
    {
        return this.productService.getAll();
    }
    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName)
    {
        return this.productService.getByProductName(productName);
    }
    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam String productName, Category category)
    {
        return this.productService.getByProductNameAndCategory_CategoryId(productName,category);
    }
    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getAll(int pageNo, int pageSize)
    {
        return this.productService.getAll(pageNo,pageSize);
    }
    @GetMapping("/getAllDESC")
    public DataResult<List<Product>> getAllSorted()
    {
        return  this.productService.getAllSorted();
    }
    @GetMapping("getAllASC")
    public DataResult<List<Product>> gettAllSortedAsc()
    {
        return this.productService.gettAllSortedAsc();
    }
    @PostMapping("/create")
    public Result add(@RequestBody Product product)
    {
        return this.productService.add(product);
    }
}
