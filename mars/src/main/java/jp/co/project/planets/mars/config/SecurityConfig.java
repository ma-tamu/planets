package jp.co.project.planets.mars.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * security config
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // Basic認証を無効化
        http.httpBasic().disable();

        http.authorizeRequests().antMatchers("/api-docs/**", "/swagger-ui/**", "/swagger-ui.html",
                "/health").permitAll().anyRequest().authenticated().and().oauth2ResourceServer().opaqueToken();
    }
}
