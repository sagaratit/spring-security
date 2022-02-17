package com.example.springsecurity.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests().antMatchers("/","/api").permitAll().anyRequest().authenticated().and().logout().permitAll();
    }

    protected UserDetailsService userDetailService(){
        UserDetails user = User.withDefaultPasswordEncoder().password("pass").username("sagar").roles("USER").build();

        return new InMemoryUserDetailsManager(user);
    }
}
