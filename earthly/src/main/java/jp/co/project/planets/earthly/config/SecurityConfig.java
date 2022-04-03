package jp.co.project.planets.earthly.config;

import jp.co.project.planets.earthly.security.EarthlyUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * security config
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final EarthlyUserDetailsService earthlyUserDetailsService;

    /**
     * @param earthlyUserDetailsService
     */
    public SecurityConfig(final EarthlyUserDetailsService earthlyUserDetailsService) {
        this.earthlyUserDetailsService = earthlyUserDetailsService;
    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.httpBasic().disable();

        http.authorizeRequests() //
                .antMatchers("/css/**", "/js/**", "/img/**", "/vendor/**").permitAll().anyRequest() //
                .authenticated().and() //
                .formLogin() //
                .loginPage("/login") //
                .loginProcessingUrl("/login") //
                .usernameParameter("loginId") //
                .passwordParameter("password") //
                .defaultSuccessUrl("/").permitAll().and() //
                .rememberMe().and()//
                .logout() //
                .logoutSuccessUrl("/") //
                .invalidateHttpSession(true) //
                .deleteCookies("JSESSIONID") //
                .clearAuthentication(true);
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(earthlyUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
