package jp.co.project.planets.pleiades.db.dao.base;

import jp.co.project.planets.pleiades.db.entity.SubOffice;
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
public interface SubOfficeBaseDao {

    /**
     * @param id
     * @return the SubOffice entity
     */
    @Select
    SubOffice selectById(String id);

    /**
     * @param entity
     * @return affected rows
     */
    @Insert
    int insert(SubOffice entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Update
    int update(SubOffice entity);

    /**
     * @param entity
     * @return affected rows
     */
    @Delete
    int delete(SubOffice entity);
}
