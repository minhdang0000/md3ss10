package com.example.api.controller;

import com.example.api.model.dto.ApiResponse;
import com.example.api.model.dto.ProductReq;
import com.example.api.model.entity.Product;
import com.example.api.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Product>>> getAllProducts() {
        return ResponseEntity.ok(
          new ApiResponse<>(
                  200,
                  "lAY Danh sach san pham thanh cong",
                  productService.findAll()
          )
        );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Product>> addNewProduct(@Valid @RequestBody ProductReq req) {
        return ResponseEntity.status(201).body(
                new ApiResponse<>(
                        201,
                        "Them san pham thanh cong",
                        productService.addNewProduct(req)
                )
        );
    }
}
