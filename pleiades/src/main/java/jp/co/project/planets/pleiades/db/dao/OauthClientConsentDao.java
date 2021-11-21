package jp.co.project.planets.pleiades.db.dao;

import jp.co.project.planets.pleiades.db.dao.base.OauthClientConsentBaseDao;
import jp.co.project.planets.pleiades.db.entity.OauthClientConsent;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.Optional;

/**
 * oauth client consent dao
 */
@Dao
@ConfigAutowireable
public interface OauthClientConsentDao extends OauthClientConsentBaseDao {

    @Select
    Optional<OauthClientConsent> selectConsentClientIdByUserId(String clientId, String userId);
}
