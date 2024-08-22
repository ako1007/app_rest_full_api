package it.city.app_rest_full_api.controller;

import it.city.app_rest_full_api.entity.Product;
import it.city.app_rest_full_api.payload.ReqProduct;
import it.city.app_rest_full_api.payload.ResProduct;
import it.city.app_rest_full_api.service.ProductService;
import it.city.app_rest_full_api.payload.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class ProductController {

    final ProductService productService;

    @Autowired
    public ProductController(ProductService productService1){
        this.productService=productService1;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<ResProduct> getProduct(){
        return productService.getProduct();
    }

    @PostMapping("/add")
    @ResponseBody
    public Result addProduct(ReqProduct reqProduct){
        return  productService.addProduct(reqProduct);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result deleteProduct(@PathVariable Integer id){
        return productService.deleteProduct(id);
    }
}
