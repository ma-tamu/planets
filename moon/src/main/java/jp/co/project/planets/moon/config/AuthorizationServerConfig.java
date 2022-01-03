package jp.co.project.planets.moon.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import jp.co.project.planets.moon.helper.ConvertHelper;
import jp.co.project.planets.moon.security.oauth2.Jwks;
import jp.co.project.planets.moon.security.oauth2.client.MoonRegisteredClientRepository;
import jp.co.project.planets.moon.security.oauth2.server.MoonOAuth2AuthorizationConsentService;
import jp.co.project.planets.moon.security.oauth2.server.MoonOAuth2AuthorizationService;
import jp.co.project.planets.pleiades.db.dao.OauthClientConsentDao;
import jp.co.project.planets.pleiades.repository.OAuth2AuthorizationRepository;
import jp.co.project.planets.pleiades.repository.OAuthClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.OAuth2AuthorizationServerConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.security.oauth2.server.authorization.config.ProviderSettings;
import org.springframework.security.web.SecurityFilterChain;

/**
 * authorization server config
 */
@Configuration(proxyBeanMethods = false)
public class AuthorizationServerConfig {

    /**
     * generate registered client repository
     *
     * @param oauthClientRepository
     *         oauth client repository
     * @param passwordEncoder
     *         password encoder
     * @return RegisteredClientRepository
     */
    @Bean
    public RegisteredClientRepository registeredClientRepository(final OAuthClientRepository oauthClientRepository,
                                                                 final PasswordEncoder passwordEncoder) {
        return new MoonRegisteredClientRepository(oauthClientRepository, passwordEncoder);
    }

    /**
     * generate jwk
     *
     * @return JWKSource
     */
    @Bean
    public JWKSource<SecurityContext> jwkSource() {
        final var rsaKey = Jwks.generateRsa();
        final var jwkSet = new JWKSet(rsaKey);
        return (jwkSelector, securityContext) -> jwkSelector.select(jwkSet);
    }

    /**
     * generate oauth2 authorization service
     *
     * @param moonRegisteredClientRepository
     *         registered client repository
     * @param oauth2AuthorizationRepository
     *         oauth2 authorization repository
     * @param convertHelper
     *         convert helper
     * @return OAuth2AuthorizationService
     */
    @Bean
    public OAuth2AuthorizationService authorizationService(
            final RegisteredClientRepository moonRegisteredClientRepository,
            final OAuth2AuthorizationRepository oauth2AuthorizationRepository, final ConvertHelper convertHelper) {
        return new MoonOAuth2AuthorizationService(moonRegisteredClientRepository, oauth2AuthorizationRepository,
                convertHelper);
    }


    /**
     * generate oauth2 authorization consent service
     *
     * @param oauthClientConsentDao
     *         oauth client consent dao
     * @param convertHelper
     *         convert helper
     * @return OAuth2AuthorizationConsentService
     */
    @Bean
    public OAuth2AuthorizationConsentService authorizationConsentService(
            final OauthClientConsentDao oauthClientConsentDao, final ConvertHelper convertHelper) {
        return new MoonOAuth2AuthorizationConsentService(oauthClientConsentDao, convertHelper);
    }

    /**
     * generate authorization server security filter chain
     *
     * @param http
     *         http security
     * @return SecurityFilterChain
     * @throws Exception
     *         failed generate security filter chain.
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SecurityFilterChain authorizationServerSecurityFilterChain(final HttpSecurity http) throws Exception {
        OAuth2AuthorizationServerConfiguration.applyDefaultSecurity(http);
        return http.formLogin(Customizer.withDefaults()).build();
    }


    /**
     * generate provider settings
     *
     * @return ProviderSettings
     */
    @Bean
    public ProviderSettings providerSettings() {
        return ProviderSettings.builder().issuer("http://auth-server:9000").build();
    }
}
