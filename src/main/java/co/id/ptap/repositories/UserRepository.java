package co.id.ptap.repositories;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import co.id.ptap.entities.User;


/**
 * User repository for CRUD operations.
 */
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
    
//    @Query(value="select u from User u where u.username = :username")
//	public User findByUsername(@Param("username")String username);
}
