package jp.co.project.planets.pleiades.db.dao.base;

import jp.co.project.planets.pleiades.db.entity.Oauth2RegisteredClient;
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
public interface Oauth2RegisteredClientBaseDao {

    /**
     * @param id
     * @return the Oauth2RegisteredClient entity
     */
    @Select
    Oauth2RegisteredClient selectById(String id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Oauth2RegisteredClient entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Oauth2RegisteredClient entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Oauth2RegisteredClient entity);
}
