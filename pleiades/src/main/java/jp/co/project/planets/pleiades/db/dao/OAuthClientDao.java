package jp.co.project.planets.pleiades.db.dao;

import jp.co.project.planets.pleiades.db.dao.base.OauthClientBaseDao;
import jp.co.project.planets.pleiades.db.entity.OauthClient;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

/**
 * oauth client dao
 */
@Dao
@ConfigAutowireable
public interface OAuthClientDao extends OauthClientBaseDao {

    @Select
    OauthClient selectByClientId(String clientId);
}
