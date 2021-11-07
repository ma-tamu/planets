package jp.co.project.planets.pleiades.db.dao.base;

import jp.co.project.planets.pleiades.db.entity.PlanetsVersion;
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
public interface PlanetsVersionBaseDao {

    /**
     * @param installedRank
     * @return the PlanetsVersion entity
     */
    @Select
    PlanetsVersion selectById(Integer installedRank);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(PlanetsVersion entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(PlanetsVersion entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(PlanetsVersion entity);
}