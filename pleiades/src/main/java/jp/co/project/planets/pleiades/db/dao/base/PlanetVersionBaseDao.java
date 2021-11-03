package jp.co.project.planets.pleiades.db.dao.base;

import jp.co.project.planets.pleiades.db.entity.PlanetVersion;
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
public interface PlanetVersionBaseDao {

    /**
     * @param installedRank
     * @return the PlanetVersion entity
     */
    @Select
    PlanetVersion selectById(Integer installedRank);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(PlanetVersion entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(PlanetVersion entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(PlanetVersion entity);
}
