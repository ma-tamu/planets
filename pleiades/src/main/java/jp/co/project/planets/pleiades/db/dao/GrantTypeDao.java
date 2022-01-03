package jp.co.project.planets.pleiades.db.dao;

import jp.co.project.planets.pleiades.db.dao.base.GrantTypeBaseDao;
import jp.co.project.planets.pleiades.db.entity.GrantType;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 * grant type dao
 */
@Dao
@ConfigAutowireable
public interface GrantTypeDao extends GrantTypeBaseDao {

    /**
     * select by client id
     *
     * @param clientId
     *         client id
     * @return grant types
     */
    @Select
    List<GrantType> selectByClientId(String clientId);
}
