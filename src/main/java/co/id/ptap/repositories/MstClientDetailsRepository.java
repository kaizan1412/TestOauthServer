package co.id.ptap.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.id.ptap.entities.MstClientDetails;

public interface MstClientDetailsRepository extends JpaRepository<MstClientDetails, String> {
	
	@Query(value="select a from MstClientDetails a where a.clientId = :clientId")
	public MstClientDetails findClientByClientId
	(@Param("clientId")String clientId);
	

}
