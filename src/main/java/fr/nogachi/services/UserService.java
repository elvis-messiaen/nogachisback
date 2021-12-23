package fr.nogachi.services;

import fr.nogachi.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User save(User user);

    void deleteById(Long id);

    List<User> findAll();

    Optional<User> findById(Long id);

}
