package com.example.demo.services;

import com.example.demo.dto.QuestionRequestDTO;
import com.example.demo.dto.QuestionResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionService {

    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDTO QuestionRequestDTO);
    public Mono<QuestionResponseDto> getQuestionById(String id);
    public Flux<QuestionResponseDto> getAllQuestions(String cursor, int size);
    public Mono<Void> deleteQuestionById(String id);
    public Flux<QuestionResponseDto>  searchQuestions(String query, int page, int size);
}
