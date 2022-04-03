package jp.co.project.planets.pleiades.db.dao;

import jp.co.project.planets.pleiades.db.dao.base.PermissionBaseDao;
import jp.co.project.planets.pleiades.db.entity.Permission;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.List;

/**
 * permission dao
 */
@Dao
@ConfigAutowireable
public interface PermissionDao extends PermissionBaseDao {

    /**
     * 対象ユーザーに付与されているパーミッションを取得
     *
     * @param userId
     *         ユーザーID
     * @return パーミッションリスト
     */
    @Select
    List<Permission> selectGrantedPermissionByUserId(String userId);
}
