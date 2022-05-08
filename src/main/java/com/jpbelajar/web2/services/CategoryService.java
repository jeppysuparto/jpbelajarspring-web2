package com.jpbelajar.web2.services;

import com.jpbelajar.web2.models.entities.Category;
import com.jpbelajar.web2.models.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.TransactionScoped;
import java.util.Optional;

@Service
@TransactionScoped
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public Category findOne(Long id){
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent()){
            return null;
        }
        return category.get();
    }

    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void removeOne(Long id){
        categoryRepository.deleteById(id);
    }
}
