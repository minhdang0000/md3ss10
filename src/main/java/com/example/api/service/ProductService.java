package com.example.api.service;

import com.example.api.model.dto.ProductReq;
import com.example.api.model.entity.Category;
import com.example.api.model.entity.Product;
import com.example.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    public List<Product> findAll(){
        return productRepository.findAll();
    }
    public Product addNewProduct(ProductReq req){
        Category category = categoryService.findById(req.getCategoryId());
        Product product = Product.builder()
                .name(req.getName())
                .stock(req.getStock())
                .price(req.getPrice())
                .category(category)
                .build();
        return productRepository.save(product);
    }

    public List<Product> findAllByCategoryId(Long categoryId){
        Category category = categoryService.findById(categoryId);

        return productRepository.findAllByCategory(category);
    }
}
