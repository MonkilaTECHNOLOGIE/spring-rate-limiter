package com.monkilatech.spring_rate_limiter.handler;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.monkilatech.spring_rate_limiter.exception.RateLimitExceededException;

@RestControllerAdvice
public class RateLimitExceptionHandler {

    @ExceptionHandler(RateLimitExceededException.class)
    public ResponseEntity<String> handleRateLimit(RateLimitExceededException ex) {
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                             .body(ex.getMessage());
    }
}
