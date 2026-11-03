package com.example.api.service;

import com.example.api.exception.HttpNotFoundException;
import com.example.api.model.dto.CategoryReq;
import com.example.api.model.entity.Category;
import com.example.api.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> findAl(){
        return categoryRepository.findAll();
    }
    public Category findById(Long id){
        return categoryRepository.findById(id).orElseThrow(()-> new HttpNotFoundException("Ko tim thay"));
    }
    public Category addNewCategory(CategoryReq req){
        return categoryRepository.save(Category.builder()
                .name(req.getName())
                .build());
    }
}
