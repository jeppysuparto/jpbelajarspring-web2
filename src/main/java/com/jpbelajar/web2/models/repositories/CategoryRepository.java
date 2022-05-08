package com.jpbelajar.web2.models.repositories;

import com.jpbelajar.web2.models.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
