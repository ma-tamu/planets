package jp.co.project.planets.mars.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openAPI(@Value("${mars.oauth2.url.authorization}") final String authorizationUrl,
                           @Value("${mars.oauth2.url.token}") final String tokenUrl) {
        final var info = new Info().title("Mars API").version("v1");
        final var authorizationCodeFlow = new OAuthFlow().authorizationUrl(authorizationUrl).tokenUrl(tokenUrl).scopes(new Scopes().addString("message.read", "message.read").addString("message.write", "message.write"));
        final var flows = new OAuthFlows().authorizationCode(authorizationCodeFlow);
        final var securityScheme = new SecurityScheme().type(SecurityScheme.Type.OAUTH2).flows(flows);
        final var components = new Components().addSecuritySchemes("authorization_code", securityScheme);
        return new OpenAPI().info(info).components(components);
    }
}
