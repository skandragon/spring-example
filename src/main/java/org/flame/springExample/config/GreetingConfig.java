package org.flame.springExample.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
@ConfigurationProperties(prefix = "greeting")
public class GreetingConfig {

  @NotBlank
  private String template;

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String value) {
    template = value;
  }
}
