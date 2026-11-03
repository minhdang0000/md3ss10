package com.example.api.model.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse<T>{
    private int code;
    private String message;
    private T data;
}
