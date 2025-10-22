package com.example.demo.services;

import com.example.demo.dto.QuestionRequestDTO;
import com.example.demo.dto.QuestionResponseDto;
import reactor.core.publisher.Mono;

public interface IQuestionService {

    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDTO QuestionRequestDTO);
}
