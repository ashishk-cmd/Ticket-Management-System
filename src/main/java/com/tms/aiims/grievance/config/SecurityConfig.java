package com.tms.aiims.grievance.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;

import com.tms.aiims.grievance.security.CustomUserDetailService;
import com.tms.aiims.grievance.security.JwtAuthenticationEntryPoint;
import com.tms.aiims.grievance.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	
	public static final String[] PUBLIC_URLS= {
			"/api/v1/auth/**",
			"/v3/apis/docs",
			"/v2/api-docs",
			"/swagger-resources/**",
			"/swagger-ui/**",
			"/webjars/**",
			"/admin/**",
			"/admin/addGrievance",
			"/admin/get-department-list",
			"/admin/check-grievance-status",
			"/admin/verify-grievance-status",
			"/admin/verify_user",
			"/admin/get-employeeDetail",
			"/admin/logout",
			"/admin/register"
	};
	
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	        .csrf()
	        .disable()
	        .headers(headers -> headers.httpStrictTransportSecurity().maxAgeInSeconds(86400) // Max age 1 day
					.includeSubDomains(true) // Include sub domains
					.preload(false).and()
					// CSP
					.contentSecurityPolicy(
					(csp)->csp.policyDirectives("script-src 'self';").policyDirectives("style-src 'self';").policyDirectives("frame-src 'self';")
					// default-src 
					)
					
					// Permission Policy
					.addHeaderWriter((request, response) -> {
					response.setHeader("Permissions-Policy",
					" geolocation=(self)");
					//X-content
					response.setHeader("X-Content-Type-Options", "nosniff");
					})
					// Referrer Policy
					.referrerPolicy(ReferrerPolicyHeaderWriter.ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN)
					//xFrame
					)
        	.authorizeHttpRequests()
//        	.anyRequest().denyAll()
            .antMatchers(PUBLIC_URLS).permitAll()
//          .antMatchers("/").permitAll()      
            .anyRequest().authenticated()
            .and()
            .logout(logout -> logout
                    .logoutUrl("/logout")
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessUrl("/otp_auth?logout")
                    .clearAuthentication(true))
            .exceptionHandling().authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
	        .httpBasic();
	        http.cors();
	    http.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(this.customUserDetailService).passwordEncoder(passwordEncoder());
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	

	
}
