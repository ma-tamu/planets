package jp.co.project.planets.pleiades.db.dao.base;

import jp.co.project.planets.pleiades.db.entity.Permission;
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
public interface PermissionBaseDao {

    /**
     * @param id
     * @return the Permission entity
     */
    @Select
    Permission selectById(String id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Permission entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Permission entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Permission entity);
}
