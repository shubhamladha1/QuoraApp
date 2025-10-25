package com.example.demo.services;
import com.example.demo.dto.QuestionRequestDTO;
import com.example.demo.dto.QuestionResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionService {

    Mono<QuestionResponseDto> createQuestion(QuestionRequestDTO questionRequestDTO);
    Mono<QuestionResponseDto> getQuestionById(String id);
    Flux<QuestionResponseDto> getAllQuestions(String cursor, int size);
    Mono<Void> deleteQuestionById(String id);
    Flux<QuestionResponseDto>  searchQuestions(String query, int page, int size);
}
