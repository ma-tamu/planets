package jp.co.project.planets.pleiades.db.dao.base;

import jp.co.project.planets.pleiades.db.entity.Office;
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
public interface OfficeBaseDao {

    /**
     * @param id
     * @return the Office entity
     */
    @Select
    Office selectById(String id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(Office entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(Office entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(Office entity);
}
