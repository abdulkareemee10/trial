package com.testing.quizApp.service;

import Model.Category;
import Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class CategoryService {

     @Autowired
     private CategoryRepository categoryrepository;

     public CategoryService(){

     }

     public List<Category> listCategories() {
         return (List<Category>) categoryrepository.findAll();
     }

     public void createCategory(Category category) {
         categoryrepository.save(category);
     }

     public Category readCategory(String categoryName) {
         return categoryrepository.findByCategoryName(categoryName);
     }

     public Optional<Category> readCategory(Integer categoryId) {
         return categoryrepository.findById(categoryId);
     }

     public void updateCategory(Integer categoryID, Category newCategory) {
         Category category = categoryrepository.findById(categoryID).get();
         category.setCategoryName(newCategory.getCategoryName());
         category.setDescription(newCategory.getDescription());
          categoryrepository.save(category);
     }

    public void deleteCategory(int id){
        categoryrepository.deleteById(id);
    }
 }

