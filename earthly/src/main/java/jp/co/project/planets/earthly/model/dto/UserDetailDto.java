package jp.co.project.planets.earthly.model.dto;

import jp.co.project.planets.earthly.emuns.PermissionEnum;
import jp.co.project.planets.pleiades.db.entity.Office;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * user detail dto
 */
public class UserDetailDto implements UserDetails {

    private static final long serialVersionUID = 1L;

    /** ユーザーID */
    private final String id;

    /** ログインID */
    private final String loginId;

    /** ユーザー名 */
    private final String name;

    /** 性別 */
    private final String gender;

    /** メールアドレス */
    private final String mail;

    /** パスワード */
    private final String password;

    /** ロックアウト */
    private final boolean lockout;

    /** 削除フラグ */
    private final boolean deleted;

    /** オフィス */
    private final Office office;

    /** パーミッションリスト */
    private final List<PermissionEnum> permissionList;

    public UserDetailDto(String id, String loginId, String name, String gender, String mail, String password, boolean lockout, boolean deleted, Office office, List<PermissionEnum> permissionList) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.gender = gender;
        this.mail = mail;
        this.password = password;
        this.lockout = lockout;
        this.deleted = deleted;
        this.office = office;
        this.permissionList = permissionList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return permissionList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return loginId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLockout();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return !isDeleted();
    }

    public String getId() {
        return id;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getMail() {
        return mail;
    }

    public boolean isLockout() {
        return lockout;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public Office getOffice() {
        return office;
    }

    public List<PermissionEnum> getPermissionList() {
        return permissionList;
    }
}
