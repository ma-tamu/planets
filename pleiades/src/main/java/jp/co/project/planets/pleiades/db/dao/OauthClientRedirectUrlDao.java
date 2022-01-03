package jp.co.project.planets.pleiades.db.dao;

import jp.co.project.planets.pleiades.db.dao.base.OauthClientRedirectUrlBaseDao;
import jp.co.project.planets.pleiades.db.entity.OauthClientRedirectUrl;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 * oauth client redirect url dao
 */
@Dao
@ConfigAutowireable
public interface OauthClientRedirectUrlDao extends OauthClientRedirectUrlBaseDao {

    @Select
    List<OauthClientRedirectUrl> selectByOAuthClientId(String oauthClientId);
}
