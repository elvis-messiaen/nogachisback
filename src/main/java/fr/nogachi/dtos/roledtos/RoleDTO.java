package fr.nogachi.dtos.roledtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class RoleDTO {

    private Long id;
    private String nom;
}
