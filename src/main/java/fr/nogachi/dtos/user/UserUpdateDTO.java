package fr.nogachi.dtos.user;


import fr.nogachi.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserUpdateDTO {

    private Long id;
    private String email;
    private String password;
    private Role role;
}
