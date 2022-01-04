package jp.co.project.planets.moon.config;

import jp.co.project.planets.moon.security.LoginUserDetailService;
import jp.co.project.planets.moon.security.MoonAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * security config
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final LoginUserDetailService loginUserDetailService;

    /**
     * new instances security config
     *
     * @param loginUserDetailService
     */
    @Autowired
    public SecurityConfig(final LoginUserDetailService loginUserDetailService) {
        this.loginUserDetailService = loginUserDetailService;
    }

    /**
     * generate password encoder
     *
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * generate default security filter chain
     *
     * @param http
     *         http security
     * @return SecurityFilterChain
     * @throws Exception
     *         security filter chain generate failed.
     */
    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(final HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        final var authenticationProvider = new MoonAuthenticationProvider();
        authenticationProvider.setUserDetailsService(loginUserDetailService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        http.authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers("/oauth2/introspect", "/oauth2/jwks",
                        "/oauth2/revoke").permitAll().anyRequest().authenticated()) //
                .formLogin(Customizer.withDefaults()).authenticationProvider(authenticationProvider);
        return http.build();
    }
}
