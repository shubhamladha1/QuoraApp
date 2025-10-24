package com.example.demo.controllers;
import com.example.demo.dto.QuestionRequestDTO;
import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.services.IQuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final IQuestionService questionService;

    @PostMapping
    public Mono<QuestionResponseDto> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.createQuestion(questionRequestDTO)
                .doOnSuccess(response -> System.out.println("Question was created Successfully" + response))
                .doOnError(response -> System.out.println("Error creating question" + response));
    }

    @GetMapping("/{id}")
    public Mono<QuestionResponseDto> getQuestionById(@PathVariable String id) {
        return questionService.getQuestionById(id)
                .doOnSuccess(response -> System.out.println("Question fetched Successfully" + response))
                .doOnError(response -> System.out.println("Error while fetching question" + response));
    }

//    @GetMapping
//    public Flux<QuestionResponseDto> getAllQuestions() {
//        return questionService.getAllQuestions();
//    }


    @GetMapping()
    public Flux<QuestionResponseDto> getAllQuestions(
            @RequestParam(required = false) String cursor,
            @RequestParam(defaultValue = "10") int size
    ) {
        return questionService.getAllQuestions(cursor, size)
                .doOnError(error -> System.out.println("Error fetching questions: " + error))
                .doOnComplete(() -> System.out.println("Questions fetched successfully"));
    }

    @DeleteMapping
    public Mono<Void> deleteQuestionById(@PathVariable String id) {
        return questionService.deleteQuestionById(id);
    }

    @GetMapping("/search")
    public Flux<QuestionResponseDto> searchQuestions(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return questionService.searchQuestions(query,page,size);
    }

}
