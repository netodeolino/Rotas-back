package br.deolino.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JWTAuthenticationFilter service;
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        
        http.headers().cacheControl().disable();
    	
    	http.cors().disable();
    	
        http.authorizeRequests()
        		.antMatchers("/images/**", "/usuario/login").permitAll()
        		.antMatchers("/**").authenticated()
        		.and()
                .addFilterBefore(service, UsernamePasswordAuthenticationFilter.class);
    }

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //vazio
    }
}

