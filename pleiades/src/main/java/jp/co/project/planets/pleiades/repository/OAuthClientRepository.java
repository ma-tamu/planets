package jp.co.project.planets.pleiades.repository;

import jp.co.project.planets.pleiades.db.dao.GrantTypeDao;
import jp.co.project.planets.pleiades.db.dao.OAuthClientDao;
import jp.co.project.planets.pleiades.db.dao.RedirectUriDao;
import jp.co.project.planets.pleiades.db.dao.ScopeDao;
import jp.co.project.planets.pleiades.db.entity.OauthClient;
import jp.co.project.planets.pleiades.model.entity.OAuthClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

/**
 * oauth client repository
 */
@Repository
public class OAuthClientRepository {

    private final OAuthClientDao oauthClientDao;
    private final GrantTypeDao grantTypeDao;
    private final ScopeDao scopeDao;
    private final RedirectUriDao redirectUriDao;

    @Autowired
    public OAuthClientRepository(OAuthClientDao oauthClientDao, GrantTypeDao grantTypeDao, ScopeDao scopeDao, RedirectUriDao redirectUriDao) {
        this.oauthClientDao = oauthClientDao;
        this.grantTypeDao = grantTypeDao;
        this.scopeDao = scopeDao;
        this.redirectUriDao = redirectUriDao;
    }

    /**
     * find by id
     *
     * @param id
     *         id
     * @return OAuthClientEntity
     */
    public OAuthClientEntity findById(final String id) {
        final var oauthClient = oauthClientDao.selectById(id);
        if (Objects.isNull(oauthClient)) {
            return null;
        }
        return generateOAuthClientEntity(oauthClient);
    }

    /**
     * find by client id
     *
     * @param clientId
     *         client id
     * @return OAuthClientEntity
     */
    public OAuthClientEntity findByClientId(final String clientId) {
        final var oauthClientOptional = oauthClientDao.selectByClientId(clientId);
        if (oauthClientOptional.isEmpty()) {
            return null;
        }
        return generateOAuthClientEntity(oauthClientOptional.get());
    }

    /**
     * OAuthClientEntityを生成
     *
     * @param oauthClient
     *         OAuthクライアント
     * @return OAuthClientEntity
     */
    private OAuthClientEntity generateOAuthClientEntity(final OauthClient oauthClient) {
        final var id = oauthClient.getId();
        final var grantTypes = grantTypeDao.selectByClientId(id);
        final var scopes = scopeDao.selectByClientId(id);
        final var redirectUris = redirectUriDao.selectByClientId(id);
        return new OAuthClientEntity(id, oauthClient.getClientId(), oauthClient.getClientSecret(), oauthClient.getName(), scopes, grantTypes, redirectUris);
    }
}
