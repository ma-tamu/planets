package jp.co.project.planets.moon.security.oauth2.server;

import jp.co.project.planets.moon.helper.ConvertHelper;
import jp.co.project.planets.pleiades.db.dao.OauthClientConsentDao;
import jp.co.project.planets.pleiades.db.entity.OauthClientConsent;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsent;
import org.springframework.security.oauth2.server.authorization.OAuth2AuthorizationConsentService;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * moon oauth2 authorization consent service
 */
public class MoonOAuth2AuthorizationConsentService implements OAuth2AuthorizationConsentService {

    private final OauthClientConsentDao oauthClientConsentDao;
    private final ConvertHelper convertHelper;

    /**
     * new instance moon oauth2 authorization consent service
     *
     * @param oauthClientConsentDao
     *         OAuthクライアント承認DAO
     * @param convertHelper
     */
    public MoonOAuth2AuthorizationConsentService(final OauthClientConsentDao oauthClientConsentDao, final ConvertHelper convertHelper) {
        this.oauthClientConsentDao = oauthClientConsentDao;
        this.convertHelper = convertHelper;
    }

    @Override
    @Transactional
    public void save(final OAuth2AuthorizationConsent authorizationConsent) {
        final var oauthClientConsent = new OauthClientConsent();
        oauthClientConsent.setRegisteredClientId(authorizationConsent.getRegisteredClientId());
        oauthClientConsent.setPrincipalName(authorizationConsent.getPrincipalName());
        final var json = convertHelper.convertObjectIntoJson(authorizationConsent.getAuthorities());
        oauthClientConsent.setAuthorities(json);
        oauthClientConsentDao.insert(oauthClientConsent);
    }

    @Override
    @Transactional
    public void remove(final OAuth2AuthorizationConsent authorizationConsent) {
        final var oauthClientConsentOptional = oauthClientConsentDao.selectConsentClientIdByUserId(authorizationConsent.getRegisteredClientId(), authorizationConsent.getPrincipalName());
        if (oauthClientConsentOptional.isEmpty()) {
            return;
        }
        final var oauthClientConsent = oauthClientConsentOptional.get();
        oauthClientConsentDao.delete(oauthClientConsent);
    }

    @Override
    public OAuth2AuthorizationConsent findById(final String registeredClientId, final String principalName) {
        final var oauthClientConsentOptional = oauthClientConsentDao.selectConsentClientIdByUserId(registeredClientId, principalName);
        if (oauthClientConsentOptional.isEmpty()) {
            return null;
        }
        final var oauthClientConsent = oauthClientConsentOptional.get();
        final var builder = OAuth2AuthorizationConsent.withId(registeredClientId, principalName);
        final var grantedAuthoritySet = (Set<GrantedAuthority>) convertHelper.convertJsonIntoObject(oauthClientConsent.getAuthorities(), Set.class);
        grantedAuthoritySet.forEach(builder::authority);
        return builder.build();
    }
}
