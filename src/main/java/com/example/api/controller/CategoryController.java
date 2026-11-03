package com.example.api.controller;

import com.example.api.model.dto.ApiResponse;
import com.example.api.model.dto.CategoryReq;
import com.example.api.model.entity.Category;
import com.example.api.model.entity.Product;
import com.example.api.service.CategoryService;
import com.example.api.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<Object>> getAllCategories(){
        return ResponseEntity.ok(
                ApiResponse.builder()
                        .code(200)
                        .message("Lay danh sach thanh cong")
                        .data(categoryService.findAl())
                        .build()
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Category>> addNewCategory(@Valid @RequestBody CategoryReq req){
        return ResponseEntity.ok(
            new ApiResponse<>(
                    201,
                    "Them danh muc thanh cong",
                    categoryService.addNewCategory(req)
            )
        );
    }

    @GetMapping("/{categoryId}/products")
    public ResponseEntity<ApiResponse<List<Product>>> getAllProductsByCategoryId(@PathVariable Long categoryId){
        return ResponseEntity.ok(
                new ApiResponse<>(
                        200,
                        "Lay danh sach theo danh muc thanh cong",
                        productService.findAllByCategoryId(categoryId)
                )
        );
    }
}
