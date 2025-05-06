package com.monkilatech.spring_rate_limiter.aspect;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import com.monkilatech.spring_rate_limiter.annotation.RateLimit;
import com.monkilatech.spring_rate_limiter.exception.RateLimitExceededException;
import com.monkilatech.spring_rate_limiter.service.RateLimitService;

import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

@Component
@Aspect
@RequiredArgsConstructor
public class RateLimitAspect {

    private final RateLimitService rateLimitService;
    private final HttpServletRequest request;

    @Around("@annotation(com.example.ratelimiter.annotation.RateLimit)")
    public Object checkRateLimit(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        RateLimit rateLimit = method.getAnnotation(RateLimit.class);

        String key = request.getRemoteAddr() + ":" + method.getName(); // IP-based key
        boolean allowed = rateLimitService.isAllowed(key, rateLimit.limit(), rateLimit.duration());

        if (!allowed) {
            throw new RateLimitExceededException("Trop de requêtes. Réessayez plus tard.");
        }

        return joinPoint.proceed();
    }
}

