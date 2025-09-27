package com.example.BaiTap05.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authz -> authz
                .requestMatchers("/admin/**").hasRole("ADMIN")  // Chỉ admin truy cập CRUD
                .requestMatchers("/profile").authenticated()    // User login để xem profile
                .anyRequest().permitAll()                       // Các trang khác public
        ).formLogin(form -> form.defaultSuccessUrl("/profile", true))
          .logout(logout -> logout.logoutSuccessUrl("/"));
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        @SuppressWarnings("deprecation")
		UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin").password("admin123").roles("ADMIN").build();
        return new InMemoryUserDetailsManager(admin);  // Sử dụng in-memory, sau có thể dùng DB
    }
}