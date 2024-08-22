package it.city.app_rest_full_api.service;

import it.city.app_rest_full_api.entity.Category;
import it.city.app_rest_full_api.payload.ResCategory;
import it.city.app_rest_full_api.payload.Result;
import it.city.app_rest_full_api.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    final CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Result addCategory(String name) {
        Category category = new Category();
        category.setName(name);
        categoryRepository.save(category);
        return new Result("Category successfully saved", true);

    }

    public List<ResCategory> getCategory() {
        List<ResCategory> resCategories = new ArrayList<>();
        List<Category> all = categoryRepository.findAll();
        for (Category category : all) {
            ResCategory resCategory = new ResCategory();
            resCategory.setName(category.getName());
            resCategory.setId(category.getId());
            resCategories.add(resCategory);
        }
        return resCategories;
    }

    public Result editCategory(Integer id, String name) {
        Optional<Category> byId = categoryRepository.findById(id);
        if (byId.isPresent()) {
            Category category = byId.get();
            category.setName(name);
            categoryRepository.save(category);
            return new Result("Category successfully updated", true);
        }
        return new Result("Category not found", false);
    }

    public Result deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return new Result("Category successfully deleted", true);
    }
}
