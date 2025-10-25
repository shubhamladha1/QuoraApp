package com.example.demo.services;
import com.example.demo.dto.AnswerRequestDTO;
import com.example.demo.dto.AnswerResponseDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AnswerService implements IAnswerService {
    @Override
    public Mono<AnswerResponseDTO> createAnswer(AnswerRequestDTO answerRequestDTO) {
        return null;
    }

    @Override
    public Mono<AnswerResponseDTO> getAnswerById(AnswerRequestDTO answerRequestDTO) {
        return null;
    }
}
