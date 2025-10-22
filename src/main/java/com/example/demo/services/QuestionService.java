package com.example.demo.services;

import com.example.demo.adapter.QuestionAdapter;
import com.example.demo.dto.QuestionRequestDTO;
import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.models.Question;
import com.example.demo.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService{

    private final QuestionRepository questionRepository;

    @Override
    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDTO questionRequestDTO) {
        Question question = Question.builder()
                .title(questionRequestDTO.getTitle())
                .content(questionRequestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return questionRepository.save(question)
                .map(QuestionAdapter::toQuestionResponseDto)
                .doOnSuccess(response -> System.out.println("Question Saved Successfully"))
                .doOnError(error -> System.out.println("Question Not Saved Successfully"));

    }
}
