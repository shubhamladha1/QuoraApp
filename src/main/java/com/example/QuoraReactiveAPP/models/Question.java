package com.example.QuoraReactiveAPP.models;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    @Id
    private String id;

    @NotBlank(message='Title is Required')
    private String title;

    private String authorId;



}
