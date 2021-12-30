package jp.co.project.planets.moon.security.oauth2.server;

import jp.co.project.planets.moon.helper.ConvertHelper;
import jp.co.project.planets.pleiades.db.entity.Oauth2Authorization;
import jp.co.project.planets.pleiades.repository.OAuth2AuthorizationRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthorizationCode;
import org.springframework.security.oauth2.core.OAuth2RefreshToken;
import org.springframework.security.oauth2.core.OAuth2TokenType;
import org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames;
import org.springframework.security.oauth2.core.oidc.OidcIdToken;
import org.springframework.security.oauth2.server.authorization.OAuth2Authorization;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationService;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Objects;
import java.util.Optional;

public class MoonAuthorizationService implements OAuth2AuthorizationService {

    private final RegisteredClientRepository registeredClientRepository;
    private final OAuth2AuthorizationRepository oauth2AuthorizationRepository;
    private final ConvertHelper convertHelper;

    public MoonAuthorizationService(RegisteredClientRepository registeredClientRepository, OAuth2AuthorizationRepository oauth2AuthorizationRepository, ConvertHelper convertHelper) {
        this.registeredClientRepository = registeredClientRepository;
        this.oauth2AuthorizationRepository = oauth2AuthorizationRepository;
        this.convertHelper = convertHelper;
    }

    @Override
    public void save(OAuth2Authorization authorization) {
        final var oauth2Authorization = new Oauth2Authorization();
        final var authorizationCode = authorization.getToken(OAuth2AuthorizationCode.class);
        if (Objects.nonNull(authorizationCode)) {
            final var authorizationCodeToken = authorizationCode.getToken();
            oauth2Authorization.setAuthorizationGrantType(oauth2Authorization.getAuthorizationGrantType());
            oauth2Authorization.setAuthorizationCodeValue((authorizationCodeToken.getTokenValue()));
            oauth2Authorization.setAuthorizationCodeExpiresAt(LocalDateTime.ofInstant(authorizationCodeToken.getExpiresAt(), ZoneOffset.UTC));
            oauth2Authorization.setAuthorizationCodeIssuedAt(LocalDateTime.ofInstant(authorizationCodeToken.getIssuedAt(), ZoneOffset.UTC));
            final var metadataJson = convertHelper.convertObjectIntoJson(authorizationCode.getMetadata());
            oauth2Authorization.setAuthorizationCodeMetadata(metadataJson);
        }
        final var attribute = convertHelper.convertObjectIntoJson(authorization.getAttributes());
        oauth2Authorization.setAttributes(attribute);
        Optional.ofNullable((String)authorization.getAttribute(OAuth2ParameterNames.STATE)).ifPresent(oauth2Authorization::setState);

        final var oauth2AccessTokenToken = authorization.getToken(OAuth2AccessToken.class);
        if (Objects.nonNull(oauth2AccessTokenToken)) {
            final var accessToken = oauth2AccessTokenToken.getToken();
            oauth2Authorization.setAccessTokenValue(accessToken.getTokenValue());
            oauth2Authorization.setAccessTokenExpiresAt(LocalDateTime.ofInstant(accessToken.getExpiresAt(), ZoneOffset.UTC));
            oauth2Authorization.setAccessTokenIssuedAt(LocalDateTime.ofInstant(accessToken.getIssuedAt(), ZoneOffset.UTC));
            final var metadataJson = convertHelper.convertObjectIntoJson(oauth2AccessTokenToken.getMetadata());
            oauth2Authorization.setAccessTokenMetadata(metadataJson);
        }

        final var oidcIdTokenToken = authorization.getToken(OidcIdToken.class);
        if (Objects.nonNull(oidcIdTokenToken)) {
            final var token = oidcIdTokenToken.getToken();
            oauth2Authorization.setOidcIdTokenValue(token.getTokenValue());
            oauth2Authorization.setOidcIdTokenExpiresAt(LocalDateTime.ofInstant(token.getExpiresAt(), ZoneOffset.UTC));
            oauth2Authorization.setOidcIdTokenIssuedAt(LocalDateTime.ofInstant(token.getIssuedAt(), ZoneOffset.UTC));
            final var metadataJson = convertHelper.convertObjectIntoJson(oidcIdTokenToken.getMetadata());
            oauth2Authorization.setOidcIdTokenMetadata(metadataJson);
        }
        final var refreshTokenToken = authorization.getRefreshToken();
        if (Objects.nonNull(refreshTokenToken)) {
            final var token = refreshTokenToken.getToken();
            oauth2Authorization.setRefreshTokenValue(token.getTokenValue());
            oauth2Authorization.setRefreshTokenExpiresAt(LocalDateTime.ofInstant(token.getExpiresAt(), ZoneOffset.UTC));
            oauth2Authorization.setRefreshTokenIssuedAt(LocalDateTime.ofInstant(token.getIssuedAt(), ZoneOffset.UTC));
            final var metadataJson = convertHelper.convertObjectIntoJson(refreshTokenToken.getMetadata());
            oauth2Authorization.setRefreshTokenMetadata(metadataJson);
        }
        oauth2AuthorizationRepository.insert(oauth2Authorization);
    }

    @Override
    public void remove(OAuth2Authorization authorization) {

    }

    @Override
    public OAuth2Authorization findById(String id) {
        final var entity = oauth2AuthorizationRepository.findByPrimaryKey(id);
        final var client = registeredClientRepository.findByClientId(entity.getRegisteredClientId());
        final var builder = OAuth2Authorization.withRegisteredClient(client);
        builder.id(entity.getId());
        builder.principalName(entity.getPrincipalName());
        if (StringUtils.isNotBlank(entity.getAccessTokenValue())) {
            final var oauth2AccessToken = new OAuth2AccessToken( //
                    OAuth2AccessToken.TokenType.BEARER, //
                    entity.getAccessTokenValue(), //
                    entity.getAccessTokenIssuedAt().toInstant(ZoneOffset.UTC), //
                    entity.getAccessTokenExpiresAt().toInstant(ZoneOffset.UTC) //
            );
            builder.accessToken(oauth2AccessToken);
        }
        if (StringUtils.isNotBlank(entity.getRefreshTokenValue())) {
            final var refreshToken = new OAuth2RefreshToken( //
                    entity.getRefreshTokenValue(), //
                    entity.getRefreshTokenIssuedAt().toInstant(ZoneOffset.UTC), //
                    entity.getRefreshTokenExpiresAt().toInstant(ZoneOffset.UTC) //
            );
            builder.refreshToken(refreshToken);
        }

        if (StringUtils.isNotBlank(entity.getAuthorizationCodeValue())) {
            final var token = new OAuth2AuthorizationCode( //
                    entity.getAuthorizationCodeValue(), //
                    entity.getAuthorizationCodeIssuedAt().toInstant(ZoneOffset.UTC), //
                    entity.getAuthorizationCodeExpiresAt().toInstant(ZoneOffset.UTC) //
            );
            builder.token(token);
            builder.authorizationGrantType(new AuthorizationGrantType(entity.getAuthorizationGrantType()));
        }
        return builder.build();
    }

    @Override
    public OAuth2Authorization findByToken(String token, OAuth2TokenType tokenType) {
        // JdbcOAuth2AuthorizationServiceを参考に
        return null;
    }
}
