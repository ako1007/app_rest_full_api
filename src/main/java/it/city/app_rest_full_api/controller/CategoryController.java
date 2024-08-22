package it.city.app_rest_full_api.controller;

import it.city.app_rest_full_api.payload.ReqCategory;
import it.city.app_rest_full_api.payload.ResCategory;
import it.city.app_rest_full_api.payload.Result;
import it.city.app_rest_full_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
    final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/get")
    @ResponseBody
    public List<ResCategory> getCategory() {
        return categoryService.getCategory();
    }

    @PostMapping("/save/{name}")
    @ResponseBody
    public Result saveCategory(@PathVariable String name) {
        return categoryService.addCategory(name);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result deleteCategory(@PathVariable Integer id) {
        return categoryService.deleteCategory(id);
    }

    @PutMapping("/edit/{id}")
    @ResponseBody
    public Result editCategory(@PathVariable Integer id, @RequestBody ReqCategory reqCategory) {
        return categoryService.editCategory(id, reqCategory.getName());
    }

}
