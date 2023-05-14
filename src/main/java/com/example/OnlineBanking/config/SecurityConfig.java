package com.example.OnlineBanking.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    //authentication
    @Bean
    public UserDetailsService userDetailsService(){
//    public UserDetailsService userDetailsService(PasswordEncoder encoder){
//        UserDetails admin = User.withUsername("Bella")
//                .password(encoder.encode("bella"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withUsername("Zack")
//                .password(encoder.encode("zack"))
//                .roles("USER")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
        return new myUserDetailsService();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //authorization
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/","/users/all","/users/add").permitAll()
//                .and()
//                .authorizeHttpRequests().requestMatchers("/users/**")
//                .authenticated()
//                .and().formLogin()
////                .loginPage("login")
//                .and().build();
        return http.csrf().disable()
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/", "/users/all", "/users/add", "/users/addMany").permitAll()
                        .requestMatchers("/users/id/**").hasRole("ADMIN")
                        .requestMatchers("/users/**").authenticated()
                        .anyRequest().permitAll()
                )

                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/aboutus", true)
                .and().build();


    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
}
