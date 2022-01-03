package jp.co.project.planets.pleiades.db.dao;

import jp.co.project.planets.pleiades.db.dao.base.Oauth2AuthorizationBaseDao;
import jp.co.project.planets.pleiades.db.entity.Oauth2Authorization;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;

/**
 * oauth2 authorization dao
 */
@Dao
@ConfigAutowireable
public interface OAuth2AuthorizationDao extends Oauth2AuthorizationBaseDao {

    /**
     * select by state
     *
     * @param state
     *         state
     * @return Oauth2Authorization
     */
    @Select
    Oauth2Authorization selectByState(String state);

    /**
     * select by auth code
     *
     * @param code
     *         auth code
     * @return Oauth2Authorization
     */
    @Select
    Oauth2Authorization selectByCode(String code);

    /**
     * select by access token
     *
     * @param accessToken
     *         access token
     * @return Oauth2Authorization
     */
    @Select
    Oauth2Authorization selectByAccessToken(String accessToken);

    /**
     * select by refresh token
     *
     * @param refreshToken
     *         refresh token
     * @return Oauth2Authorization
     */
    @Select
    Oauth2Authorization selectByRefreshToken(String refreshToken);

    /**
     * select by unknown token
     *
     * @param token
     *         unknown token
     * @return Oauth2Authorization
     */
    @Select
    Oauth2Authorization selectByUnknownToken(String token);
}
