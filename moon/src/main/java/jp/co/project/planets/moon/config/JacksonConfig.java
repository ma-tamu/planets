package jp.co.project.planets.moon.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * jackson config
 */
@Configuration
public class JacksonConfig {

    /**
     * ObjectMapperを生成
     *
     * @return ObjectMapper
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);
    }

}
