package fr.nogachi.repository;



import fr.nogachi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    List<Role> findAll();

    Role findById(int id);

}
