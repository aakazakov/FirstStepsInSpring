package com.learnspring.firstsimplesecureapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learnspring.firstsimplesecureapp.domain.Role;
import com.learnspring.firstsimplesecureapp.service.UserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  
  private UserService userService;
  
  @Autowired
  public void setUserDetailsService(UserService userService) {
    this.userService = userService;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers("/catalog","/catalog/**").hasAnyAuthority(Role.ADMIN.name(), Role.MANAGER.name())
      .antMatchers("/users").hasAuthority(Role.ADMIN.name())
      .antMatchers("/").permitAll()
      .and()
      .formLogin()
      .and()
      .logout().logoutSuccessUrl("/");
  }
  
  @Bean
  public DaoAuthenticationProvider provider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder());
    provider.setUserDetailsService(userService);
    return provider;
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
