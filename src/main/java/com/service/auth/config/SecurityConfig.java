/**
 * 
 */
package com.service.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Guruprasad.Todur
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public AuthenticationManager cusAuthenticationManager() throws Exception {
		return authenticationManager();
		
	}
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
     
        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("password")).roles("ADMIN");

    }
	
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
