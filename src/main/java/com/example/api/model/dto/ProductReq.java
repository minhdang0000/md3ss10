package com.example.api.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductReq {
    @NotBlank
    private String name;
    @NotNull
    @Min(1)
    private Double price;
    @Positive
    private Integer stock;
    @NotNull
    private Long categoryId;
}
