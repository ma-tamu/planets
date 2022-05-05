package jp.co.project.planets.earthly.model.dto;

import jp.co.project.planets.earthly.emuns.PermissionEnum;
import jp.co.project.planets.pleiades.model.entity.CompanyEntity;
import org.springframework.security.core.CredentialsContainer;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * user detail dto
 */
public class UserDetailDto implements UserDetails, CredentialsContainer {

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

    /** 会社 */
    private final CompanyEntity company;

    /** パーミッションリスト */
    private final List<PermissionEnum> permissionList;

    /**
     * new instance user detail dto
     *
     * @param id
     *         ユーザーID
     * @param loginId
     *         ログインID
     * @param name
     *         ユーザー名
     * @param gender
     *         性別
     * @param mail
     *         メールアドレス
     * @param password
     *         パスワード
     * @param company
     *         会社
     * @param permissionList
     *         パーミッションリスト
     */
    public UserDetailDto(final String id, final String loginId, final String name, final String gender,
                         final String mail, final String password,
                         final CompanyEntity company, final List<PermissionEnum> permissionList) {
        this.id = id;
        this.loginId = loginId;
        this.name = name;
        this.gender = gender;
        this.mail = mail;
        this.password = password;
        this.company = company;
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLockout();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
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
        return false;
    }

    public boolean isDeleted() {
        return false;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public List<PermissionEnum> getPermissionList() {
        return permissionList;
    }


    @Override
    public void eraseCredentials() {
        
    }
}
