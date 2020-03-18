package org.flame.springExample.controllers;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloWorldControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getHelloStranger() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("id").isNumber())
        .andExpect(jsonPath("content").value("Hello, Stranger!"));
  }

  @Test
  public void getHelloSkandragon() throws Exception {
    mvc.perform(MockMvcRequestBuilders.get("/hello-world?name=Skandragon").accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("id").isNumber())
        .andExpect(jsonPath("content").value("Hello, Skandragon!"));
  }
}
