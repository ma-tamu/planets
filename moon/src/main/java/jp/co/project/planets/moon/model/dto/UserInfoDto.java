package jp.co.project.planets.moon.model.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserInfoDto implements UserDetails {

    private String id;
    private String loginId;
    private String password;
    private String name;
    private boolean lockout;
    private boolean deleted;

    public UserInfoDto(String id, String loginId, String password, String name, boolean lockout, boolean deleted) {
        this.id = id;
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.lockout = lockout;
        this.deleted = deleted;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
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
        return !lockout;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return !deleted;
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

    public boolean isLockout() {
        return lockout;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
