package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuestionRequestDTO {

    @NotBlank(message="Title is Required")
    @Size(min=10, max=100, message="Title should be between 10 and 100 characters")
    private String title;

    @NotBlank(message="Content is Required")
    @Size(min=10, max=100, message="Content should be between 10 and 100 characters")
    private String content;

}
