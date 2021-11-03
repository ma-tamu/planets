package jp.co.project.planets.pleiades.db.dao;

import jp.co.project.planets.pleiades.db.dao.base.OauthClientBaseDao;
import org.seasar.doma.Dao;
import org.seasar.doma.boot.ConfigAutowireable;

/**
 * oauth client dao
 */
@Dao
@ConfigAutowireable
public interface OAuthClientDao extends OauthClientBaseDao {
}
