package jp.co.project.planets.earthly.logic;

import jp.co.project.planets.earthly.emuns.PermissionEnum;
import jp.co.project.planets.pleiades.repository.PermissionRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * permission logic
 */
@Component
public class PermissionLogic {

    private final PermissionRepository permissionRepository;


    /**
     * new instance permission logic
     *
     * @param permissionRepository
     *         permission repository
     */
    public PermissionLogic(final PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    /**
     * ユーザーに付与されているパーミッションを取得
     *
     * @param userId
     *         ユーザーID
     * @return パーミッションリスト
     */
    public List<PermissionEnum> findGrantPermissionByUserId(final String userId) {
        final var permissionList = permissionRepository.findGrantedPermissionByUserId(userId);
        return permissionList.stream().map(entity -> PermissionEnum.of(entity.getId())).collect(Collectors.toList());
    }
}
