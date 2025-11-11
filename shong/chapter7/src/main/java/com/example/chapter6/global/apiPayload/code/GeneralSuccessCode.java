package com.example.chapter6.global.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

//애플리케이션 전반에서 사용되는 가장 일반적인 성공 상태 코드를 정의.
@Getter
@AllArgsConstructor
// BaseSuccessCode 인터페이스를 구현
public enum GeneralSuccessCode implements BaseSuccessCode {

    // [200 OK]
    // 가장 일반적인 성공 (조회 성공 등)
    OK(HttpStatus.OK,
            "COMMON200_1",
            "요청에 성공했습니다."),

    // [201 Created]
    // 리소스가 성공적으로 생성되었을 때 사용 (회원가입, 게시글 작성 동)
    CREATED(HttpStatus.CREATED,
            "COMMON201_1",
            "요청한 리소스가 성공적으로 생성되었습니다."),

    // [202 Accepted]
    // 요청은 접수하였지만 처리가 완료되지 않았다
    ACCEPTED(HttpStatus.ACCEPTED,
            "COMMON202_1",
            "요청이 성공적으로 접수되었습니다.")
    ;

    private final HttpStatus status;
    private final String code;
    private final String message;
}
