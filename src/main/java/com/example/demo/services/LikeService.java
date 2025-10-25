package com.example.demo.services;
import com.example.demo.dto.LikeRequestDto;
import com.example.demo.dto.LikeResponseDto;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class LikeService implements ILikeService {
    @Override
    public Mono<LikeResponseDto> createLike(LikeRequestDto likeRequestDto) {
        return null;
    }

    @Override
    public Mono<LikeResponseDto> countLikesByTargetIdAndTargetType(String targetId, String targetType) {
        return null;
    }

    @Override
    public Mono<LikeResponseDto> countDisLikesByTargetIdAndTargetType(String targetId, String targetType) {
        return null;
    }

    @Override
    public Mono<LikeResponseDto> toggleLike(String targetId, String targetType) {
        return null;
    }
}
