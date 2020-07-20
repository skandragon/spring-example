package org.flame.springExample.services;

import org.flame.springExample.config.GreetingConfig;
import org.flame.springExample.models.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;

@Component
public class GreetingService {

  private final GreetingConfig config;

  @Value("${greetingService.id.offset:1000}")
  private Long idOffset;

  @Autowired
  public GreetingService(GreetingConfig config) {
    this.config = config;
  }

  private final AtomicLong counter = new AtomicLong();

  public Greeting makeGreeting(String name) {
    return new Greeting(counter.incrementAndGet() + idOffset,
                        String.format(config.getTemplate(), name),
                        config.getRegionName(),
                        config.getEnvironmentName(),
                        config.getProviderName());
  }
}
