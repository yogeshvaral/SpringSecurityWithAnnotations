package org.mystudy.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().
		antMatchers("/403").access("permitAll").
		antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/user").access("hasRole('ROLE_USER')");
		http.formLogin().loginPage("/login").failureUrl("/login?error");
		http.rememberMe().rememberMeParameter("remember-me")
		.tokenValiditySeconds(50000).key("anyKey").tokenRepository(tokenRepository());
		http.exceptionHandling().accessDeniedPage("/403");
		http.logout().logoutUrl("/").logoutUrl("/")
		.invalidateHttpSession(true);
	}

	private PersistentTokenRepository tokenRepository() {
		JdbcTokenRepositoryImpl repository = new JdbcTokenRepositoryImpl();
		repository.setDataSource(dataSource);
		return repository;
	}
}