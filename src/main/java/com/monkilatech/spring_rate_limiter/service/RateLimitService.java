package com.monkilatech.spring_rate_limiter.service;


public interface RateLimitService {
    boolean isAllowed(String key, int limit, int durationSeconds);
}

