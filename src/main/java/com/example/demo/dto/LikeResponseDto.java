package com.example.demo.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeResponseDto {

    private String id;
    private String targetId;
    private String targetType;
    private Boolean isLike;
    private LocalDateTime createdAt;
}
