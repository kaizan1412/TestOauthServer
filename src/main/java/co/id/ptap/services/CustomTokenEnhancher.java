package co.id.ptap.services;

import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Service;

@Service
public class CustomTokenEnhancher
	implements TokenEnhancer{

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken arg0, OAuth2Authentication arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
