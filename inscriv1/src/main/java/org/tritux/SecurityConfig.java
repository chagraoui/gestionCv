package org.tritux;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{


	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth,DataSource dataSource) throws Exception{		
	
//		auth.inMemoryAuthentication().withUser("admin").password("root").roles("admin");
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select login as principal,password as credentials,true from user where login=?")
		.authoritiesByUsernameQuery("select  login as principal,role as role from user where login=?")
		.rolePrefix("ROLE_");
	}

	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
//		.authorizeRequests()
//			.antMatchers("/app/**","/assets/**","/auth1").permitAll()
//			.anyRequest()
//				.authenticated()		
//				.and(),
//				.formLogin()
//				.loginPage("/index.html").permitAll();	
		
		http.formLogin().loginPage("/index.html").permitAll();
		http.authorizeRequests().antMatchers("/app/**","/assets/**","/**").permitAll().anyRequest().authenticated();
	//	http.formLogin().loginPage("/index.html").permitAll().and().logout().permitAll();
		
	}
}
