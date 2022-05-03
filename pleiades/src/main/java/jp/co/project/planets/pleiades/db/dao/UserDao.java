package jp.co.project.planets.pleiades.db.dao;

import jp.co.project.planets.pleiades.db.dao.base.UserBaseDao;
import jp.co.project.planets.pleiades.db.entity.User;
import jp.co.project.planets.pleiades.model.entity.UserEntity;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

import java.util.Optional;

/**
 * user doa
 */
@Dao
@ConfigAutowireable
public interface UserDao extends UserBaseDao {

    @Select
    Optional<UserEntity> selectAccessibleByPrimaryKey(String id);

    /**
     * ログインIDからユーザーを取得
     *
     * @param loginId
     *         ログインID
     * @return User
     */
    @Select
    Optional<User> selectByLoginId(String loginId);
}
