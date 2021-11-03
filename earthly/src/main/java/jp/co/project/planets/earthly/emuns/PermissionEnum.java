package jp.co.project.planets.earthly.emuns;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

/**
 * permission enum
 */
public enum PermissionEnum implements GrantedAuthority {
    ;

    @Override
    public String getAuthority() {
        return null;
    }
}
