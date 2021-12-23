package fr.nogachi.repositories;

import fr.nogachi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Messiaen ELVIS
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
