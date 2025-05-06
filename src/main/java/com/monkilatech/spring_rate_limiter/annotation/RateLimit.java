package com.monkilatech.spring_rate_limiter.annotation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimit {
    int limit();       // Nombre max de requêtes
    int duration();    // Durée en secondes
}
