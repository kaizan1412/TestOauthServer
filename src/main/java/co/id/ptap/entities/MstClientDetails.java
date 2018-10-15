package co.id.ptap.entities;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Mst_Client_Details")
public class MstClientDetails {
	
	@Id
	private String id;
	
	@Column(name="client_id")
	private String clientId;
	
	@Column(name="client_secret")
	private String clientSecret;
	
	@Column(name="resource_ids")
	private String resourceIds;// = new HashSet<>();
	
	@Column(name="secret_required")
	private Boolean secretRequired;
	
	private Boolean scoped;
	
	private String scope;// = new HashSet<>();
	
	@Column(name="authorized_grant_types")
	private String authorizedGrantTypes;// = new HashSet<>();
	
	@Column(name="registered_redirect_uri")
	private String registeredRedirectUri;// = new HashSet<>();
	
	private String authorities;// = new HashSet<>();
	
	@Column(name="access_token_validity_seconds")
	private Integer accessTokenValiditySeconds;
	
	@Column(name="refresh_token_validity_seconds")
	private Integer refreshTokenValiditySeconds;
	
	@Column(name="auto_approve")
	private Boolean autoApprove;

	@Column(name="additional_information")
	private String additionalInformation;// = new HashMap<>();
	
	public MstClientDetails() {
		// TODO Auto-generated constructor stub
	}
	
	public MstClientDetails(String id, String clientId, String clientSecret, String resourceIds,
			Boolean secretRequired, Boolean scoped, String scope, String authorizedGrantTypes,
			String registeredRedirectUri, String authorities, Integer accessTokenValiditySeconds,
			Integer refreshTokenValiditySeconds, Boolean autoApprove, String additionalInformation) {
		super();
		this.id = id;
		this.clientId = clientId;
		this.clientSecret = clientSecret;
		this.resourceIds = resourceIds;
		this.secretRequired = secretRequired;
		this.scoped = scoped;
		this.scope = scope;
		this.authorizedGrantTypes = authorizedGrantTypes;
		this.registeredRedirectUri = registeredRedirectUri;
		this.authorities = authorities;
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
		this.autoApprove = autoApprove;
		this.additionalInformation = additionalInformation;
	}




	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public Boolean getSecretRequired() {
		return secretRequired;
	}

	public void setSecretRequired(Boolean secretRequired) {
		this.secretRequired = secretRequired;
	}

	public Boolean getScoped() {
		return scoped;
	}

	public void setScoped(Boolean scoped) {
		this.scoped = scoped;
	}

	public Integer getAccessTokenValiditySeconds() {
		return accessTokenValiditySeconds;
	}

	public void setAccessTokenValiditySeconds(Integer accessTokenValiditySeconds) {
		this.accessTokenValiditySeconds = accessTokenValiditySeconds;
	}

	public Integer getRefreshTokenValiditySeconds() {
		return refreshTokenValiditySeconds;
	}

	public void setRefreshTokenValiditySeconds(Integer refreshTokenValiditySeconds) {
		this.refreshTokenValiditySeconds = refreshTokenValiditySeconds;
	}

	public Boolean getAutoApprove() {
		return autoApprove;
	}

	public void setAutoApprove(Boolean autoApprove) {
		this.autoApprove = autoApprove;
	}

	public String getResourceIds() {
		return resourceIds;
	}

	public void setResourceIds(String resourceIds) {
		this.resourceIds = resourceIds;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	public void setAuthorizedGrantTypes(String authorizedGrantTypes) {
		this.authorizedGrantTypes = authorizedGrantTypes;
	}

	public String getRegisteredRedirectUri() {
		return registeredRedirectUri;
	}

	public void setRegisteredRedirectUri(String registeredRedirectUri) {
		this.registeredRedirectUri = registeredRedirectUri;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}
	

}
