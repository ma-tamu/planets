package jp.co.project.planets.earthly.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * security config
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();

        http.authorizeRequests() //
                .antMatchers("/login", "/css/**", "/js/**", "/img/**").permitAll().anyRequest().authenticated().and() //
                .formLogin().loginProcessingUrl("/login").usernameParameter("userId").passwordParameter("password").and() //
                .logout().logoutSuccessUrl("/login").invalidateHttpSession(true).deleteCookies("JSESSIONID").clearAuthentication(true);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }
}
