package co.id.ptap.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import co.id.ptap.services.MstClientDetailsSvcImpl;

/**
 * Configures the authorization server.
 * The @EnableAuthorizationServer annotation is used to configure the OAuth 2.0 Authorization Server mechanism,
 * together with any @Beans that implement AuthorizationServerConfigurer (there is a handy adapter implementation with empty methods).
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    @Qualifier("authenticationManagerBean")	//baruditambahin
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private Environment env;	//baruditambahin
    
    @Value("classpath:schema.sql")
    private Resource schemaScript;	//baruditambahin
    
    @Value("classpath:data.sql")
    private Resource dataScript;	//baruditambahin
    
    @Autowired
    private ClientDetailsService clientDetailsService;

    
//    @Autowired
//    private TokenStore tokenStore;

    /**
     * Setting up the endpointsconfigurer authentication manager.
     * The AuthorizationServerEndpointsConfigurer defines the authorization and token endpoints and the token services.
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
//        	.tokenStore(tokenStore)
                .authenticationManager(authenticationManager);
//    	final TokenEnhancerChain tokenEnhancherChain = new TokenEnhancerChain();
//    	tokenEnhancherChain.setTokenEnhancers(Arrays.asList(tokenEnhancer()));
//    	endpoints.tokenStore(tokenStore()).tokenEnhancer(tokenEnhancherChain).authenticationManager(authenticationManager);
    }

	/**
     * Setting up the clients with a clientId, a clientSecret, a scope, the grant types and the authorities.
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients
//                .inMemory()
//                .withClient("my-trusted-client")
//                .authorizedGrantTypes("client_credentials", "password")
//                .authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
//                .scopes("read","write","trust")
//                .resourceIds("oauth2-resource")
//                .accessTokenValiditySeconds(60)
//                .secret(passwordEncoder.encode("secret"));
    	clients.withClientDetails(clientDetailsService);
//    	clients.jdbc(dataSource());
    }

    /**
     * We here defines the security constraints on the token endpoint.
     * We set it up to isAuthenticated, which returns true if the user is not anonymous
     * @param security the AuthorizationServerSecurityConfigurer.
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
//        	.tokenKeyAccess("permitAll()")
                .checkTokenAccess("isAuthenticated()");
//    	security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }
    
//    @Bean
//    public DataSource dataSource() {
//    	DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    	dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
//    	dataSource.setUrl(env.getProperty("jdbc.url"));
//    	dataSource.setUsername(env.getProperty("jdbc.user"));
//    	dataSource.setPassword(env.getProperty("jdbc.pass"));
//    	
//    	return dataSource();
//    }
//    
//    @Bean
//    @Primary
//    public DefaultTokenServices tokenServices() {
//    	final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
//    	defaultTokenServices.setTokenStore(tokenStore());
//    	defaultTokenServices.setSupportRefreshToken(true);
//    	return defaultTokenServices;
//    }
//    
//    @Bean
//    public TokenStore tokenStore() {
//		// TODO Auto-generated method stub
//		return new JdbcTokenStore(dataSource());
//	}
//
//	@Bean
//    public TokenEnhancer tokenEnhancer() {
//		// TODO Auto-generated method stub
//		return new CustomTokenEnhancher();
//	}
	
//	@Bean
//	public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
//		final DataSourceInitializer initializer = new DataSourceInitializer();
//		initializer.setDataSource(dataSource);
//		initializer.setDatabasePopulator(databasePopulator());
//		
//		return initializer;
//	}
//	
//	private DatabasePopulator databasePopulator() {
//		final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
//		populator.addScript(schemaScript);
//		populator.addScript(dataScript);
//		
//		return populator;
//	}


}
