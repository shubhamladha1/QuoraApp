package com.example.demo.services;
import com.example.demo.dto.AnswerRequestDTO;
import com.example.demo.dto.AnswerResponseDTO;
import reactor.core.publisher.Mono;

public interface IAnswerService {

    Mono<AnswerResponseDTO> createAnswer(AnswerRequestDTO answerRequestDTO);

    Mono<AnswerResponseDTO> getAnswerById(AnswerRequestDTO answerRequestDTO);

}
