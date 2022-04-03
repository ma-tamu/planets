package jp.co.project.planets.pleiades.repository;

import jp.co.project.planets.pleiades.db.dao.PermissionDao;
import jp.co.project.planets.pleiades.db.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * permission repository
 */
@Repository
public class PermissionRepository {

    private final PermissionDao permissionDao;

    /**
     * new instance permission repository
     *
     * @param permissionDao
     *         permission dao
     */
    public PermissionRepository(final PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    /**
     * 対象ユーザーに付与されているパーミッションを取得
     *
     * @param userId
     *         ユーザーID
     * @return パーミッションリスト
     */
    public List<Permission> findGrantedPermissionByUserId(final String userId) {
        return permissionDao.selectGrantedPermissionByUserId(userId);
    }
}
