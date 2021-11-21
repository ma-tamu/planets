package jp.co.project.planets.moon.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import jp.co.project.planets.moon.security.oauth2.client.MoonRegisteredClientRepository;
import jp.co.project.planets.moon.security.Jwks;
import jp.co.project.planets.moon.security.oauth2.server.MoonOAuth2AuthorizationConsentService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.client.JdbcRegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;
import org.springframework.security.web.SecurityFilterChain;

/**
 * authorization server config
 */
@Configuration
public class AuthorizationServerConfig {

    private final MoonRegisteredClientRepository moonRegisteredClientRepository;
    private final MoonOAuth2AuthorizationConsentService moonOAuth2AuthorizationConsentService;

    public AuthorizationServerConfig(MoonRegisteredClientRepository moonRegisteredClientRepository, MoonOAuth2AuthorizationConsentService moonOAuth2AuthorizationConsentService) {
        this.moonRegisteredClientRepository = moonRegisteredClientRepository;
        this.moonOAuth2AuthorizationConsentService = moonOAuth2AuthorizationConsentService;
    }


    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        final var oauth2AuthorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer<HttpSecurity>();
        oauth2AuthorizationServerConfigurer.authorizationEndpoint(oauth2AuthorizationEndpointConfigurer -> oauth2AuthorizationEndpointConfigurer.consentPage("/oauth2/content"));

        final var requestMatcher = oauth2AuthorizationServerConfigurer.getEndpointsMatcher();
        httpSecurity.requestMatcher(requestMatcher)
                .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
                .csrf(csrf -> csrf.ignoringRequestMatchers(requestMatcher))
                .apply(oauth2AuthorizationServerConfigurer);
        return httpSecurity.formLogin(Customizer.withDefaults()).build();
    }

    @Bean
    public RegisteredClientRepository registeredClientRepository(final JdbcTemplate jdbcTemplate) {
        return new JdbcRegisteredClientRepository(jdbcTemplate);
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        final var rsaKey = Jwks.generateRsa();
        final var jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    @Bean
    public ProviderSettings providerSettings() {
        return ProviderSettings.builder().issuer("http://auth-server:9000").build();
    }

    @Bean
    public OAuth2AuthorizationConsentService authorizationConsentService(final JdbcTemplate jdbcTemplate, final RegisteredClientRepository registeredClientRepository) {
        // Will be used by the ConsentController
        return new JdbcOAuth2AuthorizationConsentService(jdbcTemplate, registeredClientRepository);
    }
}
