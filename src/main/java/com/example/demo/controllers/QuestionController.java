package com.example.demo.controllers;
import com.example.demo.dto.QuestionRequestDTO;
import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final IQuestionService questionService;

    @PostMapping
    public Mono<QuestionResponseDto> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.createQuestion(questionRequestDTO)
                .doOnSuccess(response -> System.out.println("Question was created Successfullt" + response))
                .doOnError(response -> System.out.println("Error creating question" + response));
    }

}
