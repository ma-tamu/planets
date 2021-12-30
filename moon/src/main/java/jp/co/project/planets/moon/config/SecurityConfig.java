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

    @Autowired
    public SecurityConfig(LoginUserDetailService loginUserDetailService) {
        this.loginUserDetailService = loginUserDetailService;
    }

    //    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic().disable();
//        http.authorizeRequests(expressionInterceptUrlRegistry -> expressionInterceptUrlRegistry.anyRequest()
//                .authenticated()).formLogin(Customizer.withDefaults()).authenticationProvider(new MoonAuthenticationProvider());
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService() {
//        return loginUserDetailService;
//    }
//
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // @formatter:off
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        final var authenticationProvider = new MoonAuthenticationProvider();
        authenticationProvider.setUserDetailsService(loginUserDetailService);
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        http.authorizeRequests(authorizeRequests -> authorizeRequests.anyRequest().authenticated()).formLogin(Customizer.withDefaults()).authenticationProvider(authenticationProvider);
        return http.build();
    }
    // @formatter:on

    // @formatter:off
//    @Bean
//    UserDetailsService users() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user1")
//                .password("password")
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(user);
//    }
    // @formatter:on
}
