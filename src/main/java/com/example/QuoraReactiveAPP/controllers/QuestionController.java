package com.example.QuoraReactiveAPP.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @GetMapping("author/{authorId}")
    public Flux<QuestionResponse> getQuestionsByAuthor(){
        return null;
    }



}
