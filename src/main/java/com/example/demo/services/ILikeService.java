package com.example.demo.services;
import com.example.demo.dto.LikeRequestDto;
import com.example.demo.dto.LikeResponseDto;
import reactor.core.publisher.Mono;

public interface ILikeService {

    Mono<LikeResponseDto> createLike(LikeRequestDto likeRequestDto);
    Mono<LikeResponseDto> countLikesByTargetIdAndTargetType(String targetId, String targetType);
    Mono<LikeResponseDto> countDisLikesByTargetIdAndTargetType(String targetId, String targetType);
    Mono<LikeResponseDto> toggleLike(String targetId, String targetType);


}
