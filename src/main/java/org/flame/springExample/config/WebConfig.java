package org.flame.springExample.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;


@EnableWebMvc
@Configuration
@ComponentScan({"org.flame.springExample"})
public class WebConfig implements WebMvcConfigurer {

  @Autowired
  @Qualifier("yamlObjectMapper")
  private ObjectMapper yamlObjectMapper;

  private static final MediaType MEDIA_TYPE_YAML = MediaType.valueOf("text/yaml");
  private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("text/yml");

  public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    configurer
        .favorParameter(false)
        .ignoreAcceptHeader(false)
        .defaultContentType(MediaType.APPLICATION_JSON)
        .mediaType("yaml", MEDIA_TYPE_YAML)
        .mediaType("yml", MEDIA_TYPE_YML)
        .mediaType("json", MediaType.APPLICATION_JSON);
  }

  @Override
  public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    MappingJackson2HttpMessageConverter yamlConverter = new MappingJackson2HttpMessageConverter(yamlObjectMapper);
    yamlConverter.setSupportedMediaTypes(Arrays.asList(MEDIA_TYPE_YML, MEDIA_TYPE_YAML));
    converters.add(yamlConverter);
  }
}
