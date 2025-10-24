package com.example.demo.services;
import com.example.demo.adapter.QuestionAdapter;
import com.example.demo.dto.QuestionRequestDTO;
import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.models.Question;
import com.example.demo.repositories.QuestionRepository;
import com.example.demo.utils.CursorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
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

    @Override
    public Mono<QuestionResponseDto> getQuestionById(String id) {
        return questionRepository.findById(id)
                .map(QuestionAdapter::toQuestionResponseDto)
                .doOnError(error -> System.out.println("Error fetching question: " + error))
                .doOnSuccess(response -> System.out.println("Question fetched successfully: " + response));
    }

//    @Override
//    public Flux<QuestionResponseDto> getAllQuestions() {
//        return questionRepository.findAllContent()
//                .map(QuestionAdapter::toQuestionResponseDto);
//    }

    @Override
    public Flux<QuestionResponseDto> getAllQuestions(String cursor, int size) {
        Pageable pageable = PageRequest.of(0, size);

        if(!CursorUtils.isValidCursor(cursor)) {
            return questionRepository.findTop10ByOrderByCreatedAtAsc()
                    .take(size)
                    .map(QuestionAdapter::toQuestionResponseDto)
                    .doOnError(error -> System.out.println("Error fetching questions: " + error))
                    .doOnComplete(() -> System.out.println("Questions fetched successfully"));
        } else {
            LocalDateTime cursorTimeStamp = CursorUtils.parseCursor(cursor);
            return questionRepository.findByCreatedAtGreaterThanOrderByCreatedAtAsc(cursorTimeStamp, pageable)
                    .map(QuestionAdapter::toQuestionResponseDto)
                    .doOnError(error -> System.out.println("Error fetching questions: " + error))
                    .doOnComplete(() -> System.out.println("Questions fetched successfully"));
        }
    }

    @Override
    public Mono<Void> deleteQuestionById(String id) {
        return questionRepository.deleteById(id);
    }

    @Override
    public Flux<QuestionResponseDto> searchQuestions(String query, int page, int size) {
        return questionRepository.findByTitleOrContentContainingIgnoreCase(query, PageRequest.of(page,size))
                .map(QuestionAdapter::toQuestionResponseDto)
                .doOnError(error -> System.out.println("Error searching questions: " + error))
                .doOnComplete(() -> System.out.println("Questions searched successfully"));
    }
}
