package com.monkilatech.spring_rate_limiter.service;


import com.github.benmanes.caffeine.cache.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class InMemoryRateLimitService implements RateLimitService {

    private final Cache<String, AtomicInteger> requestCounts;

    public InMemoryRateLimitService() {
        this.requestCounts = Caffeine.newBuilder()
                .expireAfterWrite(60, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public boolean isAllowed(String key, int limit, int durationSeconds) {
        AtomicInteger count = requestCounts.get(key, k -> new AtomicInteger(0));
        if (count.incrementAndGet() > limit) {
            return false;
        }
        return true;
    }
}
