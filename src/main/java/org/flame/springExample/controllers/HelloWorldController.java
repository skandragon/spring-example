package org.flame.springExample.controllers;

import org.flame.springExample.models.Greeting;
import org.flame.springExample.services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

  private final GreetingService greetingService;

  @Autowired
  public HelloWorldController(GreetingService greetingService) {
    this.greetingService = greetingService;
  }

  @GetMapping("/hello-world")
  public Greeting sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
    return greetingService.makeGreeting(name);
  }
}
