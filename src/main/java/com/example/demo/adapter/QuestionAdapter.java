package com.example.demo.adapter;

import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.models.Question;

import java.time.LocalDateTime;

public class QuestionAdapter {
    public static QuestionResponseDto toQuestionResponseDto(Question question) {
        return QuestionResponseDto.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(question.getCreatedAt())
                .build();
    }
}
