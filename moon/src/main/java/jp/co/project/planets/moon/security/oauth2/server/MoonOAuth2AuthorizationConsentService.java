package jp.co.project.planets.moon.security.oauth2.server;

import jp.co.project.planets.pleiades.db.dao.OauthClientConsentDao;
import jp.co.project.planets.pleiades.db.entity.OauthClientConsent;
import jp.co.project.planets.pleiades.util.EntityUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * moon oauth2 authorization consent service
 */
@Component
public class MoonOAuth2AuthorizationConsentService implements OAuth2AuthorizationConsentService {

    private final OauthClientConsentDao oauthClientConsentDao;

    /**
     * new instance moon oauth2 authorization consent service
     *
     * @param oauthClientConsentDao
     *         OAuthクライアント承認DAO
     */
    public MoonOAuth2AuthorizationConsentService(OauthClientConsentDao oauthClientConsentDao) {
        this.oauthClientConsentDao = oauthClientConsentDao;
    }

    @Override
    @Transactional
    public void save(OAuth2AuthorizationConsent authorizationConsent) {
        final var oauthClientConsent = new OauthClientConsent();
        oauthClientConsent.setId(EntityUtils.generateId());
        oauthClientConsent.setOauthClientId(authorizationConsent.getRegisteredClientId());
        oauthClientConsent.setUserId(authorizationConsent.getPrincipalName());
        oauthClientConsent.setScope(authorizationConsent.getScopes().stream().reduce((s, s2) -> s + " " + s2).get());
        oauthClientConsent.setCreatedBy("NULL");
        oauthClientConsent.setCreatedAt(LocalDateTime.now(ZoneOffset.UTC));
        oauthClientConsentDao.insert(oauthClientConsent);
    }

    @Override
    @Transactional
    public void remove(OAuth2AuthorizationConsent authorizationConsent) {
        final var oauthClientConsentOptional = oauthClientConsentDao.selectConsentClientIdByUserId(authorizationConsent.getRegisteredClientId(), authorizationConsent.getPrincipalName());
        if (oauthClientConsentOptional.isEmpty()) {
            return;
        }
        final var oauthClientConsent = oauthClientConsentOptional.get();
        oauthClientConsent.setIsDeleted(true);
        oauthClientConsentDao.update(oauthClientConsent);
    }

    @Override
    public OAuth2AuthorizationConsent findById(String registeredClientId, String principalName) {
        final var oauthClientConsentOptional = oauthClientConsentDao.selectConsentClientIdByUserId(registeredClientId, principalName);
        if (oauthClientConsentOptional.isEmpty()) {
            return null;
        }
        final var oauthClientConsent = oauthClientConsentOptional.get();
        final var builder = OAuth2AuthorizationConsent.withId(registeredClientId, principalName);
        builder.scope(oauthClientConsent.getScope());
        return builder.build();
    }
}
