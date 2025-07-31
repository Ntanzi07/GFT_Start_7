package dio.spring.security;

import dio.spring.security.config.SecurityDataBaseServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private SecurityDataBaseServer securityService;

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authBuilder =
                http.getSharedObject(AuthenticationManagerBuilder.class);

        authBuilder
                .userDetailsService(securityService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());

        return authBuilder.build();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/login").permitAll()
                        .requestMatchers("/manager").hasRole("MANAGER")
                        .requestMatchers("/users").hasAnyRole("MANAGER", "USER")
                        .anyRequest().authenticated()
                )
                .httpBasic(httpBasic -> {
                });

        return http.build();
    }

    //    @Bean
//    public UserDetailsService userDetailsService(PasswordEncoder encoder) {
//        UserDetails user = User.withUsername("nathan")
//                .password(encoder.encode("user123"))
//                .roles("MANAGER")
//                .build();
//
//        UserDetails user2 = User.withUsername("julia")
//                .password(encoder.encode("1234"))
//                .roles("USER")
//                .build();
//
//        UserDetails user3 = User.withUsername("maud")
//                .password(encoder.encode("1234"))
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, user2, user3);
//    }

}
