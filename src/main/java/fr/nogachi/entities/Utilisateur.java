package fr.nogachi.entities;
/**
 * @author Messaien ELVIS
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String email;

    @Size(min = 8, max = 40)
    @Column(name = "motDePasse", nullable = false, length = 40)
    private String mdp;

    @OneToOne
    private Role role;
}
