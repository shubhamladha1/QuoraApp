package com.example.demo.repositories;
import com.example.demo.models.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface LikeRepository extends ReactiveMongoRepository<Answer,String> {
}
