package com.example.demo.models;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Answers")
public class Answer {

    @Id
    private String id;

    @NotBlank(message="Content is Required")
    @Size(min=10, max=10000, message="Content should be between 10 and 10000 characters")
    private String content;

    @Indexed
    private String questionId;

    private Integer viewCount;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
