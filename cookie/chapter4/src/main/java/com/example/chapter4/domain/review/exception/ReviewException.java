package com.example.chapter4.domain.review.exception;

public class ReviewException extends RuntimeException {
    public ReviewException(String message) {
        super(message);
    }

    public ReviewException(String message, Throwable cause) {
        super(message, cause);
    }
}
