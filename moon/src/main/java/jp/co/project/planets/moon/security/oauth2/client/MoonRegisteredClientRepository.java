package jp.co.project.planets.moon.security.oauth2.client;

import jp.co.project.planets.pleiades.db.dao.OAuthClientDao;
import jp.co.project.planets.pleiades.db.dao.OauthClientRedirectUrlDao;
import jp.co.project.planets.pleiades.db.entity.OauthClient;
import jp.co.project.planets.pleiades.db.entity.OauthClientRedirectUrl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClientRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * moon registered client repository
 */
public class MoonRegisteredClientRepository implements RegisteredClientRepository {

    private final OAuthClientDao oauthClientDao;
    private final OauthClientRedirectUrlDao oauthClientRedirectUrlDao;

    public MoonRegisteredClientRepository(final OAuthClientDao oauthClientDao, OauthClientRedirectUrlDao oauthClientRedirectUrlDao) {
        this.oauthClientDao = oauthClientDao;
        this.oauthClientRedirectUrlDao = oauthClientRedirectUrlDao;
    }

    @Override
    public void save(RegisteredClient registeredClient) {
        final var oauthClientOptional = Optional.ofNullable(oauthClientDao.selectById(registeredClient.getId()));
    }

    @Override
    public RegisteredClient findById(String id) {
        final var oauthClient = Optional.ofNullable(oauthClientDao.selectById(id)).orElseThrow();
        final var redirectUrlList = oauthClientRedirectUrlDao.selectByOAuthClientId(oauthClient.getId());
        return generateRegisteredClient(oauthClient, redirectUrlList);
    }

    @Override
    public RegisteredClient findByClientId(String clientId) {
        final var oauthClient = Optional.ofNullable(oauthClientDao.selectByClientId(clientId)).orElseThrow();
        final var redirectUrlList = oauthClientRedirectUrlDao.selectByOAuthClientId(oauthClient.getId());
        return generateRegisteredClient(oauthClient, redirectUrlList);
    }

    /**
     * RegisteredClientを生成
     *
     * @param oauthClient
     *         OAuthクライアント
     * @param redirectUrlList
     *         リダイレクトURLリスト
     * @return RegisteredClient
     */
    private RegisteredClient generateRegisteredClient(final OauthClient oauthClient, final List<OauthClientRedirectUrl> redirectUrlList) {
        final var builder = RegisteredClient.withId(oauthClient.getId());
        builder.clientId(oauthClient.getClientId());
        builder.clientSecret(oauthClient.getClientSecret());
        builder.clientName(oauthClient.getName());
        Stream.of(oauthClient.getScope().split(StringUtils.SPACE)).forEach(builder::scope);
        builder.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE);
        builder.clientSecretExpiresAt(Instant.ofEpochSecond(28800));
        redirectUrlList.stream().map(OauthClientRedirectUrl::getRedirectUrl).forEach(builder::redirectUri);
        builder.clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_JWT);
        return builder.build();

    }
}
