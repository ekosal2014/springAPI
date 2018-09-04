package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.demo.service.CustomUserService;


@Configuration
@EnableResourceServer
@Order(1)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	private static final String RESOURCE_ID = "resource_id";

	  @Autowired
      private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	  

		@Autowired
		private CustomUserService customUserService;
		
      @Autowired
      private CustomLogoutSuccessHandler customLogoutSuccessHandler;
      
      @Autowired
  	public void globalUserDetails(AuthenticationManagerBuilder auth ) throws Exception {
  		auth.userDetailsService(customUserService).passwordEncoder(encoder());
  			
  	} 
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		// TODO Auto-generated method stub
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	 @Override
	 public void configure(HttpSecurity http) throws Exception {
	       http.
	        anonymous().disable()
	        .authorizeRequests().antMatchers("/user/**").authenticated()
	        //.and().authorizeRequests()
	       // .antMatchers("/user/**").access("hasRole('ADMIN')")
	        .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
		 /*http
         .exceptionHandling()
         .authenticationEntryPoint(customAuthenticationEntryPoint)
         .and()
         .logout()
         .logoutUrl("/oauth/logout")
         .logoutSuccessHandler(customLogoutSuccessHandler)
         .and()
         .csrf()
         .requireCsrfProtectionMatcher(new AntPathRequestMatcher("/oauth/authorize"))
         .disable()
         .headers()
         .frameOptions().disable()
         .and()
         .sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
         .and()
         .authorizeRequests()
         .antMatchers("/hello/").permitAll()
         .antMatchers("/user/**").authenticated();*/

	        
	    }
	
	 @Bean
		public TokenStore tokenStore() {
			return new InMemoryTokenStore();
		}
		
		@Bean
		public BCryptPasswordEncoder encoder() {
			return new BCryptPasswordEncoder();
		}
		
		@Bean
		public FilterRegistrationBean corsFilter() {
			
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(true);
			config.addAllowedOrigin("*");
			config.addAllowedHeader("*");
			config.addAllowedMethod("*");
			source.registerCorsConfiguration("/**", config);
		
			FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
			
			bean.setOrder(0);
			
			return bean;
			
			
		}
	
}
