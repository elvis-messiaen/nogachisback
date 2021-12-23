package fr.nogachi.dtos.utilisateurdtos;


import fr.nogachi.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UtilisateurSaveDTO {

    private String email;
    private String mdp;
    private Role role;
}