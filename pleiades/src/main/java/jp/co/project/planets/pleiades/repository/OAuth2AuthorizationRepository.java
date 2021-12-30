package jp.co.project.planets.pleiades.repository;

import jp.co.project.planets.pleiades.db.dao.OAuth2AuthorizationDao;
import jp.co.project.planets.pleiades.db.entity.Oauth2Authorization;
import jp.co.project.planets.pleiades.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * oauth2 authorization repository
 */
@Repository
public class OAuth2AuthorizationRepository {

    private final OAuth2AuthorizationDao oauth2AuthorizationDao;

    @Autowired
    public OAuth2AuthorizationRepository(OAuth2AuthorizationDao oauth2AuthorizationDao) {
        this.oauth2AuthorizationDao = oauth2AuthorizationDao;
    }

    /**
     * insert oauth2 authorization
     *
     * @param oauth2Authorization
     *         oauth2 authorization
     * @return insert count
     */
    public int insert(final Oauth2Authorization oauth2Authorization) {
        oauth2Authorization.setId(EntityUtils.generateId());
        return oauth2AuthorizationDao.insert(oauth2Authorization);
    }

    /**
     * update oauth2 authorization
     *
     * @param oauth2Authorization
     *         oauth2 authorization
     * @return update count
     */
    public int update(final Oauth2Authorization oauth2Authorization) {
        return oauth2AuthorizationDao.update(oauth2Authorization);
    }

    /**
     * delete oauth2 authorization
     *
     * @param oauth2Authorization
     *         oauth2 authorization
     * @return delete count
     */
    public int delete(final Oauth2Authorization oauth2Authorization) {
        return oauth2AuthorizationDao.delete(oauth2Authorization);
    }
}
