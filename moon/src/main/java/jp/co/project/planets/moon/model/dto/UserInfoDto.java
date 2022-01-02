package jp.co.project.planets.moon.model.dto;

import com.fasterxml.jackson.annotation.JacksonAnnotation;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

public class UserInfoDto implements UserDetails {

    private static final long serialVersionUID = 1L;

    private final String id;
    private final String loginId;
    private final String password;
    private final String name;
    private final boolean lockout;
    private final boolean deleted;

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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !lockout;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
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
