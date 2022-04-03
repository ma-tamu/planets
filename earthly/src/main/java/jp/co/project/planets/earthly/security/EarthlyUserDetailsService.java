package jp.co.project.planets.earthly.security;

import jp.co.project.planets.earthly.logic.PermissionLogic;
import jp.co.project.planets.earthly.model.dto.UserDetailDto;
import jp.co.project.planets.pleiades.db.dao.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * earthly user details Service
 */
@Service
public class EarthlyUserDetailsService implements UserDetailsService {

    private final UserDao userDao;

    private final PermissionLogic permissionLogic;

    /**
     * @param userDao
     *         ユーザーDAO
     * @param permissionLogic
     *         パーミッションロジック
     */
    public EarthlyUserDetailsService(final UserDao userDao, final PermissionLogic permissionLogic) {
        this.userDao = userDao;
        this.permissionLogic = permissionLogic;
    }

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("loginId empty.");
        }

        final var user = userDao.selectByLoginId(username).orElseThrow(
                () -> new UsernameNotFoundException("not found user."));
        final var permissionEnumList = permissionLogic.findGrantPermissionByUserId(user.getId());

        return new UserDetailDto(user.getId(), user.getLoginId(), user.getName(), user.getGender(), user.getMail(),
                user.getPassword(), user.getLockout(), user.getIsDeleted(), null, permissionEnumList);
    }
}
