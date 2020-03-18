package org.flame.springExample.services;

import org.flame.springExample.models.Greeting;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class GreetingService {
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  public Greeting makeGreeting(String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
