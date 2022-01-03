package jp.co.project.planets.pleiades.db.dao;

import jp.co.project.planets.pleiades.db.dao.base.OauthClientRedirectUrlBaseDao;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 * redirect uri dao
 */
@Dao
@ConfigAutowireable
public interface RedirectUriDao extends OauthClientRedirectUrlBaseDao {

    /**
     * select by client id
     *
     * @param clientId
     *         client id
     * @return redirect uri
     */
    @Select
    List<String> selectByClientId(String clientId);
}
