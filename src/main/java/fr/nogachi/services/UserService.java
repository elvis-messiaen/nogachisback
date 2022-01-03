package fr.nogachi.services;

import fr.nogachi.dtos.user.*;

import java.util.List;
import java.util.Optional;

public interface UserService {
    //UserDTO save(UserSaveDTO userSaveDTO);

    UserRoleDTO save(UserSaveDTO userSaveDTO);

    UserDTO update(UserUpdateDTO UserUpdateDTO);

    void delete(UserDeleteDTO userDeleteDTO);

    List<UserDTO> findAll();

    Optional<UserDTO> findById(Long id);

}
