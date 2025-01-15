package com.examples;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;
import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicLong;

@ApplicationScoped
public class CoffeeService {

    private AtomicLong counter = new AtomicLong(0);

    @CircuitBreaker(requestVolumeThreshold = 4)
    public String getCoffee() {
        long invocationNumber = counter.incrementAndGet();
        if (invocationNumber % 4 == 0) {
            return "Coffee!";
        } else {
            throw new RuntimeException("Service not available");
        }
    }
}

