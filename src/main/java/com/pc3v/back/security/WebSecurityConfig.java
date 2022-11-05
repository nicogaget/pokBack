package com.pc3v.back.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pc3v.back.security.jwt.AuthEntryPointJwt;
import com.pc3v.back.security.jwt.AuthTokenFilter;
import com.pc3v.back.servicesImpl.UserDetailsServiceImpl;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
    prePostEnabled = true)
public class WebSecurityConfig {

  private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);
  @Autowired
  UserDetailsServiceImpl userDetailsService;

  @Autowired
  private AuthEntryPointJwt unauthorizedHandler;

  @Bean
  public AuthTokenFilter authenticationJwtTokenFilter() {
    return new AuthTokenFilter();
  }


  private static final String[] AUTH_WHITELIST = {
          // -- Swagger UI v2
          "pok_back/v2/api-docs",
          "pok_back/swagger-resources",
          "pok_back/swagger-resources/**",
          "pok_back/configuration/ui",
          "pok_back/configuration/security",
          "pok_back/swagger-ui.html",
          "pok_back/webjars/**",
          // -- Swagger UI v3 (OpenAPI)
          "pok_back/v3/api-docs/**",
          "pok_back/swagger-ui/**"
          // other public endpoints of your API may be appended to this array
  };

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());

    return authProvider;
  }


  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
  logger.debug(http.toString());
    http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().authorizeRequests()
            .antMatchers(AUTH_WHITELIST).anonymous()
            .antMatchers("/api/auth/**").permitAll()
            .antMatchers("/api/test/**").permitAll()
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated();

    http.authenticationProvider(authenticationProvider());

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    return http.build();
  }


}
