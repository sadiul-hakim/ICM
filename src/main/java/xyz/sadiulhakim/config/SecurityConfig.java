package xyz.sadiulhakim.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import xyz.sadiulhakim.security.CustomUserDetailsService;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;

    public SecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        String[] permittedFiles = {
                "/css/**",
                "/js/**"
        };

        return http.authorizeHttpRequests(auth -> auth.requestMatchers(permittedFiles).permitAll())
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .formLogin(login -> login.defaultSuccessUrl("/", true))
                .userDetailsService(userDetailsService)
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
