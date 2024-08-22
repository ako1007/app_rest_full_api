package it.city.app_rest_full_api.service;

import it.city.app_rest_full_api.entity.Category;
import it.city.app_rest_full_api.entity.Product;
import it.city.app_rest_full_api.payload.ReqProduct;
import it.city.app_rest_full_api.payload.ResProduct;
import it.city.app_rest_full_api.payload.Result;
import it.city.app_rest_full_api.repository.CategoryRepository;
import it.city.app_rest_full_api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

    public Result addProduct(ReqProduct reqProduct){
        Product product=new Product();
        Optional<Category> category = categoryRepository.findById(reqProduct.getCategoryId());
        boolean exists = productRepository.existsByNameEqualsIgnoreCaseAndCategoryId(reqProduct.getName(), reqProduct.getCategoryId());
        if (!exists){
            product.setCategory(category.get());
            product.setName(reqProduct.getName());
            product.setPrice(reqProduct.getPrice());
            product.setShippingPrice(reqProduct.getShippingPrice());
            product.setPrice(reqProduct.getPrice());
            productRepository.save(product);
            return new Result("Successfully product saved",true);
        }
        return new Result("Product alredy exsit",false);
    }

    public List<ResProduct> getProduct(){
        List<Product> all = productRepository.findAll();
        List<ResProduct> resProducts=new ArrayList<>();
        for (int i = 0; i < all.size(); i++) {
            ResProduct resProduct=new ResProduct();
            Product product = all.get(i);
            resProduct.setCategoryId(all.get(i).getCategory().getId());
            resProduct.setName(product.getName());
            resProduct.setPrice(product.getPrice());
            resProduct.setShippingPrice(product.getShippingPrice());
            resProduct.setDescription(product.getDescription());
            resProduct.setCategoryName(product.getCategory().getName());
            resProducts.add(resProduct);
        }
        return resProducts;
    }

    public Result deleteProduct(Integer id){
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()){
            productRepository.deleteById(id);
            return new Result("Successfuly product deleted",true);
        }
        return new Result("Product not found",false);
    }

    public Result editProduct(ReqProduct reqProduct, Integer id){
        Optional<Product> byId = productRepository.findById(id);
        if (byId.isPresent()){
            boolean exists = productRepository.existsByNameEqualsIgnoreCaseAndCountryId(reqProduct.getName(), id);
            if (!exists){
                Optional<Category> byId1 = categoryRepository.findById(reqProduct.getCategoryId());
                Category category = byId1.get();
                Product product = byId.get();
                product.setName(reqProduct.getName());
                product.setCategory(category);
                product.setDescription(reqProduct.getDescription());
                product.setPrice(reqProduct.getPrice());
                product.setShippingPrice(reqProduct.getShippingPrice());
                productRepository.save(product);
                return new Result("Product successfuly edit",true);
            }
            return new Result("Product already exists in this",false);
        }
        return new Result("Product not found", false);

    }
}
