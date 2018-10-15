package co.id.ptap.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import co.id.ptap.entities.MstClientDetails;
import co.id.ptap.repositories.MstClientDetailsRepository;

@Service
public class MstClientDetailsSvcImpl implements ClientDetailsService{
	
	@Autowired
	private MstClientDetailsRepository mstClientDetailsRepository;

	@Override
	public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
		// TODO Auto-generated method stub
		MstClientDetails client = mstClientDetailsRepository.findClientByClientId(clientId);
		
//		String resourceIds = client.getResourceIds().stream().collect(Collectors.joining(","));
//		String scopes = client.getScope().stream().collect(Collectors.joining(","));
//		String grantTypes = client.getAuthorizedGrantTypes().stream().collect(Collectors.joining(","));
		//String authorities = client.getAuthorities().stream().collect(Collectors.joining(","));
		
		BaseClientDetails clientDetails = new BaseClientDetails(
				client.getClientId(),
				client.getResourceIds(),
				client.getScope(),
				client.getAuthorizedGrantTypes(),
				client.getAuthorities());
		clientDetails.setClientSecret(client.getClientSecret());
		clientDetails.setAccessTokenValiditySeconds(client.getAccessTokenValiditySeconds());
		clientDetails.setRefreshTokenValiditySeconds(client.getRefreshTokenValiditySeconds());

		String additionalInformation[] = client.getAdditionalInformation().split(",");
		Map<String, String> addInfo = new HashMap<>();
		for(String add : additionalInformation) {
			addInfo.put(add, add);
		}
		clientDetails.setAdditionalInformation(addInfo);
		String scopes[] = client.getScope().split(",");
		List<String> scopeList = new ArrayList<>();
		for(String s : scopes) {
			scopeList.add(s);
		}
		clientDetails.setAutoApproveScopes(scopeList);
		
		return clientDetails;
	}
	
	

}
