package com.example.demo.services;

import com.example.demo.jpamysql.CategoryJpa;
import com.example.demo.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryJpa categoryJpa;

    public Page<Category> getCategory(Pageable pageable) {
        return (Page<Category>) categoryJpa.findAll(pageable);
    }

    public List<Category> getCategory(){
        return (List<Category>) categoryJpa.findAll();
    }

    public List<Category> getCategories(Long id){
        return (List<Category>) categoryJpa.findAll(id);
    }

    public void saveCategory(Category category) {
        categoryJpa.save(category);
    }

    public Category getCategory(Long id) {
        return categoryJpa.findById(id).get();
    }

    public void deleteCategory(Long id) {
        categoryJpa.deleteById(id);
    }

    public Long getTotal() {
        return categoryJpa.getTotal();
    }


}
