package com.graso.taco_cloud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(/* PasswordEncoder encoder */UserRepository userRepository) {
        /*
         * List<UserDetails> usersList = new ArrayList<>();
         * usersList.add(new User(
         * "buzz", encoder.encode("password"),
         * Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
         * usersList.add(new User(
         * "woody", encoder.encode("password"),
         * Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"))));
         * return (UserDetailsService) new InMemoryUserDetailsManager(usersList);
         */

        return username -> {
            User user = userRepository.findByUsername(username);
            if (user != null)
                return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers("/design", "/orders").hasRole("USER")
            .requestMatchers("/", "/**").permitAll()
        )
        .formLogin(form -> form
        
            .loginPage("/login")
            .defaultSuccessUrl("/design")
        )
        .oauth2Login(oauth -> oauth
        .loginPage("/login") 
        
        )
        .logout(logoutCustomizer -> logoutCustomizer
        .logoutSuccessUrl("./"));

        return http.build();
    
    }
    
}