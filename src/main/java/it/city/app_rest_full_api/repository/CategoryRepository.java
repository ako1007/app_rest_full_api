package it.city.app_rest_full_api.repository;

import it.city.app_rest_full_api.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


}
