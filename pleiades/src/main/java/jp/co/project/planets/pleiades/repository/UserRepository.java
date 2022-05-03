package jp.co.project.planets.pleiades.repository;

import jp.co.project.planets.pleiades.db.dao.UserDao;
import jp.co.project.planets.pleiades.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * user repository
 */
@Repository
public class UserRepository {

    private final UserDao userDao;

    /**
     * new instance user repository
     *
     * @param userDao
     *         user dao
     */
    public UserRepository(final UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * find by primary key
     *
     * @param id
     *         user id
     * @return User
     */
    public Optional<UserEntity> findByPrimaryKey(final String id) {
        return userDao.selectById(id);
    }
}
