package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{

	static final String CLIENT_ID          = "kosal-client"      ;
	static final String CLIENT_SECRET      = "kosal-secret"      ;
	static final String GRANT_TYPE         = "password"          ;
	static final String AUTHORIZATION_CODE = "authorization-code";
	static final String REFESH_TOKEN       = "refresh-token"     ;
	static final String IMPLICIT           = "implicit"          ;
	static final String SCOPE_READ         = "read"              ;
	static final String SCOPE_WRITE        = "write"             ;
	static final String TRUST              = "trust"             ;
	static final int    ACCESS_TOKEN_VALIDITY_SECONDS  = 1*60*60 ;
	static final int    FREFRESH_TOKEN_VILIDITY_SECONDS= 6*60*60 ;
	
	@Autowired
	private TokenStore tokenStore;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	 @Override
   public void configure(
     AuthorizationServerSecurityConfigurer oauthServer) 
     throws Exception {
       oauthServer
         .tokenKeyAccess("permitAll()")
         .checkTokenAccess("isAuthenticated()");
    }

	@Override
	public void configure(ClientDetailsServiceConfigurer configurer) throws Exception{
		
		configurer.inMemory()
				  .withClient(CLIENT_ID)
				  .secret(CLIENT_SECRET)
				  .authorizedGrantTypes(GRANT_TYPE,AUTHORIZATION_CODE,REFESH_TOKEN,IMPLICIT)
				  .scopes(SCOPE_READ,SCOPE_WRITE,TRUST)
				  .accessTokenValiditySeconds(ACCESS_TOKEN_VALIDITY_SECONDS)
				  .refreshTokenValiditySeconds(FREFRESH_TOKEN_VILIDITY_SECONDS);
	}

	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		// TODO Auto-generated method stub
		endpoints.tokenStore(tokenStore).authenticationManager(authenticationManager);//tokenEnhancer(new CustomTokenEnhancer());
	}
	

	
	
}
