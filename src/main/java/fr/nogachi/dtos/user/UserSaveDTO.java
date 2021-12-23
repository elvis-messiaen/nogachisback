package fr.nogachi.dtos.user;


import fr.nogachi.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserSaveDTO {

    private String email;
    private String mdp;
    private Role role;
}
