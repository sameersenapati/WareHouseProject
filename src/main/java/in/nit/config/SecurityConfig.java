package in.nit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration

@EnableWebSecurity
public class SecurityConfig extends 
//a. link with Security Adapter
WebSecurityConfigurerAdapter{
	//b. link with UserDetailsService
	@Autowired
	private UserDetailsService service;
	//c. link with PasswrodEncoder
	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

	//d. provide method to verfiy un/pwd
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		super.configure(auth);
		auth.userDetailsService(service).passwordEncoder(pwdEncoder);
	}

	//e. provide method to verify roles,FormLoginPage, Logout details
	/**
	 *   Roles with URLs and Login Form Details and Logout Details 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);

		http.authorizeRequests()
		.antMatchers("/user/**").permitAll()
		.antMatchers("/uom/**","/whusertype/**",
				"/part/**","/ordermethod/**","/shipment/**")
		.hasAuthority("EMPLOYEE")

		.antMatchers("/po/**","/grn/**","/so/**","/shipping/**")
		.hasAuthority("ADMIN")

		//remaining URLS can be accessed by
		.anyRequest()
		.authenticated() //Who just login (no role required)

		.and()
		.formLogin() 
		.loginPage("/user/login") //URL to show login page
		.loginProcessingUrl("/login") //on click Form Login Submit
		.defaultSuccessUrl("/uom/register", true) //on login success
		.failureUrl("/user/login?error=true") //on login failure

		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) //link for Logout
		.logoutSuccessUrl("/user/login?logout=true"); //on logout success
	}
}


