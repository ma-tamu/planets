package jp.co.project.planets.earthly.emuns;

import org.springframework.security.core.GrantedAuthority;

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
