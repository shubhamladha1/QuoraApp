package com.example.demo.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionResponseDto {

    private String id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
}
