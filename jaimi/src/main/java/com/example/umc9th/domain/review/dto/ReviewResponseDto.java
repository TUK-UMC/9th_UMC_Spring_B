package com.example.umc9th.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// 리뷰 응답 데이터 전송 객체 (DTO)
// Controller → 클라이언트로 데이터를 전달할 때 사용
@Getter
@AllArgsConstructor
public class ReviewResponseDto {
    private String nickname;     // 작성자 닉네임
    private String storeName;    // 가게 이름
    private float star;          // 별점
    private String content;      // 리뷰 내용
    private String reply;        // 사장님 답글
    private String createdDate;  // 작성일 (문자열로 변환)

    @QueryProjection
    public ReviewResponseDto(String userName, String storeName, Integer star, String content, String reply, String createdDate) {
        this.userName = userName;
        this.storeName = storeName;
        this.star = star;
        this.content = content;
        this.reply = reply;
        this.createdDate = createdDate;
    }
}
