package jp.co.project.planets.pleiades.db.dao.base;

import jp.co.project.planets.pleiades.db.entity.Region;
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
public interface RegionBaseDao {

    /**
     * @param id
     * @return the Region entity
     */
    @Select
    Region selectById(String id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Region entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Region entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Region entity);
}
