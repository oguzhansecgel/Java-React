package com.oguzhansecgel.javareact.api.controllers;

import com.oguzhansecgel.javareact.business.abstracts.ProductService;
import com.oguzhansecgel.javareact.core.utilities.results.DataResult;
import com.oguzhansecgel.javareact.core.utilities.results.Result;
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
    @PostMapping("/create")
    public Result add(@RequestBody Product product)
    {
        return productService.add(product);
    }
}
