package com.diegogv95.securitydemo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

import javax.sql.DataSource;

@Configuration
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource securityDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(securityDataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Configure security of web paths in application, login, logout, etc
        http.authorizeRequests()
                .antMatchers("/").permitAll() // this url will be public for all the users
                .antMatchers("/employees").hasRole("EMPLOYEE") // this url will be public only for employees
                .antMatchers("/leaders/**").hasRole("MANAGER") // this url will be public only for managers
                .antMatchers("/systems/**").hasRole("ADMIN") // this url will be public only for admins
                .and()
                .formLogin().permitAll() // Allow everyone to see the login page
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedPage("/error-page"); // go to this url when role access denied
    }
}
