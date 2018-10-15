package co.id.ptap.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="oauth_access_token")
public class OauthAccessToken {
	
	@Column(name="authentication_id")
	@Id
	private String authenticationId;
	@Column(name="token_id")
	private String tokenId;
	private String token;
	@Column(name="user_name")
	private String username;
	@Column(name="client_id")
	private String clientId;
	private String authentication;
	@Column(name="refresh_token")
	private String refreshToken;
	
	public OauthAccessToken() {
		// TODO Auto-generated constructor stub
	}

	public OauthAccessToken(String authenticationId, String tokenId, String token, String username, String clientId,
			String authentication, String refreshToken) {
		super();
		this.authenticationId = authenticationId;
		this.tokenId = tokenId;
		this.token = token;
		this.username = username;
		this.clientId = clientId;
		this.authentication = authentication;
		this.refreshToken = refreshToken;
	}

	public String getAuthenticationId() {
		return authenticationId;
	}

	public void setAuthenticationId(String authenticationId) {
		this.authenticationId = authenticationId;
	}

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getAuthentication() {
		return authentication;
	}

	public void setAuthentication(String authentication) {
		this.authentication = authentication;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	
	

}
