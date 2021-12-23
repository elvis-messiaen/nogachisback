package fr.nogachi.services;

import fr.nogachi.dtos.user.UserDTO;
import fr.nogachi.dtos.user.UserDeleteDTO;
import fr.nogachi.dtos.user.UserSaveDTO;
import fr.nogachi.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(UserSaveDTO userSaveDTO);

    void delete(UserDeleteDTO userDeleteDTO);

    List<UserDTO> findAll();

    Optional<UserDTO> findById(Long id);

}
