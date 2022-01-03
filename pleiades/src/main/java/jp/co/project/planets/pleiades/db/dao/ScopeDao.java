package jp.co.project.planets.pleiades.db.dao;

import jp.co.project.planets.pleiades.db.dao.base.ScopeBaseDao;
import jp.co.project.planets.pleiades.db.entity.Scope;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 * scope dao
 */
@Dao
@ConfigAutowireable
public interface ScopeDao extends ScopeBaseDao {

    /**
     * select by client id
     *
     * @param clientId
     *         client id
     * @return scopes
     */
    @Select
    List<Scope> selectByClientId(String clientId);
}
