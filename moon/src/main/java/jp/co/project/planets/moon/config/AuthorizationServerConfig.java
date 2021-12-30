package jp.co.project.planets.moon.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import jp.co.project.planets.moon.security.Jwks;
import jp.co.project.planets.moon.security.oauth2.client.MoonRegisteredClientRepository;
import jp.co.project.planets.moon.security.oauth2.server.MoonOAuth2AuthorizationConsentService;
import jp.co.project.planets.pleiades.db.dao.OauthClientConsentDao;
import jp.co.project.planets.pleiades.repository.OAuthClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.authorization.OAuth2AuthorizationServerConfigurer;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.JdbcOAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.web.SecurityFilterChain;

/**
 * authorization server config
 */
@Configuration(proxyBeanMethods = false)
public class AuthorizationServerConfig {

//    @Bean
//    @Order(Ordered.HIGHEST_PRECEDENCE)
//    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        final var oauth2AuthorizationServerConfigurer = new OAuth2AuthorizationServerConfigurer<HttpSecurity>();
//        oauth2AuthorizationServerConfigurer.authorizationEndpoint(oauth2AuthorizationEndpointConfigurer -> oauth2AuthorizationEndpointConfigurer.consentPage("/oauth2/content"));
//
//        final var requestMatcher = oauth2AuthorizationServerConfigurer.getEndpointsMatcher();
//        httpSecurity.requestMatcher(requestMatcher)
//                .authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated())
//                .csrf(csrf -> csrf.ignoringRequestMatchers(requestMatcher))
//                .apply(oauth2AuthorizationServerConfigurer);
//        return httpSecurity.formLogin(Customizer.withDefaults()).build();
//    }

    @Bean
    public RegisteredClientRepository registeredClientRepository(OAuthClientRepository oauthClientRepository) {
        return new MoonRegisteredClientRepository(oauthClientRepository);
    }

    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        final var rsaKey = Jwks.generateRsa();
        final var jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    @Bean
    public OAuth2AuthorizationService authorizationService(JdbcTemplate jdbcTemplate, RegisteredClientRepository moonRegisteredClientRepository) {
        return new JdbcOAuth2AuthorizationService(jdbcTemplate, moonRegisteredClientRepository);
    }


    @Bean
    public OAuth2AuthorizationConsentService authorizationConsentService(OauthClientConsentDao oauthClientConsentDao /*final JdbcTemplate jdbcTemplate, final RegisteredClientRepository registeredClientRepository*/) {
        return new MoonOAuth2AuthorizationConsentService(oauthClientConsentDao);
//        return new JdbcOAuth2AuthorizationConsentService(jdbcTemplate, registeredClientRepository);
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authorizationServerSecurityFilterChain(HttpSecurity http) throws Exception {
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
        return http.httpBasic().disable().formLogin(Customizer.withDefaults()).build();
    }

    // @formatter:off
//    @Bean
//    public RegisteredClientRepository registeredClientRepository(JdbcTemplate jdbcTemplate) {
//        RegisteredClient registeredClient = RegisteredClient.withId(UUID.randomUUID().toString())
//                .clientId("messaging-client")
//                .clientSecret("{noop}secret")
//                .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .authorizationGrantType(AuthorizationGrantType.REFRESH_TOKEN)
//                .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
//                .redirectUri("http://127.0.0.1:8080/login/oauth2/code/messaging-client-oidc")
//                .redirectUri("http://127.0.0.1:8080/authorized")
//                .redirectUri("http://127.0.0.1:8082/mars/swagger-ui/oauth2-redirect.html")
//                .scope(OidcScopes.OPENID)
//                .scope("message.read")
//                .scope("message.write")
//                .clientSettings(ClientSettings.builder().requireAuthorizationConsent(true).build())
//                .build();
//
//        // Save registered client in db as if in-memory
//        JdbcRegisteredClientRepository registeredClientRepository = new JdbcRegisteredClientRepository(jdbcTemplate);
//        registeredClientRepository.save(registeredClient);
//
//        return registeredClientRepository;
//    }
//    // @formatter:on
//
//    @Bean
//    public OAuth2AuthorizationService authorizationService(JdbcTemplate jdbcTemplate, RegisteredClientRepository registeredClientRepository) {
//        return new JdbcOAuth2AuthorizationService(jdbcTemplate, registeredClientRepository);
//    }
//
//    @Bean
//    public OAuth2AuthorizationConsentService authorizationConsentService(JdbcTemplate jdbcTemplate, RegisteredClientRepository registeredClientRepository) {
//        return new JdbcOAuth2AuthorizationConsentService(jdbcTemplate, registeredClientRepository);
//    }
//
//    @Bean
//    public JWKSource<SecurityContext> jwkSource() {
//        RSAKey rsaKey = Jwks.generateRsa();
//        JWKSet jwkSet = new JWKSet(rsaKey);
//        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
//    }
}
