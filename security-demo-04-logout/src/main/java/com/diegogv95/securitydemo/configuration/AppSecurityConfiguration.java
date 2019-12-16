package com.diegogv95.securitydemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Add our users for in memory authentication
        UserBuilder users = User.withDefaultPasswordEncoder();

        auth.inMemoryAuthentication()
                .withUser(users.username("Diego").password("1234").roles("ADMIN"))
                .withUser(users.username("Pepito").password("1234").roles("EMPLOYEE"))
                .withUser(users.username("Jaimito").password("1234").roles("MANAGER"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure security of web paths in application, login, logout, etc
        http.authorizeRequests()
                .anyRequest().authenticated() // Any request must be authenticated
                .and()
                .formLogin().permitAll() // Allow everyone to see the login page
                .and()
                .logout().permitAll();
                // Custom Login is not working!
                /*.formLogin()
                    .loginPage("/showMyLoginPage") //GetMapping url in the LoginController
                    .loginProcessingUrl("/authenticateTheUser") // this URL will be handled by Spring Security Filters (no coding required)
                    .permitAll(); // Allow everyone to see the login page*/
    }
}
