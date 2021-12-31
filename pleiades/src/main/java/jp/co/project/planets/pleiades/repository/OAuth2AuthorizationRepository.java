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
     * find by primary key
     *
     * @param id
     *         id
     * @return Oauth2Authorization
     */
    public Oauth2Authorization findByPrimaryKey(final String id) {
        return oauth2AuthorizationDao.selectById(id);
    }


    /**
     * find by state
     *
     * @param state
     *         state
     * @return Oauth2Authorization
     */
    public Oauth2Authorization findByState(final String state) {
        return oauth2AuthorizationDao.selectByState(state);
    }

    /**
     * find by auth code
     *
     * @param code
     *         auth code
     * @return Oauth2Authorization
     */
    public Oauth2Authorization findByCode(final String code) {
        return oauth2AuthorizationDao.selectByCode(code);
    }

    /**
     * find by access token
     *
     * @param accessToken
     *         access token
     * @return Oauth2Authorization
     */
    public Oauth2Authorization findByAccessToken(final String accessToken) {
        return oauth2AuthorizationDao.selectByAccessToken(accessToken);
    }

    /**
     * find by refresh token
     *
     * @param refreshToken
     *         refresh token
     * @return Oauth2Authorization
     */
    public Oauth2Authorization findByRefreshToken(final String refreshToken) {
        return oauth2AuthorizationDao.selectByRefreshToken(refreshToken);
    }

    /**
     * find by unknown token
     *
     * @param token
     *         unknown token
     * @return Oauth2Authorization
     */
    public Oauth2Authorization findByUnknownToken(final String token) {
        return oauth2AuthorizationDao.selectByUnknownToken(token);
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
