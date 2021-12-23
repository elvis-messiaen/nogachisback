package fr.nogachi.services;

import fr.nogachi.dtos.user.UserDTO;
import fr.nogachi.dtos.user.UserDeleteDTO;
import fr.nogachi.dtos.user.UserSaveDTO;
import fr.nogachi.dtos.user.UserUpdateDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO save(UserSaveDTO userSaveDTO);

    UserDTO update(UserUpdateDTO UserUpdateDTO);

    void delete(UserDeleteDTO userDeleteDTO);

    List<UserDTO> findAll();

    Optional<UserDTO> findById(Long id);

}
