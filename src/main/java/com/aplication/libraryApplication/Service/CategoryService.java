package com.aplication.libraryApplication.Service;


import com.aplication.libraryApplication.Repository.CategoryRepository;
import com.aplication.libraryApplication.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
   private CategoryRepository categoryRepository;

    public List<Category>findAllCategory(){
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        return category;
    }

    public void CreateCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public void  deleteCategory(long id){
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        categoryRepository.deleteById(category.getId());
    }
}
