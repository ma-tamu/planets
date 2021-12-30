package jp.co.project.planets.moon.security.oauth2.server;

import jp.co.project.planets.pleiades.db.entity.Oauth2Authorization;
import jp.co.project.planets.pleiades.repository.OAuth2AuthorizationRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthorizationCode;
import org.springframework.security.oauth2.core.OAuth2TokenType;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class MoonAuthorizationService implements OAuth2AuthorizationService {

    private final OAuth2AuthorizationRepository oauth2AuthorizationRepository;

    public MoonAuthorizationService(OAuth2AuthorizationRepository oauth2AuthorizationRepository) {
        this.oauth2AuthorizationRepository = oauth2AuthorizationRepository;
    }

    @Override
    public void save(OAuth2Authorization authorization) {
        final var oauth2Authorization = new Oauth2Authorization();
        final var authorizationCode = authorization.getToken(OAuth2AuthorizationCode.class);
        final var authorizationCodeToken = authorizationCode.getToken();
        oauth2Authorization.setAccessTokenValue(authorizationCodeToken.getTokenValue());
        oauth2Authorization.setAccessTokenExpiresAt(LocalDateTime.ofInstant(authorizationCodeToken.getExpiresAt(), ZoneOffset.UTC));
        oauth2Authorization.setAccessTokenIssuedAt(LocalDateTime.ofInstant(authorizationCodeToken.getIssuedAt(), ZoneOffset.UTC));
//        oauth2Authorization.setAccessTokenMetadata(authorizationCode.getMetadata());

        final var accessToken = authorization.getToken(OAuth2AccessToken.class);
        final var oidcIdTokenToken = authorization.getToken(OidcIdToken.class);
        final var refreshTokenToken = authorization.getRefreshToken();

//        oauth2Authorization.setAccessTokenIssuedAt(authorizationToken.getToken().getIssuedAt());
//        oauth2AuthorizationRepository.insert();
    }

    @Override
    public void remove(OAuth2Authorization authorization) {

    }

    @Override
    public OAuth2Authorization findById(String id) {
        return null;
    }

    @Override
    public OAuth2Authorization findByToken(String token, OAuth2TokenType tokenType) {
        return null;
    }
}
