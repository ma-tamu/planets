package jp.co.project.planets.pleiades.db.dao.base;

import jp.co.project.planets.pleiades.db.entity.Oauth2AuthorizationConsent;
import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;
import org.seasar.doma.boot.ConfigAutowireable;

/**
 */
@Dao
@ConfigAutowireable
public interface Oauth2AuthorizationConsentBaseDao {

    /**
     * @param registeredClientId
     * @param principalName
     * @return the Oauth2AuthorizationConsent entity
     */
    @Select
    Oauth2AuthorizationConsent selectById(String registeredClientId, String principalName);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Oauth2AuthorizationConsent entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Oauth2AuthorizationConsent entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Oauth2AuthorizationConsent entity);
}
