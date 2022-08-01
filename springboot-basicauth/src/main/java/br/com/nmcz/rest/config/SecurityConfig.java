package br.com.nmcz.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Value("${security.user.name}")
	private String user;

	@Value("${security.user.password}")
	private String password;

	@Value("${security.user.roles}")
	private String roles;
	
    @Override
    protected void configure(HttpSecurity http) throws Exception 
    {
        http
         .csrf().disable()
         .authorizeRequests().anyRequest().authenticated()
         .and()
         .httpBasic();
    }
 
    
    @Autowired  
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser(user)
				.password(new BCryptPasswordEncoder().encode(password)).roles(roles);
	}
}