package com.example.demo.repositories;
import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.models.Question;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import org.springframework.data.domain.Pageable;
import java.time.LocalDateTime;

@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {
    @Query("{}")
    Flux<Question> findAllContent();

    Flux<QuestionResponseDto> searchQuestionByContent(String content);

    @Query("{$or:  [{title: {$regex:  ?0,$options: 'i'}},{content :  {$regex:  ?0, $options: 'i'}}]}")
    Flux<Question> findByTitleOrContentContainingIgnoreCase(String searchTerm, Pageable pageable);

    Flux<Question> findByCreatedAtGreaterThanOrderByCreatedAtAsc(LocalDateTime cursor, Pageable pageable);

    Flux<Question> findTop10ByOrderByCreatedAtAsc();
}
