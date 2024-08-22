package it.city.app_rest_full_api.repository;

import it.city.app_rest_full_api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
boolean existsByNameEqualsIgnoreCaseAndCategoryId(String name, Integer category_id);
boolean existsByNameEqualsIgnoreCaseAndCountryId(String name, Integer id);
}
