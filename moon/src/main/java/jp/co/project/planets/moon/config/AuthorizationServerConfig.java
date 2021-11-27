package jp.co.project.planets.moon.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import jp.co.project.planets.moon.security.Jwks;
import jp.co.project.planets.moon.security.oauth2.client.MoonRegisteredClientRepository;
import jp.co.project.planets.moon.security.oauth2.server.MoonOAuth2AuthorizationConsentService;
import jp.co.project.planets.pleiades.db.dao.OAuthClientDao;
import jp.co.project.planets.pleiades.db.dao.OauthClientConsentDao;
import jp.co.project.planets.pleiades.db.dao.OauthClientRedirectUrlDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.web.SecurityFilterChain;

/**
 * authorization server config
 */
@Configuration
public class AuthorizationServerConfig {

    private final OAuthClientDao oauthClientDao;
    private final OauthClientRedirectUrlDao oauthClientRedirectUrlDao;
    private final OauthClientConsentDao oauthClientConsentDao;

    @Autowired
    public AuthorizationServerConfig(OAuthClientDao oauthClientDao, OauthClientRedirectUrlDao oauthClientRedirectUrlDao, OauthClientConsentDao oauthClientConsentDao) {
        this.oauthClientDao = oauthClientDao;
        this.oauthClientRedirectUrlDao = oauthClientRedirectUrlDao;
        this.oauthClientConsentDao = oauthClientConsentDao;
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
    public RegisteredClientRepository registeredClientRepository() {
        return new MoonRegisteredClientRepository(oauthClientDao, oauthClientRedirectUrlDao);
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        final var rsaKey = Jwks.generateRsa();
        final var jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    @Bean
    public OAuth2AuthorizationService authorizationService() {
        return new JdbcOAuth2AuthorizationService();
    }


    @Bean
    public OAuth2AuthorizationConsentService authorizationConsentService(final JdbcTemplate jdbcTemplate, final RegisteredClientRepository registeredClientRepository) {
        return new MoonOAuth2AuthorizationConsentService(oauthClientConsentDao);
    }
}
