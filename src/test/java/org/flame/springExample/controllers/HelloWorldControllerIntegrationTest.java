package org.flame.springExample.controllers;

import org.flame.springExample.models.Greeting;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerIntegrationTest {

  @LocalServerPort
  private int port;

  private URL base;

  @Autowired
  private TestRestTemplate template;

  @BeforeEach
  public void setUp() throws Exception {
    this.base = new URL("http://localhost:" + port + "/hello-world");
  }

  @Test
  public void getHello() throws Exception {
    ResponseEntity<Greeting> response = template.getForEntity(base.toString(), Greeting.class);
    assertThat(response.getStatusCode().value(), is(200));
    assertThat(response.getBody(), is(notNullValue()));
    assertThat(response.getBody().getContent(), is("Hello, Stranger!"));
  }
}
