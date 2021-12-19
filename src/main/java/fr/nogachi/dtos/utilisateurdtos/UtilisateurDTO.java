package fr.nogachi.dtos.utilisateurdtos;


import fr.nogachi.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UtilisateurDTO {

    private Long id;
    private String email;
    private String mdp;
    private Role role;
}
